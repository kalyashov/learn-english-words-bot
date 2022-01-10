CREATE USER learn_english_db_liquibase PASSWORD 'learn_english_db_liquibase';
CREATE USER learn_english_db_client PASSWORD 'learn_english_db_client';

CREATE DATABASE learn_english_db OWNER learn_english_db_liquibase ENCODING 'UTF8' CONNECTION LIMIT 100;

\connect learn_english_db;
CREATE SCHEMA liquibase AUTHORIZATION learn_english_db_liquibase;

ALTER DEFAULT PRIVILEGES FOR ROLE learn_english_db_liquibase IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO learn_english_db_client;