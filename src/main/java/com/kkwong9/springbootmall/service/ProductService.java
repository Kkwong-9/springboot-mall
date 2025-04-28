package com.kkwong9.springbootmall.service;

import com.kkwong9.springbootmall.dto.ProductRequest;
import com.kkwong9.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduce(Integer productId, ProductRequest productRequest);
}
