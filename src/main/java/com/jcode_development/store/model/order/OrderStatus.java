package com.jcode_development.store.model.order;

public enum OrderStatus {
	PENDING,      // Pedido foi criado, mas ainda não processado
	PROCESSING,   // Pedido está sendo processado
	SHIPPED,      // Pedido foi enviado
	DELIVERED,    // Pedido foi entregue
	CANCELED      // Pedido foi cancelado
}
