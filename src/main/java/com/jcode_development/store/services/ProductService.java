package com.jcode_development.store.services;

import com.jcode_development.store.exceptions.NotFounderException;
import com.jcode_development.store.mapper.Mapper;
import com.jcode_development.store.model.product.ProductResponse;
import com.jcode_development.store.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ResponseEntity<Set<ProductResponse>> findAll(){
		var listProducts = Mapper.parseObjects(productRepository.findAll(), ProductResponse.class);
		return ResponseEntity.status(HttpStatus.OK).body(listProducts);
	}
	
	public ResponseEntity<ProductResponse> findById(Long id){
		var product = Mapper.parseObject(
				productRepository.findById(id).orElseThrow(
				() -> new NotFounderException("Id " + id + "not folder!")),
				ProductResponse.class
		);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
}
