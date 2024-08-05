DECLARE
    CURSOR c_transactions IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, a.CustomerID
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
          
    v_customer_id Accounts.CustomerID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    FOR rec IN c_transactions LOOP
        v_customer_id := rec.CustomerID;
        v_amount := rec.Amount;
        v_transaction_type := rec.TransactionType;
        
        -- Print statement for the customer (this could be replaced with actual reporting logic)
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                             ' Transaction ID: ' || rec.TransactionID ||
                             ' Date: ' || rec.TransactionDate ||
                             ' Amount: ' || v_amount ||
                             ' Type: ' || v_transaction_type);
    END LOOP;
END GenerateMonthlyStatements;
/
