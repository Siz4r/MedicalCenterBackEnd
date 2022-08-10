package com.example.demo.Orders;

import com.example.demo.Orders.models.OrderCommand;
import com.example.demo.Orders.models.OrderListDTO;
import com.example.demo.Orders.models.OrderWebInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<OrderListDTO> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createOrder(@Valid @RequestBody OrderWebInput webInput) {
        return orderService.createOrder(OrderCommand.builder()
                .webInput(webInput).build());
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Resource updated successfully")
    public void updateOrder(@Valid @RequestBody OrderWebInput webInput, @PathVariable("id") UUID id) {
        orderService.updateOrder(OrderCommand.builder()
                .webInput(webInput)
                .id(id).build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") UUID id) {
        orderService.deleteById(OrderCommand.builder().id(id).build());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProjects(@RequestBody Set<UUID> ids) {
        orderService.deleteAllById(OrderCommand.builder().ids(ids).build());
    }

}
