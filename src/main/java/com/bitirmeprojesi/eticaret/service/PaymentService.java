package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.UserAddress;
import com.bitirmeprojesi.eticaret.entity.UserPayment;
import com.bitirmeprojesi.eticaret.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public UserPayment save(UserPayment payment) {
        return paymentRepository.save(payment);

    }


}
