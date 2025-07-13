-- Scenario 1: Savings Accounts Table

CREATE TABLE SavingsAccounts (
    AccountID NUMBER PRIMARY KEY,
    Balance NUMBER
);

INSERT INTO SavingsAccounts VALUES (101, 1000);
INSERT INTO SavingsAccounts VALUES (102, 2000);

-- Scenario 2: Employees Table

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER
);

INSERT INTO Employees VALUES (1, 'John', 'HR', 30000);
INSERT INTO Employees VALUES (2, 'Jane', 'IT', 40000);
INSERT INTO Employees VALUES (3, 'Ali', 'IT', 42000);

-- Scenario 3: Accounts Table

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    Balance NUMBER
);

INSERT INTO Accounts VALUES (201, 5000);
INSERT INTO Accounts VALUES (202, 3000);

COMMIT;

-- Scenario 1: ProcessMonthlyInterest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE SavingsAccounts
    SET Balance = Balance + (Balance * 0.01);
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM SavingsAccounts;

-- Scenario 2: UpdateEmployeeBonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    deptName IN VARCHAR2,
    bonusPercent IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

SELECT * FROM EMPLOYEES;

-- Scenario 3: TransferFunds

CREATE OR REPLACE PROCEDURE TransferFunds (
    fromAcc IN NUMBER,
    toAcc IN NUMBER,
    amount IN NUMBER
)
IS
    insufficient_funds EXCEPTION;
    balance NUMBER;
BEGIN
    SELECT Balance INTO balance FROM Accounts WHERE AccountID = fromAcc;

    IF balance < amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = fromAcc;

    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = toAcc;

    COMMIT;

EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected Error: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(201, 202, 1000);
END;
/

SELECT * FROM Accounts;