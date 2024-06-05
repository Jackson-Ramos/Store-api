package com.jcode_development.store.services;

import com.jcode_development.store.controller.ProductController;
import com.jcode_development.store.exceptions.NotFoundeException;
import com.jcode_development.store.exceptions.RequiredObjectisNullException;
import com.jcode_development.store.mapper.Mapper;
import com.jcode_development.store.model.product.Product;
import com.jcode_development.store.model.product.ProductRequest;
import com.jcode_development.store.model.product.ProductResponse;
import com.jcode_development.store.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ResponseEntity<Set<ProductResponse>> findAll(){
		var listProducts = Mapper.parseObjects(productRepository.findAll(), ProductResponse.class);
		for (ProductResponse productResponse : listProducts) {
			productResponse.add(linkTo(methodOn(ProductController.class).findById(productResponse.getId())).withSelfRel());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listProducts);
	}
	
	public ResponseEntity<ProductResponse> findById(Long id){
		var product = Mapper.parseObject(
				productRepository.findById(id).orElseThrow(
				() -> new NotFoundeException("Id " + id + "not folder!")),
				ProductResponse.class
		);
		product.add(linkTo(methodOn(ProductController.class).findAll()).withRel("All products"));
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	public ResponseEntity<Void> save(ProductRequest request){
		if (request == null) throw new RequiredObjectisNullException();
		
		if (request.description().length() > 1000 && request.imgUrl().length() > 500)
			throw new IllegalArgumentException("The description field cannot exceed 1000 characters and the image cannot exceed 500");
		Product product = new Product(request);
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	public ResponseEntity<Void> update(ProductRequest request){
		if (request == null) throw new RequiredObjectisNullException();
		
		if (request.description().length() > 1000 && request.imgUrl().length() > 500)
			throw new IllegalArgumentException("The description field cannot exceed 1000 characters and the image cannot exceed 500");
		
		var product = productRepository.findById(request.id()).orElseThrow(
				() -> new NotFoundeException("No records found for this ID!"));
		product.setName(request.name());
		product.setDescription(request.description());
		product.setPrice(request.price());
		product.setImgUrl(request.imgUrl());
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	public ResponseEntity<Void> delete(Long id){
		var product = productRepository.findById(id).orElseThrow(() -> new NotFoundeException("id: " + id + "not found!"));
		productRepository.delete(product);
		return ResponseEntity.noContent().build();
	}
}
