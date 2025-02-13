package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;



public interface ProductRepository extends JpaRepository<Product,Integer> {

	public List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);

	public List<Product> findByProductCategory(String productCategory);

	public List<Product> findByProductCategoryAndProductPriceLessThan(String category, double price);

	

	

}
