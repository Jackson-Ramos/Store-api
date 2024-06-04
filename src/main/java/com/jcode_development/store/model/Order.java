package com.jcode_development.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -2202348898788988177L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant moment;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderProduct> products = new HashSet<>();
}
