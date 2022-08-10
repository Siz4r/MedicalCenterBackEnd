package com.example.demo.Orders;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Orders.models.Order;
import com.example.demo.Orders.models.OrderCommand;
import com.example.demo.Orders.models.OrderListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private final IdGenerator idGenerator;
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    public UUID createOrder(OrderCommand command) {
        return orderRepository.save(Order.builder()
                .id(idGenerator.generateId())
                .name(command.getWebInput().getName())
                .researchesResults(new LinkedHashSet<>())
                .build()).getId();
    }

    public Set<OrderListDTO> getOrders() {
        return orderRepository.findAll().stream()
                .map(o -> mapper.map(o, OrderListDTO.class))
                .collect(Collectors.toSet());
    }

    public void deleteById(OrderCommand command) {
        orderRepository.deleteById(command.getId());
    }

    public void deleteAllById(OrderCommand command) {
        orderRepository.deleteAllById(command.getIds());
    }

    public void updateOrder(OrderCommand command) {
        var order = orderRepository.findById(command.getId()).orElseThrow(IncorrectIdInputException::new);
        order.setName(command.getWebInput().getName());
        orderRepository.save(order);
    }
}
