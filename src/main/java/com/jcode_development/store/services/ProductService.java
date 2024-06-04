package com.jcode_development.store.services;

import com.jcode_development.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
