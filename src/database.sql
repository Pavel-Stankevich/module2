DROP SCHEMA IF EXISTS task11_part2;
CREATE SCHEMA task11_part2;

CREATE TABLE task11_part2.goods
(
  id bigint NOT NULL DEFAULT nextval('task11_part2.goods_id_seq' :: regclass),
  name character varying(255) COLLATE pg_catalog."default" NOT NULL,
  count bigint NOT NULL,
  CONSTRAINT goods_pkey PRIMARY KEY (id)
);

CREATE TABLE task11_part2.roles
(
  id bigint NOT NULL DEFAULT nextval('task11_part2.roles_id_seq' :: regclass),
  name character varying(31) COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE task11_part2.users
(
  id bigint NOT NULL DEFAULT nextval('task11_part2.users_id_seq' :: regclass),
  email character varying(320) COLLATE pg_catalog."default" NOT NULL,
  password character varying(255) COLLATE pg_catalog."default" NOT NULL,
  full_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
  address character varying(255) COLLATE pg_catalog."default" NOT NULL,
  id_role bigint NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT fk_users_roles FOREIGN KEY (id_role)
  REFERENCES task11_part2.roles (id)
);

CREATE TABLE task11_part2.order_statuses
(
  id bigint NOT NULL DEFAULT nextval('task11_part2.order_statuses_id_seq' :: regclass),
  name character varying(255) COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT order_statuses_pkey PRIMARY KEY (id)
);

CREATE TABLE task11_part2.orders
(
  id bigint NOT NULL DEFAULT nextval('task11_part2.orders_id_seq' :: regclass),
  id_user bigint NOT NULL,
  id_good bigint NOT NULL,
  id_status bigint NOT NULL,
  CONSTRAINT orders_pkey PRIMARY KEY (id),
  CONSTRAINT fk_orders_goods FOREIGN KEY (id_good)
  REFERENCES task11_part2.goods (id),
  CONSTRAINT fk_orders_order_statuses FOREIGN KEY (id_status)
  REFERENCES task11_part2.order_statuses (id),
  CONSTRAINT fk_orders_users FOREIGN KEY (id_user)
  REFERENCES task11_part2.users (id)
);
