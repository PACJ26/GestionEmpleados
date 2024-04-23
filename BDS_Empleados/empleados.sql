create database empleados;
use empleados;

CREATE TABLE Empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    documento VARCHAR(20),
    tipoDocumento VARCHAR(20),
    numeroTelefonico VARCHAR(20),
    direccion VARCHAR(100),
    correoElectronico VARCHAR(100),
    genero VARCHAR(10),
    fechaNacimiento DATE,
    fechaContratacion DATE,
    cargo VARCHAR(50),
    salario varchar(50)
);

CREATE TABLE RegistroEntradaSalida (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    horaEntrada TIME,
    horaSalida TIME,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);

CREATE TABLE Permiso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    remunerado BOOLEAN,
    motivo VARCHAR(100),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);


-- Crear tabla tipoDocumentos
CREATE TABLE tipoDocumentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoDocumento VARCHAR(50) 
);

-- Insertar tipos de documentos
INSERT INTO tipoDocumentos (tipoDocumento) VALUES ('cedula'), ('pasaporte'), ('otro');

-- Procedimiento almacenado para mostrar tipos de documentos.
DELIMITER //

CREATE PROCEDURE MostrarTiposDocumentos()
BEGIN
    SELECT * FROM tipoDocumentos;
END //

DELIMITER ;

-- Crear tabla tipoCargos
CREATE TABLE tipoCargos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoCargo VARCHAR(50) 
);

-- Insertar tipos de cargos
INSERT INTO tipoCargos (tipoCargo) VALUES ('empleado'), ('administrador'), ('gerente');

-- Procedimiento almacenado para mostrar tipos de cargos.
DELIMITER //

CREATE PROCEDURE MostrarTiposCargos()
BEGIN
    SELECT * FROM tipoCargos;
END //

DELIMITER ;

-- Crear tabla Genero
CREATE TABLE tipoGenero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoGenero VARCHAR(50) 
);

-- Insertar tipos de Generos
INSERT INTO tipoGenero (tipoGenero) VALUES ('Masculino'), ('Femenino'), ('Otro');

-- Procedimiento almacenado para mostrar tipos de generos.
DELIMITER //

CREATE PROCEDURE MostrarTiposGeneros()
BEGIN
    SELECT * FROM tipoGenero;
END //

DELIMITER ;

-- Proceso para registrar un empleado.

DELIMITER //

CREATE PROCEDURE RegistrarEmpleado(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_documento VARCHAR(20),
    IN p_tipoDocumento VARCHAR(20),
    IN p_numeroTelefonico VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_correoElectronico VARCHAR(100),
    IN p_genero VARCHAR(10),
    IN p_fechaNacimiento DATE,
    IN p_fechaContratacion DATE,
    IN p_cargo VARCHAR(50),
    IN p_salario VARCHAR(50)
)
BEGIN
    INSERT INTO Empleado (nombres, apellidos, documento, tipoDocumento, numeroTelefonico,
                         direccion, correoElectronico, genero, fechaNacimiento, fechaContratacion,
                         cargo, salario)
    VALUES (p_nombres, p_apellidos, p_documento, p_tipoDocumento, p_numeroTelefonico,
            p_direccion, p_correoElectronico, p_genero, p_fechaNacimiento, p_fechaContratacion,
            p_cargo, p_salario);
END //

DELIMITER ;

-- proceso validar documento

DELIMITER //

CREATE PROCEDURE ValidarDocumentoUnico(
    IN p_documento VARCHAR(20),
    OUT p_existe BOOLEAN
)
BEGIN
    DECLARE contador INT;

    SELECT COUNT(*) INTO contador
    FROM Empleado
    WHERE documento = p_documento;

    IF contador > 0 THEN
        SET p_existe = TRUE;
    ELSE
        SET p_existe = FALSE;
    END IF;
END //

DELIMITER ;

-- ver tabla empleado muestra todos los datos del empleado

DELIMITER //

CREATE PROCEDURE MostrarEmpleados()
BEGIN
    SELECT e.id, e.nombres, e.apellidos, e.documento, td.tipoDocumento, e.numeroTelefonico, e.direccion, e.correoElectronico, g.tipoGenero, e.fechaNacimiento, e.fechaContratacion, c.tipoCargo, e.salario
    FROM Empleado e
    INNER JOIN TipoDocumentos td ON e.tipoDocumento = td.id
    INNER JOIN TipoGenero g ON e.genero = g.id
    INNER JOIN TipoCargos c ON e.cargo = c.id;
END //

DELIMITER ;

-- Procesos almacenados para reportes

/*1. Reporte de hora de entrada y salida*/

DELIMITER //
CREATE PROCEDURE ReporteEntradaSalida(
    IN fechaInicio DATE,
    IN fechaFin DATE,
    IN idEmpleado INT
)
BEGIN
    IF idEmpleado IS NULL THEN
        -- Reporte para todos los empleados
        SELECT *
        FROM RegistroEntradaSalida
        WHERE fecha BETWEEN fechaInicio AND fechaFin;
    ELSE
        -- Reporte para un empleado específico
        SELECT *
        FROM RegistroEntradaSalida
        WHERE fecha BETWEEN fechaInicio AND fechaFin
        AND id_empleado = idEmpleado;
    END IF;
END //
DELIMITER ;

/*2. Reporte de empleados que ingresaron tarde*/

DELIMITER //
CREATE PROCEDURE ReporteIngresosTarde(
    IN fechaInicio DATE,
    IN fechaFin DATE
)
BEGIN
    SELECT *
    FROM RegistroEntradaSalida
    WHERE fecha BETWEEN fechaInicio AND fechaFin
    AND horaEntrada > '08:00:00';
END //
DELIMITER ;

/*3. Reporte de horas extras*/

DELIMITER //
CREATE PROCEDURE ReporteHorasExtras(
    IN fechaInicio DATE,
    IN fechaFin DATE
)
BEGIN
    SELECT *
    FROM RegistroEntradaSalida
    WHERE fecha BETWEEN fechaInicio AND fechaFin
    AND horaSalida > '18:00:00';
END //
DELIMITER ;

/*4. Reporte de permisos*/

DELIMITER //
CREATE PROCEDURE ReportePermisos(
    IN mes INT,
    IN idEmpleado INT
)
BEGIN
    IF idEmpleado IS NULL THEN
        -- Reporte para todos los empleados
        SELECT *
        FROM Permiso
        WHERE MONTH(fecha) = mes;
    ELSE
        -- Reporte para un empleado específico
        SELECT *
        FROM Permiso
        WHERE MONTH(fecha) = mes
        AND id_empleado = idEmpleado;
    END IF;
END //
DELIMITER ;




