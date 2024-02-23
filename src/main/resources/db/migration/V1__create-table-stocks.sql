CREATE TABLE stock (
    id VARCHAR(100) PRIMARY KEY UNIQUE NOT NULL,
    stockName VARCHAR(20) NOT NULL,
    quote DOUBLE NOT NULL,
    createdAt DATE NOT NULL
);