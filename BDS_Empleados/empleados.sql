-- drop database empleados;
create database empleados;
use empleados;

CREATE TABLE tipoCargos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoCargo VARCHAR(50) 
);

-- Insertar tipos de cargos
INSERT INTO tipoCargos (tipoCargo) VALUES ('empleado'), ('administrador'), ('gerente');

-- Mostrar tipos de cargos.

DELIMITER //
CREATE PROCEDURE MostrarTiposCargos()
BEGIN
    SELECT * FROM tipoCargos;
END //
DELIMITER ;

CREATE TABLE tipoGenero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoGenero VARCHAR(50) 
);

-- Insertar tipos de Generos
INSERT INTO tipoGenero (tipoGenero) VALUES ('Masculino'), ('Femenino'), ('Otro');

-- Mostrar tipos de generos.
DELIMITER //
CREATE PROCEDURE MostrarTiposGeneros()
BEGIN
    SELECT * FROM tipoGenero;
END //
DELIMITER ;

CREATE TABLE tipoDocumentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoDocumento VARCHAR(50) 
);

-- Insertar tipos de documentos
INSERT INTO tipoDocumentos (tipoDocumento) VALUES ('cedula'), ('pasaporte'), ('otro');

-- Mostrar tipos de documentos.
DELIMITER //
CREATE PROCEDURE MostrarTiposDocumentos()
BEGIN
    SELECT * FROM tipoDocumentos;
END //
DELIMITER ;


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
    salario varchar(50),
    clave varchar(20), tipoDocumento int,cargo int , genero int, foreign key(tipoDocumento) references empleados.tipoDocumentos(id),
    foreign key(cargo) references empleados.tipoCargos(id), foreign key(genero) references empleados.tipoGenero(id)
);

-- Proceso para registrar un empleado.

DELIMITER //
CREATE PROCEDURE RegistrarEmpleado(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_documento VARCHAR(20),
    IN p_tipoDocumento INT, 
    IN p_numeroTelefonico VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_correoElectronico VARCHAR(100),
    IN p_genero INT, 
    IN p_fechaNacimiento DATE,
    IN p_fechaContratacion DATE,
    IN p_cargo INT,
    IN p_salario VARCHAR(50),
    IN p_clave VARCHAR(20) 
)
BEGIN
    INSERT INTO Empleado (nombres, apellidos, documento, clave, tipoDocumento, numeroTelefonico,
                         direccion, correoElectronico, genero, fechaNacimiento, fechaContratacion,
                         cargo, salario)
    VALUES (p_nombres, p_apellidos, p_documento, p_clave, p_tipoDocumento, p_numeroTelefonico,
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
    SELECT e.nombres 'Nombres',
    e.apellidos 'Apellidos', 
    e.documento 'Documento', 
    td.tipoDocumento 'Tipo de Documento', 
    e.numeroTelefonico 'Numero Telefonico', 
    e.direccion 'Dirección', 
    e.correoElectronico 'Correo Electronico', 
    g.tipoGenero 'Tipo de Genero', 
    e.fechaNacimiento 'Fecha Nacimiento', 
    e.fechaContratacion 'Fecha Contratación', 
    c.tipoCargo 'Tipo de Cargo', 
    e.salario 'Salario'
    FROM Empleado e
    INNER JOIN TipoDocumentos td ON td.id=e.tipoDocumento
    INNER JOIN TipoGenero g ON g.id=e.genero
    INNER JOIN TipoCargos c ON c.id=e.cargo;
END //
DELIMITER ;

call MostrarEmpleados();

CREATE TABLE RegistroEntradaSalida (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    horaEntrada TIME,
    horaSalida TIME,
	UNIQUE (id_empleado, fecha), 
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);


-- Proceso para registrar entrada
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

-- Llamar al procedimiento con valores de prueba para registrar entrada
CALL RegistrarEntradaEmpleado('documento', '2024-04-25', '08:00:00');

-- Proceso para registrar salida
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

-- Llamar al procedimiento con valores de prueba para registrar salida
call RegistrarSalidaEmpleado('documento', '2024-04-25', '17:00:00');

CREATE TABLE Permiso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    remunerado BOOLEAN,
    motivo VARCHAR(100),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);



-- Proceso de inicio de sesion
DELIMITER //
CREATE PROCEDURE IniciarSesion(
    IN p_documento VARCHAR(20),
    IN p_clave VARCHAR(20)
)
BEGIN
    DECLARE v_count INT;

    -- Verificar si el usuario existe con el documento proporcionado
    SELECT COUNT(*) INTO v_count
    FROM Empleado
    WHERE documento = p_documento;

    IF v_count = 0 THEN
        SELECT 'Usuario no encontrado' AS mensaje;
    ELSE
        -- Verificar si la clave coincide
        SELECT COUNT(*) INTO v_count
        FROM Empleado
        WHERE documento = p_documento AND clave = p_clave;

        IF v_count = 0 THEN
            SELECT 'Clave incorrecta' AS mensaje;
        ELSE
            SELECT 'Inicio de sesión exitoso' AS mensaje;
        END IF;
    END IF;
END //
DELIMITER ;


-- proceso para obtener cargo del empleado
DELIMITER //
CREATE PROCEDURE ObtenerCargoEmpleado(
    IN p_documento VARCHAR(20)
)
BEGIN
    -- Obtener el cargo del empleado
    SELECT cargo
    FROM Empleado
    WHERE documento = p_documento;
END //
DELIMITER ;


-- Procesos almacenados para reportes

/*1. Reporte de hora de entrada y salida*/

DELIMITER //

