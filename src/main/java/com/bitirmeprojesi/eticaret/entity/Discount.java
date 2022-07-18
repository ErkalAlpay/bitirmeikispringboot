package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "discount")
@Data
public class Discount extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private Integer percent;
    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean active=false;





}
