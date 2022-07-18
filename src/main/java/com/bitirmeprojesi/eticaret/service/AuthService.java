package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.exception.model.EmailVerifyTokenException;
import com.bitirmeprojesi.eticaret.model.dto.UserDto;
import com.bitirmeprojesi.eticaret.model.env.Environment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private  UserService userService;
    @Autowired
    private  JWTService jwtService;
    @Autowired
    private  MailService mailService;
    @Autowired
    private ModelMapper modelMapper;


    public User getAuthUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        return userService.getUser(username);
    }


    public void userRegister(UserDto userDto) throws MessagingException, IOException {
        userDto.checkPassword();
        User user = modelMapper.map(userDto,User.class);
        userService.saveUser(user);
        String jwt = jwtService.verifyJwtToken(user.getUsername());
        String mailBody = Environment.BASE_URL.getText()+"/api/verify-email?token="+jwt;
        HashMap<String,String> exchange = new HashMap<>();
        exchange.put("jwtverify",mailBody);
        mailService.sendEmailHtml(user.getEmail(),"Doğrulama Maili",exchange);
    }


    public void userVerifyEmail(Optional<String> optionalJwt){
        String jwt = optionalJwt.orElse(null);
        if (jwt == null) {
            throw  new EmailVerifyTokenException();
        }
        String username = jwtService.getSubject(jwt);
        if (username == null) {
            throw new EmailVerifyTokenException();
        }
        userService.updateUserEmailStatus(username,true);
    }



}
