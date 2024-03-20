DROP DATABASE IF EXISTS bank_database;

CREATE DATABASE bank_database ;

\c bank_database

CREATE TABLE IF NOT EXISTS account (
    id INT PRIMARY KEY,
    firstName VARCHAR(200) NOT NULL,
    lastName VARCHAR(200) NOT NULL,
    birthDate DATE CHECK (birthDate <= CURRENT_DATE - INTERVAL '21 years') NOT NULL,
    mensualSalary DOUBLE PRECISION
);