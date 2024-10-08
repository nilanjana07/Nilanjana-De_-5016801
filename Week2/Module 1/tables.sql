-- Inserting employee records
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (3, 'Carol Davis', 'Analyst', 55000, 'Finance', TO_DATE('2018-08-10', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (4, 'David Evans', 'Developer', 62000, 'IT', TO_DATE('2019-01-25', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (5, 'Emma Green', 'HR Specialist', 50000, 'HR', TO_DATE('2020-04-18', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (6, 'Frank Harris', 'Project Manager', 75000, 'IT', TO_DATE('2016-12-01', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (7, 'Grace Lewis', 'Marketing Manager', 68000, 'Marketing', TO_DATE('2017-07-12', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (8, 'Henry Martinez', 'Support Specialist', 48000, 'Support', TO_DATE('2021-02-14', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (9, 'Ivy Nelson', 'Business Development', 57000, 'Sales', TO_DATE('2019-09-05', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (10, 'Jack O''Neil', 'System Analyst', 53000, 'IT', TO_DATE('2018-11-23', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (11, 'Kathy Parker', 'Data Scientist', 69000, 'Analytics', TO_DATE('2020-05-16', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (12, 'Leo Quinn', 'Software Engineer', 64000, 'IT', TO_DATE('2022-03-30', 'YYYY-MM-DD'));

-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER);
    PROCEDURE UpdateCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER);
    FUNCTION GetCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2, p_HireDate IN DATE);
    PROCEDURE UpdateEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2);
    FUNCTION CalculateAnnualSalary(p_EmployeeID IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID IN NUMBER, p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_Balance IN NUMBER);
    PROCEDURE CloseAccount(p_AccountID IN NUMBER);
    FUNCTION GetTotalBalance(p_CustomerID IN NUMBER) RETURN NUMBER;
END AccountOperations;
/
