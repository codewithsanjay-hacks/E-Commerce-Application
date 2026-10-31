package com.sanjay.ecommorce.repository;

import com.sanjay.ecommorce.entity.Product;
import com.sanjay.ecommorce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
}








