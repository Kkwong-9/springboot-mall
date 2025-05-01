package com.kkwong9.springbootmall.controller;

import com.kkwong9.springbootmall.dto.ProductRequest;
import com.kkwong9.springbootmall.model.Product;
import com.kkwong9.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    private ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product =  productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {
        // Check Product is Exist
        Product product =  productService.getProductById(productId);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Resource not found. Please check the URL or resource ID.");
        }

        // Update Product Data
        productService.updateProduce(productId, productRequest);
        Product updatedProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        // Delete Product
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
