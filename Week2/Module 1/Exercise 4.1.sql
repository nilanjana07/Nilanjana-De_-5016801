CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Calculate age in years
    SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12) INTO v_age FROM dual;
    RETURN v_age;
END CalculateAge;
/
