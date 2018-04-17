--liquibase formatted sql logicalFilePath:V1_008_EMPLOYEE_DATA.sql
--changeset sanasov:1.8 runOnChange:true context:prod

INSERT INTO employee (fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Владимир Николаевич Чубариков', 'MALE', 1, 'Доктор наук','Dean', date('1951-09-05'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Сысоев Николай Николаевич', 'MALE', 2, 'Доктор наук','Dean', date('1949-11-15'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Тучков Иван Иванович', 'MALE', 3, 'Доктор наук','Dean', date('1956-09-13'));


INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Комбаров Анатолий Петрович', 'MALE', 1, 'Доктор наук','Professor', date('1967-03-05'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Корнев Андрей Алексеевич', 'MALE', 1, 'Доктор наук','Lecturer', date('1971-08-13'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Штерн Александр Исаакович', 'MALE', 1, 'Доктор наук','Professor', date('1948-06-05'));


INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Караваев Владимир Александрович', 'MALE', 2, 'Кандидат наук','Lecturer', date('1983-06-15'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Тверской Василий Борисович ', 'MALE', 2, 'Доктор наук','Professor', date('1967-02-28'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Соколов Владимир Андреевич', 'MALE', 2, 'Кандидат наук','Lecturer', date('1975-08-07'));


INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Гутнова Евгения Владимировна', 'FEMALE', 3, 'Доктор наук','Professor', date('1969-10-23'));

INSERT INTO employee (  fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Дыбо Анна Владимировна', 'FEMALE', 3, 'Кандидат наук','Lecturer', date('1978-07-10'));



INSERT INTO employee (fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Соколов Владимир Андреевич', 'MALE', 2, 'BACHELOR','Secretary', date('1975-08-07'));
INSERT INTO employee (fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Гутнова Евгения Владимировна', 'FEMALE', 3, 'MASTER','Secretary', date('1969-10-23'));
INSERT INTO employee (fio,  gender,  department_id,  degree,  position,  birthday)
VALUES('Дыбо Анна Владимировна', 'FEMALE', 3, 'BACHELOR','Secretary', date('1978-07-10'));




