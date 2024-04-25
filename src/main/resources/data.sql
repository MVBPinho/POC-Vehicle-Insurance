INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Fulano', '12345678904', 29, 'SP', 18123.02);
INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Beltrano', '12345678901', 30, 'CE', 70050.00);
INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Ciclano', '12345678902', 71, 'BH', 25000.00);
INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Deltrano', '12345678903', 18, 'SP', 120000.49);

INSERT INTO TB_INSURANCE (type, cost) VALUES ('BASIC', 2);
INSERT INTO TB_INSURANCE (type, cost) VALUES ('PARTIAL', 3);
INSERT INTO TB_INSURANCE (type, cost) VALUES ('TOTAL', 4);

INSERT INTO TB_PERMISSION (description) VALUES ('ADMIN');
INSERT INTO TB_PERMISSION (description) VALUES ('MANAGER');
INSERT INTO TB_PERMISSION (description) VALUES ('COMMON_USER');

INSERT INTO TB_USERS (user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES ('teste', 'Nome Teste', 'bcf4daed13eb2ec1ae2747de13f8c8eb1f90236fdc16f72b5cc327ae1172d29ea4defa013b3c14b1', true, true, true, true);

INSERT INTO TB_USER_PERMISSION (id_user, id_permission) VALUES(1, 1);
INSERT INTO TB_USER_PERMISSION (id_user, id_permission) VALUES(1, 2);