drop database empleados;
create database empleados;
use empleados;

CREATE TABLE tipoCargos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoCargo VARCHAR(50) 
);

CREATE TABLE tipoGenero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoGenero VARCHAR(50) 
);
CREATE TABLE tipoDocumentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoDocumento VARCHAR(50) 
);
CREATE TABLE Empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    documento VARCHAR(20),
    numeroTelefonico VARCHAR(20),
    direccion VARCHAR(100),
    correoElectronico VARCHAR(100),
    fechaNacimiento DATE,
    fechaContratacion DATE,
    salario varchar(50), tipoDocumento int,cargo int , genero int, foreign key(tipoDocumento) references empleados.tipoDocumentos(id),
    foreign key(cargo) references empleados.tipoCargos(id), foreign key(genero) references empleados.tipoGenero(id)
);

CREATE TABLE RegistroEntradaSalida (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    horaEntrada TIME,
    horaSalida TIME,
	UNIQUE (id_empleado, fecha), 
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);



-- proceso almacenado de registrar salida y entrada

DELIMITER //

CREATE PROCEDURE RegistrarEntradaEmpleado(
    IN p_documento VARCHAR(20),
    IN p_fecha DATE,
    IN p_horaEntrada TIME,
    OUT p_mensaje VARCHAR(100) -- Parámetro de salida para el mensaje
)
BEGIN
    DECLARE v_empleado_id INT;

    -- Verificar si el documento del empleado existe en la tabla de empleados
    SELECT id INTO v_empleado_id
    FROM Empleado
    WHERE documento = p_documento;

    -- Si el documento del empleado no existe, mostrar un mensaje de error y salir del procedimiento
    IF v_empleado_id IS NULL THEN
        SET p_mensaje = 'Documento no existe'; -- Asignar el mensaje de error
    ELSE
        -- Verificar si ya existe un registro de entrada para este empleado en la fecha proporcionada
        IF NOT EXISTS (
            SELECT 1
            FROM RegistroEntradaSalida
            WHERE id_empleado = v_empleado_id
            AND fecha = p_fecha
        ) THEN
            -- Insertar el registro de entrada para el empleado si no existe
            INSERT INTO RegistroEntradaSalida (id_empleado, fecha, horaEntrada)
            VALUES (v_empleado_id, p_fecha, p_horaEntrada);
            SET p_mensaje = 'Registro de entrada ingresado exitosamente.'; -- Asignar el mensaje de éxito
        ELSE
            SET p_mensaje = 'Ya se ha registrado la entrada para este empleado en la fecha proporcionada.'; -- Asignar el mensaje de entrada duplicada
        END IF;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE RegistrarSalidaEmpleado(
    IN p_documento VARCHAR(20),
    IN p_fecha DATE,
    IN p_horaSalida TIME,
    OUT p_mensaje VARCHAR(100) -- Parámetro de salida para el mensaje
)
BEGIN
    DECLARE v_empleado_id INT;

    -- Verificar si el documento del empleado existe en la tabla de empleados
    SELECT id INTO v_empleado_id
    FROM Empleado
    WHERE documento = p_documento;

    -- Si el documento del empleado no existe, mostrar un mensaje de error y salir del procedimiento
    IF v_empleado_id IS NULL THEN
        SET p_mensaje = 'Documento no existe'; -- Asignar el mensaje de error
    ELSE
        -- Verificar si ya existe un registro de salida para este empleado en la fecha proporcionada
        IF NOT EXISTS (
            SELECT 1
            FROM RegistroEntradaSalida
            WHERE id_empleado = v_empleado_id
            AND fecha = p_fecha
            AND horaSalida IS NOT NULL
        ) THEN
            -- Actualizar el registro de salida para el empleado si no existe
            UPDATE RegistroEntradaSalida
            SET horaSalida = p_horaSalida
            WHERE id_empleado = v_empleado_id
            AND fecha = p_fecha;
            SET p_mensaje = 'Registro de salida actualizado exitosamente.'; 
        ELSE
            SET p_mensaje = 'Ya se ha registrado la salida para este empleado en la fecha proporcionada.'; -- Asignar el mensaje de salida duplicada
        END IF;
    END IF;
END //

DELIMITER ;



-- Llamar al procedimiento con valores de prueba
CALL RegistrarEntradaEmpleado('adasdas', '2024-04-25', '08:00:00');





CREATE TABLE Permiso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    remunerado BOOLEAN,
    motivo VARCHAR(100),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
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

-- Insertar tipos de cargos
INSERT INTO tipoCargos (tipoCargo) VALUES ('empleado'), ('administrador'), ('gerente');

-- Procedimiento almacenado para mostrar tipos de cargos.
DELIMITER //

