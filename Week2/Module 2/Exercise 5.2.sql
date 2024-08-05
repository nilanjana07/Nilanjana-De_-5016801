CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    ActionDate DATE,
    ActionType VARCHAR2(20),
    OldBalance NUMBER,
    NewBalance NUMBER
);
