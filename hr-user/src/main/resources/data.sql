INSERT INTO tb_user (name, email, password) VALUES ('Renan', 'renan@gmail.com', '$2a$10$FFl2I6uc0VwrE57Tm1b/c.JXNOleL1XAG9.KZVUUc0C00Abd26zW.');
INSERT INTO tb_user (name, email, password) VALUES ('Laísa', 'laisa@gmail.com', '$2a$10$yQX4ayq6xYq24Pjdb3yc2OYHjQdXQP6ywU06fNtihh1lEntsuT2Xq');
INSERT INTO tb_user (name, email, password) VALUES ('Lara', 'lara@gmail.com', '$2a$10$nVBDvkz3.hs3Y8wPLwRZb.v4MQksU4klSzuqGWq7Y1WhwhDaw/wt.');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);