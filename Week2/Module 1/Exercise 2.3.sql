CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    -- Try to insert a new customer
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- Handle duplicate key exception
            DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_customer_id || ' already exists.');
            RETURN;
        WHEN OTHERS THEN
            -- Handle other exceptions
            DBMS_OUTPUT.PUT_LINE('Error adding new customer: ' || SQLERRM);
            RETURN;
    END;

    -- Commit the transaction
    COMMIT;
END AddNewCustomer;
/
