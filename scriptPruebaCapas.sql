drop DATABASE pruebaCapas;
create database pruebaCapas;
use pruebaCapas;

create table Carreras (
    codigo varchar(30) not null,
    nombre varchar(40),
    titulo varchar(50),
    Primary Key (codigo)
);

insert into Carreras(codigo,nombre,titulo)
values ('100','Matematica','Matematica 125');

