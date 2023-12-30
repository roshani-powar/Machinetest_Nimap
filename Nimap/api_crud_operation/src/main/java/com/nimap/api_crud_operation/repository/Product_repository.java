package com.nimap.api_crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.api_crud_operation.dto.Product;

public interface Product_repository extends JpaRepository<Product, Integer> {

}
