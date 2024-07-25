CREATE TABLE tb_product (
    id bigserial NOT NULL,
    name VARCHAR(255),
    price FLOAT(53),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    description TEXT,
    img_url VARCHAR(255),
    PRIMARY KEY(id)
);