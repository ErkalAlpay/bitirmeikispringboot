package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import com.bitirmeprojesi.eticaret.model.enums.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment_detail")
@Data
public class PaymentDetail extends BaseEntity {
    @Column(nullable = false,columnDefinition = "Decimal(10,2) default '0.00'")
    private BigDecimal amount;
    @Column(nullable = false)
    private String provider;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "integer default 0")
    private PaymentStatus status=PaymentStatus.WAIT;
}
