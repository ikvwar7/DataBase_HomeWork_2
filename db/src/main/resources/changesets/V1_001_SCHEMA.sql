--liquibase formatted sql logicalFilePath:V1_001_SCHEMA.sql
--changeset sanasov:1.1 runOnChange:true context:prod
DROP SCHEMA IF EXISTS liga CASCADE;