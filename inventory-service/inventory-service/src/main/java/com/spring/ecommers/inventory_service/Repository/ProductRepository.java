package com.spring.ecommers.inventory_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ecommers.inventory_service.entities.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long> {

}
