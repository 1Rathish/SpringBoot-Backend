package com.spring.springbootbasic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.springbootbasic.models.Product;
import com.spring.springbootbasic.repositories.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{
@Autowired
private ProductRepository productRepository;

public void run(String...args) throws Exception{
//Check if the table is empty
if (productRepository.count() == 0) {
//Seed demo data
List<Product> products = Arrays.asList(
		new Product("Laptop", 999.99, "High-performance laptop", 4.5, "Electronics", "TechWorld", 50, 120,Arrays.asList("https://picsum.photos/200/300","https://picsum.photos/200/300")),
        new Product("Smartphone", 699.99, "Latest model smartphone", 4.8, "Electronics", "MobileHub", 100, 250,Arrays.asList("https://picsum.photos/200/300","https://picsum.photos/200/300")),
        new Product("Headphones", 49.99, "Noise-cancelling headphones", 4.2, "Accessories", "SoundWave", 200, 75,Arrays.asList("https://picsum.photos/200/300","https://picsum.photos/200/300")),
        new Product("Coffee Maker", 89.99, "Automatic coffee maker", 4.6, "Home Appliances", "KitchenPro", 30, 40,Arrays.asList("https://picsum.photos/200/300","https://picsum.photos/200/300")),
        new Product("Running Shoes", 120.00, "Comfortable running shoes", 4.7, "Sportswear", "ActiveGear", 150, 90,Arrays.asList("https://picsum.photos/200/300","https://picsum.photos/200/300")));

		productRepository.saveAll(products);
		
		System.out.println("Data seeded");
}
}
}
