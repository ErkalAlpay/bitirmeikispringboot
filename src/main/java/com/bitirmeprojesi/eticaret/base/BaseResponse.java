package com.bitirmeprojesi.eticaret.base;



import lombok.Data;

@Data
public class BaseResponse<T> {
    private Boolean success;
    private String messages;
    private T data;
}
