package com.bitirmeprojesi.eticaret.exception.model;

public class EmailVerifyTokenException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Geçersiz bağlantı. Lütfen tekrar kayıt olunuz.";
    }
}
