CREATE TABLE tb_password_recover (
    id bigserial NOT NULL,
    expiration TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    email VARCHAR(255) NOT NULL,
    token VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);