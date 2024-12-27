package com.spring.springbootbasic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springbootbasic.models.Product;
import com.spring.springbootbasic.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product product) {
		if (!productRepository.existsById(id)) {
			//throw new ProductNotFoundException("Product not found with id: " + id);
		}
		product.setId(id);
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		if (!productRepository.existsById(id)) {
			//throw new ProductNotFoundException("Product not found with id: " + id);
		}
		productRepository.deleteById(id);
	}

	public Product getProductsById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // Replace with a custom exception if needed
	}
}
