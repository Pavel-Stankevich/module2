INSERT INTO task11_part2.roles (name) VALUES ('user');
INSERT INTO task11_part2.roles (name) VALUES ('seller');

INSERT INTO task11_part2.users (email, password, full_name, address, id_role) VALUES ('user1@email.ru', 'user1', 'user1', 'address1', 1);
INSERT INTO task11_part2.users (email, password, full_name, address, id_role) VALUES ('user2@email.ru', 'user2', 'user2', 'address2', 1);
INSERT INTO task11_part2.users (email, password, full_name, address, id_role) VALUES ('seller1@email.ru', 'seller1', 'seller1', 'address1', 2);

INSERT INTO task11_part2.order_statuses (name) VALUES ('OPEN');
INSERT INTO task11_part2.order_statuses (name) VALUES ('IN_PROGRESS');
INSERT INTO task11_part2.order_statuses (name) VALUES ('CLOSE');

INSERT INTO task11_part2.goods(name, count) VALUES ('Pasta', 20);
INSERT INTO task11_part2.goods(name, count) VALUES ('Chicken', 10);
INSERT INTO task11_part2.goods(name, count) VALUES ('Juice', 10);
