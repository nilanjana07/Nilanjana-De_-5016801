-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_AccountID IN NUMBER, p_CustomerID IN NUMBER, p_AccountType IN VARCHAR2, p_Balance IN NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
    END OpenAccount;

    PROCEDURE CloseAccount(p_AccountID IN NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_CustomerID IN NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        RETURN v_total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0; -- Assuming 0 balance if no accounts found
    END GetTotalBalance;

END AccountOperations;
/
