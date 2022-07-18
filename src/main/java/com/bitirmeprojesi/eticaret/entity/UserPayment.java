package com.bitirmeprojesi.eticaret.entity;


import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_payment")
@Data
public class UserPayment extends BaseEntity {
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private User user;
    @Column(nullable = false)
    private String provider;
    @Column(nullable = false)
    private String account_no;

}
