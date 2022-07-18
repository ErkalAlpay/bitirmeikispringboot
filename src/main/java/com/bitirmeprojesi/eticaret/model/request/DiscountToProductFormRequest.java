package com.bitirmeprojesi.eticaret.model.request;

import lombok.Data;

@Data
public class DiscountToProductFormRequest {
    private String product_name;
    private Long discount_id;
}
