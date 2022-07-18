package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_item",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id","product_id"})
})
@Data
public class OrderItem extends BaseEntity {

    @Column(nullable = false,columnDefinition = "integer default 1")
    private Integer quantity;

    //---
    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private Product product;

    //----

}