CREATE PROCEDURE MostrarTiposCargos()
BEGIN
    SELECT * FROM tipoCargos;
END //

DELIMITER ;

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

    -- Contar el número de registros con el mismo documento
    SELECT COUNT(*) INTO contador
    FROM Empleado
    WHERE documento = p_documento;

    -- Si el contador es mayor que cero, significa que el documento ya existe
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
    INNER JOIN TipoDocumentos td ON td.id=e.tipoDocumento
    INNER JOIN TipoGenero g ON g.id=e.genero
    INNER JOIN TipoCargos c ON c.id=e.cargo;
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

-- llamar al proceso para todos los empleados
call ReporteEntradaSalida('2024-04-26','2024-04-27',null);
-- llamar al proceso para un empleado
call ReporteEntradaSalida('2024-04-26','2024-04-27','documento');


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

DELIMITER //

CREATE PROCEDURE IniciarSesion(
    IN p_documento VARCHAR(20),
    IN p_clave VARCHAR(20),
    OUT p_mensaje VARCHAR(100)
)
BEGIN
    DECLARE v_empleado_id INT;

    -- Verificar si el documento del empleado existe en la tabla de empleados
    SELECT id INTO v_empleado_id
    FROM Empleado
    WHERE documento = p_documento;

    -- Si el documento del empleado no existe, mostrar un mensaje de error y salir del procedimiento
    IF v_empleado_id IS NULL THEN
        SET p_mensaje = 'Usuario no encontrado'; -- Asignar el mensaje de error
    ELSE
        -- Verificar si la clave proporcionada coincide con el documento del empleado
        IF EXISTS (
            SELECT 1
            FROM Empleado
            WHERE id = v_empleado_id AND documento = p_clave
        ) THEN
            SET p_mensaje = 'Inicio de sesión exitoso'; -- Asignar el mensaje de éxito
        ELSE
            SET p_mensaje = 'Clave incorrecta'; -- Asignar el mensaje de clave incorrecta
        END IF;
    END IF;
END

DELIMITER ;


-- ejemplos insercion empleados

CALL RegistrarEmpleado('Juan', 'Perez', '1234567890', '1', '1234567890', 'Calle 123', 'juan@example.com', '1', '1990-01-01', '2024-04-26', '3', '50000');
CALL RegistrarEmpleado('Maria', 'Lopez', '0987654321', '1', '0987654321', 'Avenida 456', 'maria@example.com', '2', '1995-05-15', '2024-04-26', '1', '40000');
CALL RegistrarEmpleado('Pedro', 'Gonzalez', '4567890123', '1', '4567890123', 'Calle Principal', 'pedro@example.com', '1', '1985-08-20', '2024-04-26', '2', '45000');
CALL RegistrarEmpleado('Ana', 'Martinez', '9876543210', '1', '9876543210', 'Avenida Central', 'ana@example.com', '2', '1992-11-30', '2024-04-26', '2', '55000');
CALL RegistrarEmpleado('Carlos', 'Rodriguez', '1357924680', '1', '1357924680', 'Calle Secundaria', 'carlos@example.com', '1', '1988-04-10', '2024-04-26', '1', '60000');
CALL RegistrarEmpleado('Luisa', 'Sanchez', '2468013579', '1', '2468013579', 'Calle 789', 'luisa@example.com', '2', '1998-07-25', '2024-04-26', '3', '48000');

-- ejemplos de entrada y salida
CALL RegistrarEntradaEmpleado('1234567890','2024-04-26','8:10', @p_mensaje);
CALL RegistrarEntradaEmpleado('0987654321','2024-04-26','8:00', @p_mensaje);
CALL RegistrarEntradaEmpleado('4567890123','2024-04-28','8:35', @p_mensaje);
CALL RegistrarEntradaEmpleado('9876543210','2024-04-27','8:15', @p_mensaje);
CALL RegistrarEntradaEmpleado('1357924680','2024-04-27','8:00', @p_mensaje);
CALL RegistrarEntradaEmpleado('2468013579','2024-04-26','8:00', @p_mensaje);

-- Ejempplo de datos salida
CALL RegistrarSalidaEmpleado('1234567890','2024-04-26','12:10', @p_mensaje);
CALL RegistrarSalidaEmpleado('0987654321','2024-04-26','13:00', @p_mensaje);
CALL RegistrarSalidaEmpleado('4567890123','2024-04-28','12:35', @p_mensaje);
CALL RegistrarSalidaEmpleado('9876543210','2024-04-27','17:15', @p_mensaje);
CALL RegistrarSalidaEmpleado('1357924680','2024-04-27','14:20', @p_mensaje);
CALL RegistrarSalidaEmpleado('2468013579','2024-04-26','16:30', @p_mensaje);

