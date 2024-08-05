BEGIN
    -- Loop through all loans due within the next 30 days
    FOR rec IN (SELECT LoanID, CustomerID, EndDate FROM Loans
                WHERE EndDate BETWEEN SYSDATE AND ADD_MONTHS(SYSDATE, 1)) LOOP
        -- Print a reminder message for each customer
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID ||
                             ' for Customer ID ' || rec.CustomerID ||
                             ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
