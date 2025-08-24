package com.prodbill.prodBill.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodbill.prodBill.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNameIgnoreCase(String name);



}
