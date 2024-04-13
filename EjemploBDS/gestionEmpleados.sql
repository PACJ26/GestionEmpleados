create database gestionEmpleados;
use gestionEmpleados;

create table Registro_Empleados(ID int primary key auto_increment,
Nombres varchar (50), Apellidos varchar(50), Documento varchar (50),
Tipo_Documento varchar (20),Sexo varchar (10),telefono varchar (20),Correo_Electronico varchar (150),
Direccion varchar (150), Fecha_Nacimiento date, Fecha_Contrato date, salario double);

create table Registro_Entrada_Salida(ID int primary key auto_increment, id_Empleado int, Fecha date,
Hora_Entrada time, Hora_Salida time, foreign key(id_Empleado) references gestionEmpleados.Registro_Empleados(ID));

create table Registro_Permisos(ID int primary key auto_increment,Tipo_Permiso varchar (50),
Fecha_Inicio date, Fecha_Fin date, Remunerado boolean, id_Empleado int, foreign key(id_Empleado) references gestionEmpleados.Registro_Empleados(ID));

/*Llenado de Empleados*/

INSERT INTO Registro_Empleados (Nombres, Apellidos, Documento, Tipo_Documento, Sexo, Telefono, Correo_Electronico, Direccion, Fecha_Nacimiento, Fecha_Contrato, Salario)
VALUES ('Juan', 'Perez', '12345678', 'Cedula', 'Masculino', '987654321', 'juan.perez@example.com', 'Calle 123', '1990-01-15', '2020-03-01', 2000.00);

INSERT INTO Registro_Empleados (Nombres, Apellidos, Documento, Tipo_Documento, Sexo, Telefono, Correo_Electronico, Direccion, Fecha_Nacimiento, Fecha_Contrato, Salario)
VALUES ('Maria', 'Lopez', '87654321', 'Cedula', 'Femenino', '987123456', 'maria.lopez@example.com', 'Avenida 456', '1995-05-20', '2019-06-15', 1800.00);

/*Registro salida and entrada*/

INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (1, '2022-01-01', '08:00:00', '16:30:00');

INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (2, '2022-01-01', '08:30:00', '17:00:00');

/*Permisos*/

INSERT INTO Registro_Permisos (Tipo_Permiso, Fecha_Inicio, Fecha_Fin, Remunerado, id_Empleado)
VALUES ('Vacaciones', '2022-07-01', '2022-07-05', true, 1);

INSERT INTO Registro_Permisos (Tipo_Permiso, Fecha_Inicio, Fecha_Fin, Remunerado, id_Empleado)
VALUES ('Enfermedad', '2022-08-10', '2022-08-15', false, 2);

