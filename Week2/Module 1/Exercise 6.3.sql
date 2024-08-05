DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;
        
    v_loan_id Loans.LoanID%TYPE;
    v_current_rate Loans.InterestRate%TYPE;
    v_new_rate NUMBER;
BEGIN
    FOR rec IN c_loans LOOP
        v_loan_id := rec.LoanID;
        v_current_rate := rec.InterestRate;
        
        -- Calculate new interest rate based on new policy (example: increase by 0.5%)
        v_new_rate := v_current_rate + 0.5;
        
        -- Update the interest rate
        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan_id;
        
        -- Print confirmation (this could be replaced with actual reporting logic)
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' Interest rate updated from ' || v_current_rate || ' to ' || v_new_rate);
    END LOOP;
END UpdateLoanInterestRates;
/
