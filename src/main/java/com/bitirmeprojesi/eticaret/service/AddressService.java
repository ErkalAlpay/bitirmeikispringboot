package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.UserAddress;
import com.bitirmeprojesi.eticaret.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public UserAddress save(UserAddress address) {
        return addressRepository.save(address);

    }
}
