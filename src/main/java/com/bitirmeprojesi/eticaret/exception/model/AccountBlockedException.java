package com.bitirmeprojesi.eticaret.exception.model;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;


public class AccountBlockedException extends RuntimeException{
    //private MessageSource messageSource;
    @Override
    public String getMessage() {
      //  return messageSource.getMessage("default",new Object[]{},"dfg", LocaleContextHolder.getLocale());
        return "Hesabınız engellendi!";
    }
}
