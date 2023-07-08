DROP PROCEDURE IF EXISTS import_tsv;
DROP PROCEDURE IF EXISTS import_tsv_first_checks;
DROP PROCEDURE IF EXISTS import_tsv_first_stores;


DROP PROCEDURE IF EXISTS import_tsv_personal_data;
DROP PROCEDURE IF EXISTS import_tsv_cards;
DROP PROCEDURE IF EXISTS import_tsv_groups_sku;
DROP PROCEDURE IF EXISTS import_tsv_sku;
DROP PROCEDURE IF EXISTS import_tsv_stores;
DROP PROCEDURE IF EXISTS import_tsv_transaction;
DROP PROCEDURE IF EXISTS import_tsv_checks;

DROP PROCEDURE IF EXISTS import_csv_personal_data;
DROP PROCEDURE IF EXISTS import_csv_cards;
DROP PROCEDURE IF EXISTS import_csv_groups_sku;
DROP PROCEDURE IF EXISTS import_csv_sku;
DROP PROCEDURE IF EXISTS import_csv_stores;
DROP PROCEDURE IF EXISTS import_csv_transaction;
DROP PROCEDURE IF EXISTS import_csv_checks;

-- import TSV

CREATE OR REPLACE PROCEDURE import_tsv(file_name varchar,
                                    table_name varchar,
                                    delimiter varchar)
language plpgsql
as $$
declare
    dir varchar := (SELECT setting AS directory
                    FROM pg_settings
                    WHERE name = 'data_directory') || '/' || file_name;
begin
    EXECUTE format('COPY %s FROM %L WITH DELIMITER %L', quote_ident(table_name), dir, delimiter);
end $$;


CREATE OR REPLACE PROCEDURE import_tsv_first_stores(file_name varchar,
                                    table_name varchar,
                                    delimiter varchar)
language plpgsql
as $$
declare
    dir varchar := (SELECT setting AS directory
                    FROM pg_settings
                    WHERE name = 'data_directory') || '/' || file_name;
begin
    EXECUTE format('COPY %s (transaction_store_id, sku_id, sku_purchase_price, sku_retail_price) FROM %L WITH DELIMITER %L', quote_ident(table_name), dir, delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_first_checks(file_name varchar,
                                    table_name varchar,
                                    delimiter varchar)
language plpgsql
as $$
declare
    dir varchar := (SELECT setting AS directory
                    FROM pg_settings
                    WHERE name = 'data_directory') || '/' || file_name;
begin
    EXECUTE format('COPY %s (transaction_id, sku_id, sku_amount, sku_summ, sku_summ_paid, sku_discount) FROM %L WITH DELIMITER %L', quote_ident(table_name), dir, delimiter);
end $$;

-- Import TSV

CREATE OR REPLACE PROCEDURE import_tsv_personal_data(delimiter varchar) language plpgsql AS $$
begin
    CALL import_tsv('Personal_Data_Mini.tsv', 'personal_data', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_cards(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv('Cards_Mini.tsv', 'cards', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_groups_sku(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv('Groups_SKU_Mini.tsv', 'groups_sku', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_sku(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv('SKU_Mini.tsv', 'sku', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_stores(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv_first_stores('Stores_Mini.tsv', 'stores', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_transaction(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv('Transactions_Mini.tsv', 'transactions', delimiter);
end $$;

CREATE OR REPLACE PROCEDURE import_tsv_checks(delimiter varchar) language plpgsql as $$
begin
    CALL import_tsv_first_checks('Checks_Mini.tsv', 'checks', delimiter);
end $$;