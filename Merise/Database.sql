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
    can_take_credit BOOL DEFAULT FALSE,
    credit DOUBLE PRECISION,
    credit_interest DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS withdrawal (
    id SERIAL PRIMARY KEY,
    id_account INT NOT NULL,
    withdrawal_amount DOUBLE PRECISION NOT NULL,
    withdrawal_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_account) REFERENCES account(id)
);

CREATE TABLE IF NOT EXISTS incoming_transfer (
        id SERIAL PRIMARY KEY,
        id_account INT NOT NULL,
        amount DOUBLE PRECISION NOT NULL,
        reason VARCHAR(500) DEFAULT 'Autre' NOT NULL
        CHECK (reason IN
        ('Nouriture et boisson',
        'Achats et boutique en ligne',
        'Logement',
        'Transports',
        'Revenu',
        'Autre')),
        effective_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (id_account) REFERENCES account(id)
);

CREATE TABLE IF NOT EXISTS outflow_transfer(
    id SERIAL PRIMARY KEY,
    id_account INT NOT NULL,
    id_receiver INT NOT NULL,
    is_same_bank BOOL DEFAULT TRUE,
    bank_name VARCHAR(500) DEFAULT 'Bank X',
    transfer_amount DOUBLE PRECISION NOT NULL,
    category VARCHAR(500) DEFAULT 'Autre' NOT NULL
            CHECK (category IN
            ('Nouriture et boisson',
            'Achats et boutique en ligne',
            'Logement',
            'Transports',
            'Vehicule',
            'Loisir',
            'Autre')),
    effective_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_reference CHAR(14) DEFAULT '00000000000000',
    is_canceled BOOL DEFAULT FALSE,
    FOREIGN KEY (id_account) REFERENCES account(id),
    FOREIGN KEY (id_receiver) REFERENCES account(id)
);

-- Function SQL --


CREATE OR REPLACE FUNCTION all_amount(start_date TIMESTAMP, end_date TIMESTAMP)
RETURNS TABLE (
    transfer_id INT,
    id_account INT,
    amount DOUBLE PRECISION,
    reason VARCHAR(500),
    effective_date TIMESTAMP,
    registration_date TIMESTAMP
) AS $$
BEGIN
    RETURN QUERY
    SELECT it.id AS transfer_id, it.id_account, it.amount, it.reason, it.effective_date, it.registration_date
    FROM incoming_transfer it
    WHERE it.effective_date >= start_date AND it.effective_date <= end_date;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION visualize_expenses()
RETURNS TABLE(
    total_expense DOUBLE PRECISION
) AS $$
BEGIN
    RETURN QUERY
    SELECT SUM(transfer_amount) AS total_expense
    FROM outflow_transfer;
END;
$$ LANGUAGE plpgsql;

