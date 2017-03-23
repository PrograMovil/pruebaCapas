drop DATABASE pruebaCapas;
create database pruebaCapas;
use pruebaCapas;

create table Carreras (
    codigo varchar(30) not null,
    nombre varchar(40),
    titulo varchar(50),
    Primary Key (codigo)
);

create table Usuarios (
	id varchar(30) not null,
    pass varchar(40), 
    Primary Key (id)
);

insert into Carreras(codigo,nombre,titulo)
values ('100','Matematica','Matematica 125');

insert into Usuarios(id,pass)
values ('12','12');
