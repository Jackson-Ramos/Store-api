CREATE TABLE IF NOT EXISTS order_product
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id   BIGINT,
    product_id BIGINT,
    price      DOUBLE NOT NULL,
    quantity   INT    NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
