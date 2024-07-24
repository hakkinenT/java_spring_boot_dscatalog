CREATE TABLE tb_user_role (
    role_id bigint NOT NULL,
    user_id bigint NOT NULL,
    PRIMARY KEY (role_id, user_id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);