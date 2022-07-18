package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.ProductCategory;
import com.bitirmeprojesi.eticaret.exception.model.DefaultException;
import com.bitirmeprojesi.eticaret.model.request.CategoryRequest;
import com.bitirmeprojesi.eticaret.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductCategory createCategory(CategoryRequest request) {
        if (request.getName() == null) {
            throw new DefaultException("Lütfen kategori adını giriniz!");
        }
        ProductCategory category = categoryRepository.findByName(request.getName());
        if (category != null) {
            throw new DefaultException("Bu kategori zaten mevcut!");
        }
        ProductCategory savedCategory = modelMapper.map(request,ProductCategory.class);
        return categoryRepository.save(savedCategory);
    }

    public ProductCategory findByName(String categoryname){
        ProductCategory category =  categoryRepository.findByName(categoryname);
        if (category == null) {
            throw new DefaultException("Kategori bulunamadı");
        }
        return categoryRepository.findByName(categoryname);
    }
}
