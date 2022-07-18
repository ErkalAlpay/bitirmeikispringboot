package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_inventory")
@Data
public class ProductInventory extends BaseEntity {

    @Column(nullable = false,columnDefinition = "integer default 0")
    private Integer quantity=0;
}
