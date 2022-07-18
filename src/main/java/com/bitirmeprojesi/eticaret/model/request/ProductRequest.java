package com.bitirmeprojesi.eticaret.model.request;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category_name;
    private Long discount_id;
    private Integer quantity;
    private MultipartFile image;
}
