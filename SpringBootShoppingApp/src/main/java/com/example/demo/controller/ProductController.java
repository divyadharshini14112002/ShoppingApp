package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	@Autowired
	ProductService service;
	Logger LOGGER=LoggerFactory.getLogger(ProductController.class);
	//@RequestMapping(method = RequestMethod.POST,consumes = "application/json",)
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		LOGGER.info("products added in the controller");
		return service.addProduct(product);
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int productId) {
		LOGGER.info("deleted");
		return service.deleteProduct(productId);
		
	}
	@GetMapping("/getBy/{id}")
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
		LOGGER.info("product got by ID");
		return service.getProductById(productId);
	}
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		LOGGER.info("get all product");
		return service.getAllProducts();
	}
	@GetMapping("/getBetween/{price1}/{price2}") //http://localhost:8081/getById/123
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		LOGGER.info("get the product between the price");
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}
	@GetMapping("/getProductsByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable("category")String category){
		LOGGER.info("get products by category");
		return service.getProductsByCategory(category));
	}
	@GetMapping("/getAllProductsByCategoryAndPrice/{category}/{price}")
	public List<Product> getProductByCategoryAndPrice(@PathVariable("category") String category,
			@PathVariable("price") int price) {
		LOGGER.info("In controller /getAllProductsByCategoryAndPrice "+category+" "+price);
		return service.getProductsByCategoryAndPrice(category, price);
	}
	
	

}
