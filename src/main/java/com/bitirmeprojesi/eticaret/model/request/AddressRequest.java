package com.bitirmeprojesi.eticaret.model.request;

import lombok.Data;


@Data
public class AddressRequest {

    private String address_line_1;
    private String address_line_2;
    private String city;
    private String country;
    private String telephone;
}
