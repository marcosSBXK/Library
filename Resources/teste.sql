create database biblioteca;

use biblioteca; 

create table livro (
	cod_livro int not null auto_increment,
    titulo varchar (50),
    autor varchar (50),
    primary key (cod_livro),
    foreign key (cod_aluno) references aluno(cod_aluno)
);

create table aluno (
	cod_aluno int not null auto_increment,
    nome_aluno varchar (50),
    tel_aluno varchar (20),
    matricula varchar(14),
    restricao boolean,
    periodo_restricao integer,
    dt_restricao datetime,
    primary key (cod_aluno)
);

create table funcionario (
	cod_func int not null auto_increment,
    nome_func varchar (50),
    tel_func varchar (20),
    senha_func varchar (20),
    primary key (cod_func)
);