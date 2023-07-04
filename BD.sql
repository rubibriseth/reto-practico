create database bdcliente;
use bdcliente;

create table CLIENTE(
id_cliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
cli_nombre varchar(100) NOT NULL,
cli_apellido varchar(100) NOT NULL,
cli_edad integer NOT NULL,
cli_fecha_nac date NOT NULL
);

select * from cliente