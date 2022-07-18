package com.bitirmeprojesi.eticaret.model.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryRequest {
    @NotNull(message = "{message.notnull}")
    private String name;
    private String description;
}
