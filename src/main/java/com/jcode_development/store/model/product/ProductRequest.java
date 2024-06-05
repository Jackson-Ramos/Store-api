package com.jcode_development.store.model.product;

import java.util.Set;

public record ProductRequest(String name, String description, Double price, String imgUrl) {
}
