package com.bitirmeprojesi.eticaret.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.exception.model.DefaultException;
import com.bitirmeprojesi.eticaret.exception.model.PasswordMatchRepasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> argumentValidException(MethodArgumentNotValidException e) {
        BaseResponse baseResponse = new BaseResponse<>();
        String errorMessage ="";
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            errorMessage+=error.getDefaultMessage()+",";
        }
        baseResponse.setMessages(errorMessage);
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = PasswordMatchRepasswordException.class)
    public ResponseEntity<BaseResponse<?>> passwordMatchRepasswordException(PasswordMatchRepasswordException e) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setMessages(e.getMessage());
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }


    //---------- Varsayılan hata kontrolü!
    @ExceptionHandler(value = DefaultException.class)
    public ResponseEntity<BaseResponse<?>> defaultException(DefaultException e) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setMessages(e.getMessage());
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    //---- Spring tarafından fırlatılan hataların karşılıkları!!
    @ExceptionHandler(value = JWTVerificationException.class)
    public ResponseEntity<BaseResponse<?>> jwtVerificationException(JWTVerificationException e) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setMessages("Token hatalı. Lütfen yeniden kayıt olun.");
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BaseResponse<?>> exception() {
        BaseResponse response = new BaseResponse();
        response.setMessages("Bilinmeyen bir hata oluştu...");
        response.setSuccess(false);
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
