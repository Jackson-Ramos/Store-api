package com.jcode_development.store.model.product;

import com.jcode_development.store.model.order.OrderProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 6223776313355701508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String name;
	
	@Column(length = 1000)
	private String description;
	
	@Column()
	private Double price;
	
	@Column(length = 500)
	private String imgUrl;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderProduct> items = new HashSet<>();
	
	public Product(ProductRequest request) {
		this.id = null;
		this.name = request.name();
		this.description = request.description();
		this.price = request.price();
		this.imgUrl = request.imgUrl();
	}
	
}
