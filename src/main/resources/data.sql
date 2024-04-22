--INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Ciclano', '12345678902', 71, 'BH', 25000.00);
--INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Deltrano', '12345678903', 18, 'CE', 70050.00);
--INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Fulano', '12345678904', 29, 'SP', 18123.02);
INSERT INTO TB_CUSTOMER (name, cpf, age, location, value_vehicle) VALUES ('Beltrano', '12345678901', 30, 'RS', 70050.00);


INSERT INTO TB_INSURANCE (type, cost) VALUES ('BASIC', 2);
INSERT INTO TB_INSURANCE (type, cost) VALUES ('PARTIAL', 3);
INSERT INTO TB_INSURANCE (type, cost) VALUES ('TOTAL', 4);

INSERT INTO TB_CUSTOMER_INSURANCE (id_customer, id_insurance) VALUES (1, 1);
INSERT INTO TB_CUSTOMER_INSURANCE (id_customer, id_insurance) VALUES (1, 2);

--INSERT INTO TB_INSURANCE (type, cost) VALUES ('PARTIAL', 3);
--INSERT INTO TB_INSURANCE (type, cost) VALUES ('BASIC', 2);
--INSERT INTO TB_INSURANCE (type, cost) VALUES ('TOTAL', 4);
--INSERT INTO TB_INSURANCE (type, cost) VALUES ('PARTIAL', 3);