CREATE TABLE tb_user (
    id bigserial NOT NULL,
    email VARCHAR(255) UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id)
);