package com.bitirmeprojesi.eticaret.model.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class AddressDto {
    @NotBlank(message = "{address.not.empty}")
    private String address_line_1;
    private String address_line_2;
    @NotBlank(message = "{city.not.empty}")
    private String city;
    @NotBlank(message = "{country.not.empty}")
    private String country;
    @NotBlank(message = "{telephone.not.empty}")
    private String telephone;
}
