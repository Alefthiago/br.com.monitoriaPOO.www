CREATE DATABASE IF NOT EXISTS monitoria_poo;

USE monitoria_poo;

CREATE TABLE bank_client
(
	BC_cpf VARCHAR (11),
    BC_name VARCHAR(100) NOT NULL,
    BC_pass VARCHAR(500) NOT NULL,
    CONSTRAINT BC_PK PRIMARY KEY (BC_cpf)
);

CREATE TABLE bank_account
(
	BA_number BIGINT,
    BA_type VARCHAR(45) NOT NULL,
    BA_balance DECIMAL(10, 2) NOT NULL,
    BA_status TINYINT NOT NULL,
    BC_cpf VARCHAR (11),
    CONSTRAINT BC_PK PRIMARY KEY (BA_number),
    CONSTRAINT BC_FK FOREIGN KEY (BC_cpf) REFERENCES bank_client (BC_cpf)
);

CREATE TABLE transaction_record
(
	TR_number BIGINT,
    TR_originNumberAccount BIGINT,
    TR_destinyNumberAccount BIGINT,
    TR_dateTransaction DATE NOT NULL,
    TR_valueTransaction DECIMAL(10, 2) NOT NULL,
    CONSTRAINT TR_PK PRIMARY KEY (TR_number),
    CONSTRAINT TR_FK_originNumberAccount FOREIGN KEY (TR_originNumberAccount) REFERENCES bank_account (BA_number),
    CONSTRAINT TR_FK_destinyNumberAccount FOREIGN KEY (TR_destinyNumberAccount) REFERENCES bank_account (BA_number)
);

CREATE TABLE bank_Account_has_transaction_record
(
	BA_number BIGINT,
    TR_number BIGINT,
    CONSTRAINT FK_BA FOREIGN KEY (BA_number) REFERENCES bank_account (BA_number),
    CONSTRAINT FK_TR FOREIGN KEY (TR_number) REFERENCES transaction_record (TR_number)
)