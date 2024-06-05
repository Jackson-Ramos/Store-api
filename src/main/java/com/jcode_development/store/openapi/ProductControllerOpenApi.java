package com.jcode_development.store.openapi;

import com.jcode_development.store.model.product.ProductRequest;
import com.jcode_development.store.model.product.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ProductControllerOpenApi {
	
	ResponseEntity<Set<ProductResponse>> findAll();
	
	ResponseEntity<ProductResponse> findById(Long id);

	ResponseEntity<Void> save(ProductRequest request);
	
	ResponseEntity<Void> update(ProductRequest request);
	
	ResponseEntity<Void> delete(Long id);
}
