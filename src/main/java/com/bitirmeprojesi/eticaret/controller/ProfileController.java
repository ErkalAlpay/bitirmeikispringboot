package com.bitirmeprojesi.eticaret.controller;

import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.entity.UserAddress;
import com.bitirmeprojesi.eticaret.model.dto.AddressDto;
import com.bitirmeprojesi.eticaret.model.dto.PaymentDto;
import com.bitirmeprojesi.eticaret.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProfileController  {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/create-address")
    public ResponseEntity<BaseResponse<AddressDto>> createAddress(@Valid @RequestBody AddressDto addressDto){
        AddressDto data = profileService.createUserAddress(addressDto);
        BaseResponse<AddressDto> response = new BaseResponse<>();
        response.setData(data);
        response.setMessages("Adres başarıyla eklendi.");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/create-payment")
    public ResponseEntity<BaseResponse<PaymentDto>> createPayment(@Valid @RequestBody PaymentDto paymentDto){
        PaymentDto data = profileService.createPayment(paymentDto);
        BaseResponse<PaymentDto> response = new BaseResponse<>();
        response.setData(data);
        response.setMessages("Ödeme yöntemi başarıyla eklendi.");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
