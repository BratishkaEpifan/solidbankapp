CREATE TABLE Account
(
    accountType NVARCHAR(15)  NOT NULL,
    id NVARCHAR(15) NOT NULL,
    clientID NVARCHAR(15) NOT NULL,
    balance FLOAT NOT NULL,
    withdrawAllowed BIT NOT NULL,
    CONSTRAINT PK_ID PRIMARY KEY (id)
);

CREATE TABLE Transaction
(
    transactionID INT NOT NULL,
    accountID NVARCHAR(15) NOT NULL,
    amount FLOAT NOT NULL,
    CONSTRAINT PK_TransactionID PRIMARY KEY (transactionID)
);