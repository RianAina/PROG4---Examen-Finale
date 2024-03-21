DROP DATABASE IF EXISTS bank_database;

CREATE DATABASE bank_database;

\c bank_database

CREATE TABLE IF NOT EXISTS account (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    birth_date DATE CHECK (birth_date <= CURRENT_DATE - INTERVAL '21 years') NOT NULL,
    mensual_salary DOUBLE PRECISION NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    can_take_credit BOOL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS withdrawal (
    id SERIAL PRIMARY KEY,
    id_account INT,
    withdrawal_date TIMESTAMP,
    FOREIGN KEY (id_account) REFERENCES account(id)
);
