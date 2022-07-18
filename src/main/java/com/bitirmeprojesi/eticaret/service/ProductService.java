package com.bitirmeprojesi.eticaret.service;


import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.entity.Discount;
import com.bitirmeprojesi.eticaret.entity.Product;
import com.bitirmeprojesi.eticaret.entity.ProductCategory;
import com.bitirmeprojesi.eticaret.entity.ProductInventory;
import com.bitirmeprojesi.eticaret.exception.model.DefaultException;
import com.bitirmeprojesi.eticaret.model.request.DeleteEntityByName;
import com.bitirmeprojesi.eticaret.model.request.DiscountToProductFormRequest;
import com.bitirmeprojesi.eticaret.model.request.ProductRequest;
import com.bitirmeprojesi.eticaret.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Value("${image.uploadpath}")
    private String UPLOAD_PATH;
    @Value("${image.uploaextension}")
    private String UPLOAD_FILE_EXTENSION;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ModelMapper modelMapper;



    public Product createProduct(ProductRequest request) throws IOException {
        if (request.getName() == null) {
            throw new DefaultException("Ürün ismi boş geçilemez!");
        }
        if (request.getPrice() == null) {
            throw new DefaultException("Ürün fiyatı boş geçilemez!");
        }
        if (request.getCategory_name() == null) {
            throw new DefaultException("Ürün kategorisi boş geçilemez!");
        }
        Product product= productRepository.findByName(request.getName());
        if (product != null) {
            throw new DefaultException("Bu ürün zaten mevcut!");
        }
        ProductCategory category = categoryService.findByName(request.getCategory_name());
        if (category == null) {
            throw new DefaultException("Kategori bulunamadı!");
        }
        product = modelMapper.map(request,Product.class);
        if (request.getDiscount_id() != null) {
            Discount discount= discountService.findById(request.getDiscount_id());
            if (discount == null) {
                throw new DefaultException("İndirim bulunamadı!");
            }
            product.setDiscount(discount);
        }
        Discount discount = discountService.findById(1L);
        product.setDiscount(discount);
        request.getImage().transferTo(new File(UPLOAD_PATH+request.getName().replace(" ","-")+UPLOAD_FILE_EXTENSION));
        product.setImage_url(UPLOAD_PATH+request.getName()+UPLOAD_FILE_EXTENSION);
        product.setProduct_category(category);
        product.setId(null);
        ProductInventory productInventory= new ProductInventory();
        productInventory = inventoryService.save(productInventory);
        product.setProduct_inventory(productInventory);
        return productRepository.save(product);
    }

    public void deleteProduct(DeleteEntityByName request) {

        Product deletedProduct = productRepository.findByName(request.getName());
        if (deletedProduct == null) {
            throw new DefaultException("Ürün bulunamadı!");
        }
        productRepository.delete(deletedProduct);
    }

    public Product updateProduct(ProductRequest request){
        if (request.getId() == null) {
            throw new DefaultException("Id boş geçilemez!");
        }
        Product product = productRepository.findById(request.getId()).orElse(null);
        if (product == null) {
            throw new DefaultException("Ürün bulunamadı!");
        }
        if (request.getName() != null) {
            product.setName(request.getName());
        }if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }if (request.getCategory_name() != null) {
            ProductCategory category =categoryService.findByName(request.getCategory_name());
            product.setProduct_category(category);
        }if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        return this.saveProduct(product);

    }

    public Product findByName(String name){
        Product product = productRepository.findByName(name);
        if (product == null) {
            throw new DefaultException("Ürün bulunamadı!");
        }
        return product;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product discountToProduct(DiscountToProductFormRequest request) {
        Product product = this.findByName(request.getProduct_name());
        Discount discount = discountService.findById(request.getDiscount_id());
        product.setDiscount(discount);
        return this.saveProduct(product);
    }

    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }
}
