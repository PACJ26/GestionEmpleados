/*Empleados*/

INSERT INTO Registro_Empleados (Nombres, Apellidos, Documento, Tipo_Documento, Sexo, Telefono, Correo_Electronico, Direccion, Fecha_Nacimiento, Fecha_Contrato, salario)
VALUES ('Juan', 'Perez', '12345678', 'Cedula', 'Masculino', '987654321', 'juan.perez@example.com', 'Calle 123', '1990-01-15', '2020-03-01', 2000.00);

INSERT INTO Registro_Empleados (Nombres, Apellidos, Documento, Tipo_Documento, Sexo, Telefono, Correo_Electronico, Direccion, Fecha_Nacimiento, Fecha_Contrato, salario)
VALUES ('Maria', 'Lopez', '87654321', 'Cedula', 'Femenino', '987123456', 'maria.lopez@example.com', 'Avenida 456', '1995-05-20', '2019-06-15', 1800.00);

/*Asistencia*/

INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (1, '2022-01-01', '08:00:00', '16:30:00');

INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (2, '2022-01-01', '08:30:00', '17:00:00');

-- Empleado que cumple con la condición de hora de salida después de las 6:00 pm
INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (1, '2022-01-01', '08:00:00', '18:30:00');

-- Otro empleado que cumple con la condición de hora de salida después de las 6:00 pm
INSERT INTO Registro_Entrada_Salida (id_Empleado, Fecha, Hora_Entrada, Hora_Salida)
VALUES (2, '2022-01-01', '09:00:00', '19:00:00');


/*Permisos*/
INSERT INTO Registro_Permisos (Tipo_Permiso, Fecha_Inicio, Fecha_Fin, Remunerado, id_Empleado)
VALUES ('Vacaciones', '2022-07-01', '2022-07-05', true, 1);

INSERT INTO Registro_Permisos (Tipo_Permiso, Fecha_Inicio, Fecha_Fin, Remunerado, id_Empleado)
VALUES ('Enfermedad', '2022-08-10', '2022-08-15', false, 2);

/*Consultas*/

/*Reporte de hora de entrada y salida tanto
de todos los empleados, como de un empleado especifico en un rango de fecha.*/

-- Reporte de hora de entrada y salida de todos los empleados en un rango de fecha
SELECT * FROM Registro_Entrada_Salida WHERE Fecha BETWEEN '2022-01-01' AND '2022-01-31';

-- Reporte de hora de entrada y salida de un empleado específico en un rango de fecha (por ejemplo, empleado con ID=1)
SELECT * FROM Registro_Entrada_Salida WHERE Fecha BETWEEN '2022-01-01' AND '2022-01-31' AND id_Empleado = 1;

/*Reporte de todos los empleados y de un empleado en especifico que ingresaron tarde en un rango de fecha, 
tomando como hora de entrada las 8:00 am.
*/

SELECT * FROM Registro_Entrada_Salida 
WHERE Hora_Entrada > '08:00:00' 
AND Fecha BETWEEN '2022-01-01' AND '2022-01-31';

/*Reporte de las horas extras,  tando de todos empleados como de un empleado especifico en un rango de fecha, 
contando la hora de salida a las 6:00 pm.
*/

-- Horas extras de todos los empleados en un rango de fecha (hora de salida después de las 6:00 pm)
SELECT * FROM Registro_Entrada_Salida 
WHERE Hora_Salida > '18:00:00' 
AND Fecha BETWEEN '2022-01-01' AND '2022-01-31';

-- Horas extras de un empleado específico en un rango de fecha (por ejemplo, empleado con ID=1)
SELECT * FROM Registro_Entrada_Salida 
WHERE Hora_Salida > '18:00:00' 
AND Fecha BETWEEN '2022-01-01' AND '2022-01-31' 
AND id_Empleado = 1;