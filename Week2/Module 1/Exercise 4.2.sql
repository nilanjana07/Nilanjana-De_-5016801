CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_rate NUMBER;
    v_total_months NUMBER;
BEGIN
    -- Convert annual interest rate to a monthly rate
    v_monthly_rate := p_interest_rate / 100 / 12;
    v_total_months := p_duration_years * 12;

    -- Calculate monthly installment using the formula
    v_monthly_installment := p_loan_amount * (v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months)) / (POWER(1 + v_monthly_rate, v_total_months) - 1);

    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
