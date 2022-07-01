CREATE TABLE Accounts
(
    account_id NVARCHAR(15)  NOT NULL,
    account_type NVARCHAR(15)  NOT NULL,
    client_id NVARCHAR(15)  NOT NULL,
    balance FLOAT  NOT NULL,
    withdraw_allowed BIT  NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY  (account_id)
);

CREATE TABLE Transactions
(
    transaction_id INT NOT NULL,
    account_id NVARCHAR(15) NOT NULL,
    amount FLOAT NOT NULL,
    CONSTRAINT PK_TransactionID PRIMARY KEY (transaction_id)
);

CREATE TABLE Users
(
  login NVARCHAR(31) UNIQUE,
  password NVARCHAR(80) NOT NULL,
  role NVARCHAR(15) NOT NULL,
  CONSTRAINT PK_Login PRIMARY KEY (login)
);