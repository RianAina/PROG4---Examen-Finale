CREATE DATABASE bank_database ;

\c gestion_notes_bacc

CREATE TABLE account (
    id INT PRIMARY KEY,
    firstName VARCHAR(200) NOT NULL,
    lastName VARCHAR(200) NOT NULL,
    birthDate DATE NOT NULL,
    mensualSalary INT
)