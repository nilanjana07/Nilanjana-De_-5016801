-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2, p_HireDate IN DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_EmployeeID IN NUMBER, p_Name IN VARCHAR2, p_Position IN VARCHAR2, p_Salary IN NUMBER, p_Department IN VARCHAR2) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name, Position = p_Position, Salary = p_Salary, Department = p_Department
        WHERE EmployeeID = p_EmployeeID;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_EmployeeID IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;
        RETURN v_salary * 12; -- Assuming salary is monthly
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
