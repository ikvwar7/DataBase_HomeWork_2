--liquibase formatted sql logicalFilePath:V1_007_DEPARTMENT_DATA.sql
--changeset sanasov:1.7 runOnChange:true context:prod


INSERT INTO liga.department (id, title,  address, foundation_year)
VALUES (1, 'Механико-математический', '119991, ГСП-1, Москва, Ленинские горы, МГУ, д.1, Главное здание, механико-математический факультет', 1932);

INSERT INTO liga.department (id, title,  address, foundation_year)
VALUES (2, 'Физический', '119991, Москва, ГСП-1, Ленинские горы, МГУ, д. 1, стр. 2, Физический факультет', 1933);

INSERT INTO liga.department (id, title,  address, foundation_year)
VALUES (3, 'Исторический', '119992, г. Москва, Ломоносовский проспект, д. 27, корп. 4, Исторический факультет МГУ', 1934);