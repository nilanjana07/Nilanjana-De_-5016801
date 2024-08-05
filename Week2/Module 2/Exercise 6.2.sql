DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;
        
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee NUMBER := 50; -- Example fee amount
BEGIN
    FOR rec IN c_accounts LOOP
        v_account_id := rec.AccountID;
        v_balance := rec.Balance;
        
        -- Deduct the annual fee from the account balance
        UPDATE Accounts
        SET Balance = v_balance - v_annual_fee
        WHERE AccountID = v_account_id;
        
        -- Print confirmation (this could be replaced with actual reporting logic)
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' Annual fee applied. New Balance: ' || (v_balance - v_annual_fee));
    END LOOP;
END ApplyAnnualFee;
/
