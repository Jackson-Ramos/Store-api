CREATE TABLE IF NOT EXISTS orders
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    moment  TIMESTAMP    NOT NULL,
    status  VARCHAR(255) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);