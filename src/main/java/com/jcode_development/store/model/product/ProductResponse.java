package com.jcode_development.store.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse extends RepresentationModel<ProductResponse> implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 2904370609765106338L;
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
}
