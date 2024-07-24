CREATE TABLE tb_category (
    id bigserial NOT NULL,
    name VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (id)
);