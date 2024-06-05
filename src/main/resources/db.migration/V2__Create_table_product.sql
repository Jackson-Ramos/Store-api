CREATE TABLE IF NOT EXISTS products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255)  NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price       DOUBLE        NOT NULL,
    img_url     VARCHAR(500)  NOT NULL
);