package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id","payment_id"})
})
@Data
public class Order extends BaseEntity {
    @Column(nullable = false)
    private BigDecimal total;
    @ManyToOne(optional = false)
    private User user;
    @OneToOne(optional = false)
    private PaymentDetail payment;
}
