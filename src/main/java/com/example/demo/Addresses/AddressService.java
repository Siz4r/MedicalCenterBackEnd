package com.example.demo.Addresses;

import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final IdGenerator idGenerator;
    private final ModelMapper modelMapper;

    public Address addAddress(AddressWebInput webInput) {
        var id = idGenerator.generateId();

        var address = modelMapper.map(webInput, Address.class);
        address.setId(id);

        return addressRepository.save(address);
    }
}
