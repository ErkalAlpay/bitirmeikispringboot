package com.bitirmeprojesi.eticaret.model.dto;

import com.bitirmeprojesi.eticaret.entity.User;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Validated
@Data
public class PaymentDto {
    @NotBlank(message = "Lütfen Banka Sağlayıcınızı belirtiniz!")
    private String provider;
    @NotBlank(message = "Lütfen IBAN numaranızı doğru giriniz!")
    private String account_no;
}
