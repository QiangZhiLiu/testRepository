package com.shop.service;

import java.util.List;

import com.shop.domain.Product;

public interface ProductService {
  public List<Product>getProductList();
  public Product getProductById(Integer id);
  public void update(Product product);
}
