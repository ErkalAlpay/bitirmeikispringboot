package com.bitirmeprojesi.eticaret.exception.model;

public class PasswordMatchRepasswordException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Şifreler eşleşmiyor!";
    }
}
