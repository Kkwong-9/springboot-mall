package com.kkwong9.springbootmall.service.impl;

import com.kkwong9.springbootmall.constant.ProductCategory;
import com.kkwong9.springbootmall.dao.ProductDao;
import com.kkwong9.springbootmall.dto.ProductQueryParams;
import com.kkwong9.springbootmall.dto.ProductRequest;
import com.kkwong9.springbootmall.model.Product;
import com.kkwong9.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {

        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduce(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

}
