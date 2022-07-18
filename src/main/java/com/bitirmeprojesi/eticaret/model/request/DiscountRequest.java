package com.bitirmeprojesi.eticaret.model.request;

import lombok.Data;


@Data
public class DiscountRequest {
    private String name;
    private String description;
    private Integer percent;
}
