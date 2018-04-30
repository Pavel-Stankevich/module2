DROP SCHEMA IF EXISTS task11_part2;
CREATE SCHEMA task11_part2;

CREATE TABLE task11_part2.roles
(
  id bigserial NOT NULL,
  name character varying(31) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE task11_part2.goods
(
  id bigserial NOT NULL,
  name character varying(255) NOT NULL,
  count bigint NOT NULL,
  CONSTRAINT goods_pkey PRIMARY KEY (id)
);

CREATE TABLE task11_part2.users
(
  id bigserial NOT NULL,
  email character varying(320) NOT NULL,
  password character varying(255) NOT NULL,
  full_name character varying(255) NOT NULL,
  address character varying(255) NOT NULL,
  id_role bigint NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT fk_users_roles FOREIGN KEY (id_role)
  REFERENCES task11_part2.roles (id)
);

CREATE TABLE task11_part2.orders
(
  id bigserial NOT NULL,
  id_user bigint NOT NULL,
  status character varying(255) NOT NULL,
  CONSTRAINT orders_pkey PRIMARY KEY (id),
  CONSTRAINT fk_orders_users FOREIGN KEY (id_user)
  REFERENCES task11_part2.users (id)
);

CREATE TABLE task11_part2.order_goods
(
  id_order bigint NOT NULL,
  id_good bigint NOT NULL,
  CONSTRAINT order_goods_pkey PRIMARY KEY (id_order, id_good),
  CONSTRAINT fk_order_goods_order FOREIGN KEY (id_order)
  REFERENCES task11_part2.orders (id),
  CONSTRAINT fk_order_goods FOREIGN KEY (id_good)
  REFERENCES task11_part2.goods (id)
);
