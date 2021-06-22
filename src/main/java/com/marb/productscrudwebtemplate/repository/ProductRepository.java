package com.marb.productscrudwebtemplate.repository;

import com.marb.productscrudwebtemplate.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
