package com.bitirmeprojesi.eticaret.controller;

import com.bitirmeprojesi.eticaret.base.BaseResponse;
import com.bitirmeprojesi.eticaret.entity.Product;
import com.bitirmeprojesi.eticaret.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Value("${image.uploadpath}")
    private String PATH;
    @Value("${image.uploaextension}")
    private String EXTENSION;
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<BaseResponse<List<Product>>> getAllProduct(){
        List<Product> data = productService.getAllProduct();
        BaseResponse<List<Product>> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setMessages("Veriler başarıyla getirildi");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> image(@PathVariable(value = "imageName") String imageName) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(PATH+imageName+EXTENSION)));
        return ResponseEntity.ok(inputStream);
    }


}
