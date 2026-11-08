BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Alunos" (
	"id"	INTEGER NOT NULL,
	"matricula"	INTEGER NOT NULL UNIQUE,
	"nome"	VARCHAR NOT NULL,
	"dataNascimento"	DATE NOT NULL,
	"rg"	VARCHAR NOT NULL,
	"cpf"	VARCHAR NOT NULL,
	"id_responsavel_1"	INTEGER NOT NULL,
	"id_responsavel_2"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("id_responsavel_1") REFERENCES "Responsaveis"("id") ON UPDATE NO ACTION ON DELETE NO ACTION,
	FOREIGN KEY("id_responsavel_2") REFERENCES "Responsaveis"("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE IF NOT EXISTS "Atendimentos" (
	"id"	INTEGER NOT NULL,
	"id_aluno"	INTEGER NOT NULL,
	"data"	DATE NOT NULL,
	"relatorio"	TEXT NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY("id_aluno") REFERENCES "Alunos"("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE IF NOT EXISTS "Contas" (
	"id"	INTEGER NOT NULL,
	"descricao"	TEXT,
	"valor"	REAL,
	"mes_referencia"	DATE,
	"vencimento"	DATE,
	"situacao"	TEXT NOT NULL DEFAULT 'pendente' CHECK("situacao" IN ('pendente', 'paga')),
	"data_pagamento"	DATE,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Responsaveis" (
	"id"	INTEGER NOT NULL,
	"nome"	VARCHAR NOT NULL,
	"dataNascimento"	DATE NOT NULL,
	"rg"	VARCHAR NOT NULL,
	"cpf"	VARCHAR NOT NULL,
	"cep"	TEXT NOT NULL,
	"logradouro"	TEXT NOT NULL,
	"numero"	TEXT NOT NULL,
	"complemento"	TEXT,
	"bairro"	TEXT NOT NULL,
	"cidade"	TEXT NOT NULL,
	"estado"	TEXT NOT NULL DEFAULT 'RJ',
	"celular"	VARCHAR NOT NULL,
	"telefone"	VARCHAR NOT NULL,
	"email"	VARCHAR NOT NULL,
	PRIMARY KEY("id")
);
COMMIT;
