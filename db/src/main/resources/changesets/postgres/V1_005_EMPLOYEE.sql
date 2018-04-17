--liquibase formatted sql logicalFilePath:V1_005_EMPLOYEE.sql
--changeset sanasov:1.5 runOnChange:true context:prod

CREATE TABLE liga.employee (
  id             BIGSERIAL PRIMARY KEY,
  fio            VARCHAR(400),
  gender         VARCHAR(100),
  department_id  bigint,
  degree         VARCHAR(200),
  position       VARCHAR(200),
  birthday       TIMESTAMP NOT NULL
);