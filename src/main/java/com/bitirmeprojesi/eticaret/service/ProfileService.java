package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.entity.UserAddress;
import com.bitirmeprojesi.eticaret.entity.UserPayment;
import com.bitirmeprojesi.eticaret.model.dto.AddressDto;
import com.bitirmeprojesi.eticaret.model.dto.PaymentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthService authService;
    @Autowired
    private PaymentService paymentService;




    public AddressDto createUserAddress(AddressDto addressDto){
        User user =  authService.getAuthUser();
        UserAddress address = modelMapper.map(addressDto,UserAddress.class);
        address.setUser(user);
        UserAddress userAddress = addressService.save(address);
        return modelMapper.map(userAddress,AddressDto.class);
    }

    public PaymentDto createPayment(PaymentDto paymentDto) {
        User user =  authService.getAuthUser();
        UserPayment payment = modelMapper.map(paymentDto,UserPayment.class);
        payment.setUser(user);
        UserPayment userPayment = paymentService.save(payment);
        return modelMapper.map(userPayment,PaymentDto.class);
    }
}
