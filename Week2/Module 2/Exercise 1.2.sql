BEGIN
    -- Add IsVIP column to Customers table if it does not exist
    EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP CHAR(1) DEFAULT ''N'')';
    
    -- Loop through all customers
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        -- Check if the customer's balance is over $10,000
        IF rec.Balance > 10000 THEN
            -- Set IsVIP to 'Y' for customers with balance over $10,000
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;
        ELSE
            -- Ensure IsVIP is 'N' for customers with balance $10,000 or less
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/