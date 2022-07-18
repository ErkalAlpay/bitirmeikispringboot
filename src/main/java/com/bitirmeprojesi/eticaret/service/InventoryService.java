package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.ProductInventory;
import com.bitirmeprojesi.eticaret.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private ProductInventoryRepository inventoryRepository;


    public ProductInventory save(ProductInventory productInventory){
        return inventoryRepository.save(productInventory);
    }
}
