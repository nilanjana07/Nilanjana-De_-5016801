-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_CustomerID IN NUMBER, p_Name IN VARCHAR2, p_DOB IN DATE, p_Balance IN NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_CustomerID IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
