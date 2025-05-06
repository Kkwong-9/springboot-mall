package com.kkwong9.springbootmall.dao;

import com.kkwong9.springbootmall.constant.ProductCategory;
import com.kkwong9.springbootmall.dto.ProductQueryParams;
import com.kkwong9.springbootmall.dto.ProductRequest;
import com.kkwong9.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProductById(Integer productId);
    List<Product> getProducts(ProductQueryParams productQueryParams);
}
