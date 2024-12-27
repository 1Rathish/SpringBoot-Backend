package com.spring.springbootbasic.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.springbootbasic.models.Product;
import com.spring.springbootbasic.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/getProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductsById(@PathVariable Long id) {
		return productService.getProductsById(id);
	}
	
//	@GetMapping("/category")
//	public List<Map<String, Object>> getCategoryProducts(){
//		return Arrays.asList(
//		Map.of("name", "Product 1", "price", 234),
//		Map.of("name", "Product 2", "price", 123)
//		);
//	}

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}