CREATE PROCEDURE ReporteEntradaSalida(
    IN fechaInicio DATE,
    IN fechaFin DATE,
    IN documentoEmpleado VARCHAR(20)
)
BEGIN
    SELECT E.nombres 'Nombre', 
    E.apellidos 'Apellido', 
    E.documento 'Documento', 
    RegistroES.fecha 'Fecha', 
    RegistroES.horaEntrada 'Hora de Entrada', 
    RegistroES.horaSalida 'Hora de Salida'
    FROM RegistroEntradaSalida AS RegistroES
    INNER JOIN Empleado AS E ON RegistroES.id_empleado = E.id
    WHERE (documentoEmpleado IS NULL OR E.documento = documentoEmpleado)
    AND RegistroES.fecha BETWEEN fechaInicio AND fechaFin;
END //

DELIMITER ;



-- llamar al proceso para todos los empleados
call ReporteEntradaSalida('2024-04-26','2024-04-27','1234567890');
-- llamar al proceso para un empleado
call ReporteEntradaSalida('2024-04-26','2024-04-27','documento');


/*2. Reporte de empleados que ingresaron tarde*/

DELIMITER //

CREATE PROCEDURE ReporteIngresosTarde(
    IN fechaInicio DATE,
    IN fechaFin DATE,
    IN documentoEmpleado VARCHAR(20)
)
BEGIN
    -- Reporte de un empleado específico que ingresó tarde
    IF documentoEmpleado IS NOT NULL THEN
        SELECT e.documento 'Documento', e.nombres 'Nombre', e.apellidos 'Apellido', res.fecha 'Fecha', res.horaEntrada 'Hora Entrada',
               CASE WHEN res.horaEntrada > '08:00:00' THEN 'Tarde' ELSE 'A tiempo' END AS Llegada
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin
        AND e.documento = documentoEmpleado;
    ELSE
        -- Reporte de todos los empleados que ingresaron tarde
        SELECT e.documento 'Documento', e.nombres 'Nombre', e.apellidos 'Apellido', res.fecha 'Fecha', res.horaEntrada 'Hora Entrada',
               CASE WHEN res.horaEntrada > '08:00:00' THEN 'Tarde' ELSE 'A tiempo' END AS Llegada
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin;
    END IF;
END //

DELIMITER ;



CALL ReporteIngresosTarde('2024-04-26', '2024-05-06', '9876543210');

/*3. Reporte de horas extras*/

DELIMITER //
CREATE PROCEDURE ReporteHorasExtras(
    IN fechaInicio DATE,
    IN fechaFin DATE
)
BEGIN
    SELECT id_empleado, 
           fecha, 
           horaSalida, 
           TIMEDIFF(horaSalida, '18:00:00') AS horasExtras
    FROM RegistroEntradaSalida
    WHERE fecha BETWEEN fechaInicio AND fechaFin
    AND horaSalida > '18:00:00';
END //
DELIMITER ;

CALL ReporteHorasExtras('2024-04-26', '2024-05-06');

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





-- ejemplos insercion empleados

CALL RegistrarEmpleado('Juan', 'Perez', '1234567890', '1', '10055444', 'Calle 123', 'juan@example.com', '1', '1990-01-01', '2024-04-26', '3', '50000','1234567890');
CALL RegistrarEmpleado('Maria', 'Lopez', '0987654321', '1', '0987654321', 'Avenida 456', 'maria@example.com', '2', '1995-05-15', '2024-04-26', '1', '40000','0987654321');
CALL RegistrarEmpleado('Pedro', 'Gonzalez', '4567890123', '1', '4567890123', 'Calle Principal', 'pedro@example.com', '1', '1985-08-20', '2024-04-26', '2', '45000','4567890123');
CALL RegistrarEmpleado('Ana', 'Martinez', '9876543210', '1', '9876543210', 'Avenida Central', 'ana@example.com', '2', '1992-11-30', '2024-04-26', '2', '55000','9876543210');
CALL RegistrarEmpleado('Carlos', 'Rodriguez', '1357924680', '1', '1357924680', 'Calle Secundaria', 'carlos@example.com', '1', '1988-04-10', '2024-04-26', '1', '60000','1357924680');
CALL RegistrarEmpleado('Luisa', 'Sanchez', '2468013579', '1', '2468013579', 'Calle 789', 'luisa@example.com', '2', '1998-07-25', '2024-04-26', '3', '48000','2468013579');

-- ejemplos de entrada emoleado
CALL RegistrarEntradaEmpleado('1234567890','2024-04-26','8:10', @p_mensaje);
CALL RegistrarEntradaEmpleado('0987654321','2024-04-26','8:05', @p_mensaje);
CALL RegistrarEntradaEmpleado('4567890123','2024-04-28','8:35', @p_mensaje);
CALL RegistrarEntradaEmpleado('9876543210','2024-04-27','8:15', @p_mensaje);
CALL RegistrarEntradaEmpleado('1357924680','2024-04-27','8:00', @p_mensaje);
CALL RegistrarEntradaEmpleado('2468013579','2024-04-26','8:00', @p_mensaje);

-- Ejempplo de datos salida empeleado
CALL RegistrarSalidaEmpleado('1234567890','2024-04-26','12:10', @p_mensaje);
CALL RegistrarSalidaEmpleado('0987654321','2024-04-26','20:30', @p_mensaje);
CALL RegistrarSalidaEmpleado('4567890123','2024-04-28','12:35', @p_mensaje);
CALL RegistrarSalidaEmpleado('9876543210','2024-04-27','17:15', @p_mensaje);
CALL RegistrarSalidaEmpleado('1357924680','2024-04-27','14:20', @p_mensaje);
CALL RegistrarSalidaEmpleado('2468013579','2024-04-26','16:30', @p_mensaje);