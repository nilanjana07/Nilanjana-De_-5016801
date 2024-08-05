BEGIN
    -- Loop through all customers
    FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        -- Calculate age
        DECLARE
            age NUMBER;
        BEGIN
            age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
            
            -- Check if the customer is above 60 years old
            IF age > 60 THEN
                -- Apply a 1% discount to their current loan interest rates
                UPDATE Loans
                SET InterestRate = InterestRate - 1
                WHERE CustomerID = rec.CustomerID;
            END IF;
        END;
    END LOOP;
    COMMIT;
END;
/

B



