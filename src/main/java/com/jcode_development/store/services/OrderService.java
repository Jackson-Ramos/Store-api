package com.jcode_development.store.services;

import com.jcode_development.store.repositories.OrderRepository;
import com.jcode_development.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final UserService userService;
	
	public OrderService(
			OrderRepository orderRepository,
			ProductRepository productRepository,
			UserService userService
	) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.userService = userService;
	}
}
