package com.kkwong9.springbootmall.dao;

import com.kkwong9.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
