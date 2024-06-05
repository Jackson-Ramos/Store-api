package com.jcode_development.store.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
}
