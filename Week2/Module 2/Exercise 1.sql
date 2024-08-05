DECLARE
  CURSOR c_customers IS
    SELECT CustomerID, DOB
    FROM Customers
    WHERE SYSDATE - DOB > INTERVAL '60' YEAR;
    
  v_customer_id Customers.CustomerID%TYPE;
  v_current_rate Loans.InterestRate%TYPE;
BEGIN
  FOR r_customer IN c_customers LOOP
    v_customer_id := r_customer.CustomerID;
    
    FOR r_loan IN (SELECT LoanID, InterestRate FROM Loans WHERE CustomerID = v_customer_id) LOOP
      v_current_rate := r_loan.InterestRate;
      
      UPDATE Loans
      SET InterestRate = v_current_rate - 1
      WHERE LoanID = r_loan.LoanID;
      
      DBMS_OUTPUT.PUT_LINE('Applied 1% discount to loan ID: ' || r_loan.LoanID || ' for customer ID: ' || v_customer_id);
    END LOOP;
  END LOOP;
  
  COMMIT;
END;

