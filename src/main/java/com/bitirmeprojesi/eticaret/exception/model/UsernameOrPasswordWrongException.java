package com.bitirmeprojesi.eticaret.exception.model;

public class UsernameOrPasswordWrongException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Kullanıcı adı veya şifre hatalı!";
    }
}
