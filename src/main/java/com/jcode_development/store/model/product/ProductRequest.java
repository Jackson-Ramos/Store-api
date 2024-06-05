package com.jcode_development.store.model.product;

import java.util.Set;

public record ProductRequest(Long id,String name, String description, Double price, String imgUrl) {
}
