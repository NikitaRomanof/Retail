DROP TABLE IF EXISTS personal_data CASCADE;
DROP TABLE IF EXISTS cards CASCADE;
DROP TABLE IF EXISTS groups_sku CASCADE;
DROP TABLE IF EXISTS sku CASCADE;
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS checks CASCADE;
DROP TABLE IF EXISTS stores CASCADE;


CREATE TABLE IF NOT EXISTS personal_data (
	customer_id SERIAL PRIMARY KEY NOT NULL,
	customer_name varchar NOT NULL,
	customer_surname varchar NOT NULL,
	customer_primary_email varchar NOT NULL,
	customer_primary_phone numeric NOT NULL
);

CREATE TABLE IF NOT EXISTS cards (
	customer_card_id SERIAL PRIMARY KEY NOT NULL,
	customer_id SERIAL REFERENCES personal_data(customer_id) NOT NULL
);

CREATE TABLE IF NOT EXISTS groups_sku (
	group_id SERIAL PRIMARY KEY NOT NULL,
	group_name varchar NOT NULL
);
--
CREATE TABLE IF NOT EXISTS sku (
	sku_id SERIAL PRIMARY KEY NOT NULL,
	sku_name varchar NOT NULL,
	group_id SERIAL REFERENCES groups_sku(group_id) NOT NULL
);
--
CREATE TABLE IF NOT EXISTS stores (
    id SERIAL primary key NOT NULL,
	transaction_store_id SERIAL NOT NULL,
	sku_id SERIAL REFERENCES sku(sku_id),
	sku_purchase_price numeric NOT NULL,
	sku_retail_price numeric NOT NULL
);
--
CREATE TABLE IF NOT EXISTS transactions (
	transaction_id SERIAL primary key NOT NULL,
	customer_card_id SERIAL REFERENCES cards(customer_card_id),
	transaction_summ numeric NOT NULL,
	transaction_date_time timestamp NOT NULL,
	transaction_store_id SERIAL NOT NULL
);
--
CREATE TABLE IF NOT EXISTS checks(
    id SERIAL primary key NOT NULL,
	transaction_id SERIAL REFERENCES transactions(transaction_id) NOT NULL,
	sku_id SERIAL REFERENCES sku(sku_id) NOT NULL,
	sku_amount numeric NOT NULL,
	sku_summ numeric NOT NULL,
	sku_summ_paid numeric NOT NULL,
	sku_discount numeric NOT NULL
);
