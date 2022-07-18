package com.bitirmeprojesi.eticaret.exception.model;

public class UnverifiedEmailException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Lütfen email adresiniz doğrulayın!";
    }
}
