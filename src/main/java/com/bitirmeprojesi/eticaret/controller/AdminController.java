package com.bitirmeprojesi.eticaret.controller;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.entity.Discount;
import com.bitirmeprojesi.eticaret.entity.Product;
import com.bitirmeprojesi.eticaret.entity.ProductCategory;
import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.model.request.*;
import com.bitirmeprojesi.eticaret.service.CategoryService;
import com.bitirmeprojesi.eticaret.service.DiscountService;
import com.bitirmeprojesi.eticaret.service.ProductService;
import com.bitirmeprojesi.eticaret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DiscountService discountService;


    @GetMapping("/users")
    public ResponseEntity<BaseResponse<List<User>>> getUserList() {
        List<User> userList = userService.getUsers();
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setMessages("Başarılı");
        baseResponse.setSuccess(true);
        baseResponse.setData(userList);
        return ResponseEntity.ok(baseResponse);
    }
    @PostMapping("/create-category")
    public ResponseEntity<BaseResponse<ProductCategory>> createCategory(@RequestBody CategoryRequest request) {
        ProductCategory productCategory = categoryService.createCategory(request);
        BaseResponse response = new BaseResponse<>();
        response.setMessages("Kategori başarıyla oluşturuldu!");
        response.setSuccess(true);
        response.setData(productCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/create-product")
    public ResponseEntity<BaseResponse<Product>> createProduct(ProductRequest request) throws IOException {
        Product product = productService.createProduct(request);
        BaseResponse response = new BaseResponse<>();
        response.setMessages("Ürün başarıyla oluşturuldu!");
        response.setSuccess(true);
        response.setData(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestBody DeleteEntityByName request) {
        productService.deleteProduct(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update-product")
    public ResponseEntity<BaseResponse<Product>> deleteProduct(@RequestBody ProductRequest request) {
        Product product = productService.updateProduct(request);
        BaseResponse response = new BaseResponse();
        response.setData(product);
        response.setSuccess(true);
        response.setMessages("Ürün başarıyla güncellendi.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/discount-to-product")
    public ResponseEntity<BaseResponse<Product>> discountToProduct(@RequestBody DiscountToProductFormRequest request) {
        Product product = productService.discountToProduct(request);
        BaseResponse response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(product);
        response.setMessages("İndirim başarıyla eklenmiştir");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/create-discount")
    public ResponseEntity<BaseResponse<Discount>> createDiscount(@RequestBody DiscountRequest request) {
        Discount discount = discountService.createDiscount(request);
        BaseResponse response = new BaseResponse();
        response.setData(discount);
        response.setMessages("İndirim başarıyla oluşturuldu");
        response.setSuccess(true);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/activated-discount/{id}")
    public ResponseEntity<BaseResponse<Discount>> activatedDiscount(@PathVariable("id") Long id) {
        // TODO: 30.06.2022 düzeltilecek
        Discount discount = discountService.discountToActivate(id);
        BaseResponse response = new BaseResponse<>();
        response.setMessages("İnidirim başarıyla aktif edildi");
        response.setSuccess(true);
        response.setData(discount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/deactivated-discount/{id}")
    public ResponseEntity<BaseResponse<Discount>> deActivatedDiscount(@PathVariable("id") Long id) {
        // TODO: 30.06.2022 düzeltilecek
        Discount discount = discountService.discountToDeActivate(id);
        BaseResponse response = new BaseResponse<>();
        response.setMessages("İnidirim başarıyla deaktif edildi");
        response.setSuccess(true);
        response.setData(discount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
