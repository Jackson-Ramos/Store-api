package com.jcode_development.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String name;
//	private String description;
//	private Double price;
//	private String imgUrl;
//
//	@ManyToMany()
//	@JoinTable(
//			name = "product_order",
//			joinColumns = @JoinColumn(name = "product_id"),
//			inverseJoinColumns = @JoinColumn(name = "order_id")
//	)
//	private Set<Order> items = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderProduct> items = new HashSet<>();
}
