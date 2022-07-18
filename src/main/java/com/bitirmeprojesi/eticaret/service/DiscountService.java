package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.Discount;
import com.bitirmeprojesi.eticaret.entity.Product;
import com.bitirmeprojesi.eticaret.exception.model.DefaultException;
import com.bitirmeprojesi.eticaret.model.request.DiscountRequest;
import com.bitirmeprojesi.eticaret.model.request.DiscountToProductFormRequest;
import com.bitirmeprojesi.eticaret.repository.DiscountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;


    public Discount findById(Long id) {
        Discount discount = discountRepository.findById(id).orElse(null);
        if (discount == null) {
            throw new DefaultException("İndirim bulunamadı!");
        }
        return discount;
    }

    public Discount createDiscount(DiscountRequest request) {
        Discount discount = discountRepository.findByName(request.getName());
        if (discount != null) {
            throw new DefaultException("İndirim zaten mevcut. Lütfen indirimi güncellemeyi deneyin!");
        }
        discount = modelMapper.map(request, Discount.class);
        return discountRepository.save(discount);
    }
    public Discount discountToActivate(Long id) {
        Discount discount = discountRepository.findById(id).orElse(null);
        discount.setActive(true);
        return discountRepository.save(discount);
    }
    public Discount discountToDeActivate(Long id) {
        Discount discount = discountRepository.findById(id).orElse(null);
        discount.setActive(false);
        return discountRepository.save(discount);
    }


}
