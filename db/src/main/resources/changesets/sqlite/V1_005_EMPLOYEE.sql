--liquibase formatted sql logicalFilePath:V1_005_EMPLOYEE.sql
--changeset sanasov:1.5 runOnChange:true context:prod
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  id             INTEGER PRIMARY KEY AUTOINCREMENT,
  fio            VARCHAR(400),
  gender         VARCHAR(100),
  department_id  INTEGER,
  degree         VARCHAR(200),
  position       VARCHAR(200),
  birthday       TIMESTAMP NOT NULL
);