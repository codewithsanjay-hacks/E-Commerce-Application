package com.sanjay.ecommorce.service;

import com.sanjay.ecommorce.entity.Product;
import com.sanjay.ecommorce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
      return productRepository.findAll();
    }

    public Product getProductById(long id) {

        return productRepository.findById(id).orElse(null);
    }



    public Product addProduct(Product product) {
      return productRepository.save(product);
    }


    public void deleteProduct(long id) {

        productRepository.deleteById(id);

    }
}
