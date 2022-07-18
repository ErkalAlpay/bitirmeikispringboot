package com.bitirmeprojesi.eticaret.controller;


import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.entity.UserAddress;
import com.bitirmeprojesi.eticaret.model.dto.UserDto;
import com.bitirmeprojesi.eticaret.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws MessagingException, IOException {
        authService.userRegister(userDto);
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/verify-email")
    public ResponseEntity<BaseResponse<?>> verifyEmail(@RequestParam Optional<String> token){
        authService.userVerifyEmail(token);
        BaseResponse response = new BaseResponse();
        response.setMessages("Email başarıyla doğrulandı");
        response.setSuccess(true);
        return new  ResponseEntity<>(response,HttpStatus.OK);
    }






}
