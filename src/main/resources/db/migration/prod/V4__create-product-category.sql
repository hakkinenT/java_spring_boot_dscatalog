CREATE TABLE tb_product_category (
    category_id bigint NOT NULL,
    product_id bigint NOT NULL,
    PRIMARY KEY (category_id, product_id),
    FOREIGN KEY (category_id) REFERENCES tb_category(id),
    FOREIGN KEY (product_id) REFERENCES tb_product(id)
);