
CREATE TABLE Account (
    idAccount SERIAL PRIMARY KEY,
    firstName VARCHAR,
    lastName VARCHAR,
    birthDate DATE,
    mensualSalary DECIMAL,
    accountNumber VARCHAR
);

CREATE TABLE Category (
    idCategory SERIAL PRIMARY KEY,
    categoryName VARCHAR
);

CREATE TABLE bankOperation (
    idOperation SERIAL PRIMARY KEY,
    dateOfEffect DATE,
    amount DECIMAL,
    idCategory INT REFERENCES Category(idCategory),
    operationType VARCHAR,
    Commentary VARCHAR,
    Reference VARCHAR,
    idAccount INT REFERENCES Compte(ID)
);


CREATE TABLE Payement (
    idPayement SERIAL PRIMARY KEY,
    reason VARCHAR,
    amount DECIMAL,
    dateOfEffect DATE,
    payementStatus VARCHAR,
    idAccount INT REFERENCES Compte(ID)
);

CREATE TABLE Configuration (
    idConfiguration SERIAL PRIMARY KEY,
    percentageOfFirstDays DECIMAL,
    percentageOfTheRest DECIMAL
);
