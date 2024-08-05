CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_old_balance NUMBER;
BEGIN
    -- Get the old balance of the account before the transaction
    SELECT Balance INTO v_old_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;
    
    -- Insert a record into the AuditLog table
    INSERT INTO AuditLog (LogID, TransactionID, ActionDate, ActionType, OldBalance, NewBalance)
    VALUES (
        AuditLog_seq.NEXTVAL,  -- Assuming you have a sequence for LogID
        :NEW.TransactionID,
        SYSDATE,
        :NEW.TransactionType,
        v_old_balance,
        v_old_balance + :NEW.Amount -- Assuming :NEW.Amount is positive for deposits and negative for withdrawals
    );
END LogTransaction;
/
