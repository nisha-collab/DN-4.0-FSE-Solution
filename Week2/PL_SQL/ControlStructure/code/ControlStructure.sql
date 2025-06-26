-- Common Table: Customers

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER,
    LoanInterestRate NUMBER,
    IsVIP CHAR(1)
);

INSERT INTO Customers VALUES (1, 'Ravi', 65, 8000, 7.5, 'N');
INSERT INTO Customers VALUES (2, 'Meena', 45, 15000, 6.5, 'N');
INSERT INTO Customers VALUES (3, 'Arjun', 70, 12000, 8.0, 'N');

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    DueDate DATE
);

INSERT INTO Loans VALUES (101, 1, SYSDATE + 10);  -- Due in 10 days
INSERT INTO Loans VALUES (102, 2, SYSDATE + 40);  -- Due in 40 days
INSERT INTO Loans VALUES (103, 3, SYSDATE + 5);   -- Due in 5 days

COMMIT;

-- Scenario 1: Apply 1% Discount to Loan Interest for Age > 60

BEGIN
    FOR cust IN (SELECT * FROM Customers) LOOP
        IF cust.Age > 60 THEN
            UPDATE Customers
            SET LoanInterestRate = LoanInterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT CustomerID, Name, Age, LoanInterestRate FROM Customers;

-- Scenario 2: Promote to VIP if Balance > 10,000

BEGIN
    FOR cust IN (SELECT * FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT CustomerID, Name, Balance, IsVIP FROM Customers;

-- Scenario 3: Print Reminders for Loans Due in 30 Days

BEGIN
    FOR loan IN (
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.DueDate <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan.LoanID ||
                             ' for ' || loan.Name ||
                             ' is due on ' || TO_CHAR(loan.DueDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/