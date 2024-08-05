CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update the salary of employees in the given department by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;

    -- Commit the transaction
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for employees in department: ' || p_department);
END UpdateEmployeeBonus;
/
