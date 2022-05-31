CREATE TABLE Accounts
(
    account_id NVARCHAR(MAX)  NOT NULL,
    account_type NVARCHAR(MAX)  NOT NULL,
    client_id NVARCHAR(MAX)  NOT NULL,
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