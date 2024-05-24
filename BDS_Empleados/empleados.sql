-- drop database empleados;
create database empleados;
use empleados;

CREATE TABLE tipoCargos (

    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoCargo VARCHAR(50) 
);

/*Insertar tipos de cargos

INSERT INTO tipoCargos (tipoCargo) VALUES ('empleado'), ('administrador');
*/

CREATE TABLE tipoGenero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoGenero VARCHAR(50) 
);

/*Insertar tipos de Generos
INSERT INTO tipoGenero (tipoGenero) VALUES ('Masculino'), ('Femenino'), ('Otro');
*/

CREATE TABLE tipoDocumentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoDocumento VARCHAR(50) 
);

/*Insertar tipos de documentos
INSERT INTO tipoDocumentos (tipoDocumento) VALUES ('cedula'), ('pasaporte'), ('otro');
*/

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

CREATE TABLE RegistroEntradaSalida (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    horaEntrada TIME,
    horaSalida TIME,
	UNIQUE (id_empleado, fecha), 
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);

CREATE TABLE Permiso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha DATE,
    remunerado varchar(20),
    motivo VARCHAR(100),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id)
);

CREATE TABLE RegistroInsercionEmpleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accion VARCHAR(255),
    descripcion TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE RegistroModificacionEmpleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accion VARCHAR(255),
    descripcion TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE RegistroSesiones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    documento VARCHAR(20),
    evento VARCHAR(50),
    fechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*Procesos almacenados*/

-- Mostrar tipos de cargos.
DELIMITER //
CREATE PROCEDURE MostrarTiposCargos()
BEGIN
    SELECT * FROM tipoCargos;
END //
DELIMITER ;

-- Mostrar tipos de generos.
DELIMITER //
CREATE PROCEDURE MostrarTiposGeneros()
BEGIN
    SELECT * FROM tipoGenero;
END //
DELIMITER ;

-- Mostrar tipos de documentos.
DELIMITER //
CREATE PROCEDURE MostrarTiposDocumentos()
BEGIN
    SELECT * FROM tipoDocumentos;
END //
DELIMITER ;

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

/*activar funcion.
GRANT CREATE ROUTINE, ALTER ROUTINE ON empleados.* TO 'root'@'localhost';

SHOW VARIABLES LIKE 'log_bin_trust_function_creators';

SET GLOBAL log_bin_trust_function_creators = 1;
*/

/*Funcion crear empleado*/
DELIMITER //
CREATE FUNCTION FuncionRegistrarEmpleado(
    p_nombres VARCHAR(100),
    p_apellidos VARCHAR(100),
    p_documento VARCHAR(20),
    p_tipoDocumento INT, 
    p_numeroTelefonico VARCHAR(20),
    p_direccion VARCHAR(100),
    p_correoElectronico VARCHAR(100),
    p_genero INT, 
    p_fechaNacimiento DATE,
    p_fechaContratacion DATE,
    p_cargo INT,
    p_salario VARCHAR(50),
    p_clave VARCHAR(20)
) RETURNS VARCHAR(255)
BEGIN
    DECLARE resultado VARCHAR(255);
    
    -- Intentar ejecutar el procedimiento almacenado
    BEGIN
        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            -- En caso de error, devolver un mensaje de error
            SET resultado = 'Error al registrar el empleado.';
        END;
        
        -- Llamar al procedimiento almacenado
        CALL RegistrarEmpleado(
            p_nombres,
            p_apellidos,
            p_documento,
            p_tipoDocumento,
            p_numeroTelefonico,
            p_direccion,
            p_correoElectronico,
            p_genero,
            p_fechaNacimiento,
            p_fechaContratacion,
            p_cargo,
            p_salario,
            p_clave
        );
        
        -- Si no hubo errores, devolver un mensaje de éxito
        SET resultado = 'Empleado registrado exitosamente.';
    END;

    RETURN resultado;
END //
DELIMITER ;


/*llamar a la funcion*/
SELECT FuncionRegistrarEmpleado(
    'Juan', -- p_nombres
    'Pérez', -- p_apellidos
    '1234567890', -- p_documento
    1, -- p_tipoDocumento (asumiendo que 1 es el ID del tipo de documento)
    '555-123-4567', -- p_numeroTelefonico
    'Calle Principal 123', -- p_direccion
    'juan.perez@example.com', -- p_correoElectronico
    1, -- p_genero (asumiendo que 1 es el ID del género)
    '1990-05-10', -- p_fechaNacimiento (formato YYYY-MM-DD)
    '2024-05-23', -- p_fechaContratacion (formato YYYY-MM-DD)
    1, -- p_cargo (asumiendo que 1 es el ID del cargo)
    '2500', -- p_salario (suponiendo que es un salario numérico)
    'clave123' -- p_clave
) AS resultado;

/*trigger insertar empleado*/
-- drop trigger after_insert_empleado;
DELIMITER //
CREATE TRIGGER after_insert_empleado
AFTER INSERT ON Empleado
FOR EACH ROW
BEGIN
    INSERT INTO RegistroInsercionEmpleado (accion, descripcion, fecha)
    VALUES ('Registro de Empleado', CONCAT('Se registró el empleado: ', NEW.nombres, ' ', NEW.apellidos), NOW());
END //
DELIMITER ;

//buscar por documento
DELIMITER //
CREATE PROCEDURE BuscarEmpleadoPorDocumento(
    IN p_documento VARCHAR(20)
)
BEGIN
    SELECT * FROM Empleado WHERE documento = p_documento;
END //
DELIMITER ;

/*CALL BuscarEmpleadoPorDocumento('4567890123');*/

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

//modificar un empleado
DELIMITER //
CREATE PROCEDURE ModificarEmpleadoPorDocumento(
    IN p_documento VARCHAR(20),
    IN p_nuevoDocumento VARCHAR(20),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
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
    UPDATE Empleado
    SET documento = p_nuevoDocumento,
        nombres = p_nombres,
        apellidos = p_apellidos,
        tipoDocumento = p_tipoDocumento,
        numeroTelefonico = p_numeroTelefonico,
        direccion = p_direccion,
        correoElectronico = p_correoElectronico,
        genero = p_genero,
        fechaNacimiento = p_fechaNacimiento,
        fechaContratacion = p_fechaContratacion,
        cargo = p_cargo,
        salario = p_salario,
        clave = p_clave
    WHERE documento = p_documento;
END //
DELIMITER ;

/*trigger modificar empleado*/
/*DROP TRIGGER ModificarEmpleadoPorDocumento_trigger;*/
DELIMITER //
CREATE TRIGGER ModificarEmpleadoPorDocumento_trigger
AFTER UPDATE ON Empleado
FOR EACH ROW
BEGIN
    DECLARE nombre_empleado VARCHAR(50);

    -- Obtener el nombre completo del empleado que realizó la modificación
    SELECT CONCAT(nombres, ' ', apellidos) INTO nombre_empleado FROM Empleado WHERE id = NEW.id;
    
    -- Insertar el registro en la tabla RegistroOperaciones
    INSERT INTO RegistroModificacionEmpleado(accion, descripcion, fecha)
    VALUES ('Modificación de Empleado', CONCAT('Se modificó el empleado ', nombre_empleado, ' con documento ', OLD.documento), NOW());
END //
DELIMITER ;

-- ver tabla empleado muestra todos los datos del empleado
DELIMITER //
CREATE PROCEDURE MostrarEmpleados()
BEGIN
    SELECT e.nombres 'Nombres',
    e.apellidos 'Apellidos', 
    e.documento 'Documento', 
    td.tipoDocumento 'Tipo Documento', 
    e.numeroTelefonico 'Telefono', 
    e.direccion 'Dirección', 
    e.correoElectronico 'Correo', 
    g.tipoGenero 'Genero', 
    e.fechaNacimiento 'Fecha Nacimiento', 
    e.fechaContratacion 'Fecha Contratación', 
    c.tipoCargo 'Cargo', 
    e.salario 'Salario'
    FROM Empleado e
    INNER JOIN TipoDocumentos td ON td.id=e.tipoDocumento
    INNER JOIN TipoGenero g ON g.id=e.genero
    INNER JOIN TipoCargos c ON c.id=e.cargo;
END //
DELIMITER ;

/*call MostrarEmpleados();*/

/*vista VIEW*/
CREATE VIEW VistaEmpleados AS
SELECT 
    e.nombres 'Nombres',
    e.apellidos 'Apellidos', 
    e.documento 'Documento', 
    td.tipoDocumento 'Tipo Documento', 
    e.numeroTelefonico 'Telefono', 
    e.direccion 'Dirección', 
    e.correoElectronico 'Correo', 
    g.tipoGenero 'Genero', 
    e.fechaNacimiento 'Fecha Nacimiento', 
    e.fechaContratacion 'Fecha Contratación', 
    c.tipoCargo 'Cargo', 
    e.salario 'Salario'
FROM 
    Empleado e
INNER JOIN 
    TipoDocumentos td ON td.id = e.tipoDocumento
INNER JOIN 
    TipoGenero g ON g.id = e.genero
INNER JOIN 
    TipoCargos c ON c.id = e.cargo;

/*SELECT * FROM VistaEmpleados;*/


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
/*CALL RegistrarEntradaEmpleado('documento', '2024-04-25', '08:00:00');*/

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
/*call RegistrarSalidaEmpleado('documento', '2024-04-25', '17:00:00');*/

/*Registrar permiso*/
DELIMITER //
CREATE PROCEDURE RegistrarPermiso(
    IN empleadoDocumento VARCHAR(20),
    IN permisoFecha DATE,
    IN permisoRemunerado BOOLEAN,
    IN permisoMotivo VARCHAR(100)
)
BEGIN
    -- Obtener el ID del empleado
    DECLARE empleadoId INT;
    
    SELECT id INTO empleadoId
    FROM Empleado WHERE documento = empleadoDocumento;
    
    -- Verificar si el empleado existe
    IF empleadoId IS NOT NULL THEN
        -- Insertar el permiso en la tabla Permiso
        INSERT INTO Permiso (id_empleado, fecha, remunerado, motivo)
        VALUES (empleadoId, permisoFecha, 
                CASE WHEN permisoRemunerado THEN 'remunerado' ELSE 'no remunerado' END,
                permisoMotivo);
        
        -- Mostrar mensaje de éxito
        SELECT 'Permiso registrado correctamente' AS Mensaje;
    ELSE
        -- Empleado no encontrado, mostrar mensaje de error
        SELECT 'El empleado no existe' AS Error;
    END IF;
END //
DELIMITER ;
/*CALL RegistrarPermiso('0987654321', '2024-05-24', false, 'vacaciones');*/

-- Proceso de inicio de sesion no funcional
/*DELIMITER //
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
DELIMITER ;*/

-- Proceso inicio de sesion Funcional
DELIMITER //
CREATE PROCEDURE IniciarSesion(
    IN p_documento VARCHAR(20),
    IN p_clave VARCHAR(20)
)
BEGIN
    DECLARE v_count INT;
    DECLARE v_cargo INT;

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
            INSERT INTO RegistroSesiones (documento, evento) VALUES (p_documento, 'Intento de inicio de sesión fallido');
        ELSE
            -- Obtener el cargo del empleado
            SELECT cargo INTO v_cargo
            FROM Empleado
            WHERE documento = p_documento;

            IF v_cargo = 2 THEN  -- Cargo de Administrador
                SELECT 'Inicio de sesión exitoso' AS mensaje;
                INSERT INTO RegistroSesiones (documento, evento) VALUES (p_documento, 'Inicio de sesión');
            ELSE
                SELECT 'Cargo no autorizado: Error al iniciar sesión' AS mensaje;
                INSERT INTO RegistroSesiones (documento, evento) VALUES (p_documento, 'Intento de inicio de sesión no autorizado');
            END IF;
        END IF;
    END IF;
END //
DELIMITER ;

-- Proceso de Cierre de sesion
DELIMITER //
CREATE PROCEDURE CerrarSesion(
    IN p_documento VARCHAR(20)
)
BEGIN
    INSERT INTO RegistroSesiones (documento, evento) VALUES (p_documento, 'Cierre de sesión');
    SELECT 'Cierre de sesión exitoso' AS mensaje;
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
/*call ReporteEntradaSalida('2024-04-26','2024-05-27',null);*/
-- llamar al proceso para un empleado
/*call ReporteEntradaSalida('2024-04-26','2024-04-27','');*/


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
               CASE WHEN res.horaEntrada > '08:05:00' THEN 'Tarde' ELSE 'A tiempo' END AS Llegada
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin
        AND e.documento = documentoEmpleado;
    ELSE
        -- Reporte de todos los empleados que ingresaron tarde
        SELECT e.documento 'Documento', e.nombres 'Nombre', e.apellidos 'Apellido', res.fecha 'Fecha', res.horaEntrada 'Hora Entrada',
               CASE WHEN res.horaEntrada > '08:05:00' THEN 'Tarde' ELSE 'A tiempo' END AS Llegada
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin;
    END IF;
END //
DELIMITER ;

/*CALL ReporteIngresosTarde('2024-04-26', '2024-05-23', null);*/

/*3. Reporte de horas extras*/
DELIMITER //
CREATE PROCEDURE ReporteHorasExtras(
    IN fechaInicio DATE,
    IN fechaFin DATE,
    IN documentoEmpleado VARCHAR(20)
)
BEGIN
    -- Reporte de horas extras para un empleado específico
    IF documentoEmpleado IS NOT NULL THEN
        SELECT e.documento 'Documento', 
               res.fecha 'Fecha', 
               res.horaSalida 'Hora de salida', 
               TIMEDIFF(res.horaSalida, '18:00:00') AS 'Horas Extras'
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin
        AND res.horaSalida > '18:00:00'
        AND e.documento = documentoEmpleado;
    ELSE
        -- Reporte de horas extras para todos los empleados
         SELECT e.documento 'Documento', 
               res.fecha 'Fecha', 
               res.horaSalida 'Hora de salida', 
               TIMEDIFF(res.horaSalida, '18:00:00') AS 'Horas Extras'
        FROM Empleado e
        INNER JOIN RegistroEntradaSalida res ON e.id = res.id_empleado
        WHERE res.fecha BETWEEN fechaInicio AND fechaFin
        AND res.horaSalida > '18:00:00';
    END IF;
END //
DELIMITER ;
/*CALL ReporteHorasExtras('2024-04-26', '2024-05-26',null);*/

/*4. Reporte de permisos*/
DELIMITER //
CREATE PROCEDURE ReportePermisos(
    IN mes INT,
    IN docEmpleado VARCHAR(255) -- Cambia el tamaño según la longitud máxima del documento
)
BEGIN
    DECLARE idEmp INT;

    -- Obtener el ID del empleado a partir del documento
    SELECT id INTO idEmp
    FROM Empleado
    WHERE documento = docEmpleado;

    IF idEmp IS NULL THEN
        -- El documento no corresponde a ningún empleado
        SELECT 'Documento no válido' AS mensaje;
    ELSE
        -- Reporte para el empleado con el documento especificado
        SELECT e.nombres, e.apellidos, e.documento, p.motivo, p.fecha, 
               CASE p.remunerado
                   WHEN 1 THEN 'remunerado'
                   ELSE 'no remunerado'
               END AS remunerado
        FROM Permiso p
        INNER JOIN Empleado e ON p.id_empleado = e.id
        WHERE MONTH(p.fecha) = mes
        AND p.id_empleado = idEmp
        ORDER BY e.nombres, e.apellidos, e.documento, p.fecha;
    END IF;
END //
DELIMITER ;
/*CALL ReportePermisos(5, '0987654321');
CALL ReportePermisos(5, null);*/
-- ejemplos insercion empleados

-- RegistrarEmpleado

/*
CALL RegistrarEmpleado('Juan', 'Perez', '1234567890', '1', '10055444', 'Calle 123', 'juan@example.com', '1', '1990-01-01', '2024-04-26', '2', '50000','1234567890');
CALL RegistrarEmpleado('Maria', 'Lopez', '0987654321', '1', '0987654321', 'Avenida 456', 'maria@example.com', '2', '1995-05-15', '2024-04-26', '1', '40000','0987654321');
CALL RegistrarEmpleado('Pedro', 'Gonzalez', '4567890123', '1', '4567890123', 'Calle Principal', 'pedro@example.com', '1', '1985-08-20', '2024-04-26', '2', '45000','4567890123');
CALL RegistrarEmpleado('Ana', 'Martinez', '9876543210', '1', '9876543210', 'Avenida Central', 'ana@example.com', '2', '1992-11-30', '2024-04-26', '2', '55000','9876543210');
CALL RegistrarEmpleado('Carlos', 'Rodriguez', '1357924680', '1', '1357924680', 'Calle Secundaria', 'carlos@example.com', '1', '1988-04-10', '2024-04-26', '1', '60000','1357924680');
CALL RegistrarEmpleado('Luisa', 'Sanchez', '2468013579', '1', '2468013579', 'Calle 789', 'luisa@example.com', '2', '1998-07-25', '2024-04-26', '1', '48000','2468013579');
CALL RegistrarEmpleado('Juan', 'Alvarez', '1004353392', '1', '2468013579', 'Calle 789', 'luisa@example.com', '2', '1998-07-25', '2024-04-26', '2', '48000','1004353392');
*/

-- ejemplos de entrada emoleado
/*
CALL RegistrarEntradaEmpleado('1234567890','2024-04-26','8:10', @p_mensaje);
CALL RegistrarEntradaEmpleado('0987654321','2024-04-26','8:05', @p_mensaje);
CALL RegistrarEntradaEmpleado('4567890123','2024-04-28','8:35', @p_mensaje);
CALL RegistrarEntradaEmpleado('9876543210','2024-04-27','8:15', @p_mensaje);
CALL RegistrarEntradaEmpleado('1357924680','2024-04-27','8:00', @p_mensaje);
CALL RegistrarEntradaEmpleado('2468013579','2024-04-26','8:00', @p_mensaje);
*/

-- Ejempplo de datos salida empeleado
/*
CALL RegistrarSalidaEmpleado('1234567890','2024-04-26','21:10', @p_mensaje);
CALL RegistrarSalidaEmpleado('0987654321','2024-04-26','20:30', @p_mensaje);
CALL RegistrarSalidaEmpleado('4567890123','2024-04-28','12:35', @p_mensaje);
CALL RegistrarSalidaEmpleado('9876543210','2024-04-27','17:15', @p_mensaje);
CALL RegistrarSalidaEmpleado('1357924680','2024-04-27','14:20', @p_mensaje);
CALL RegistrarSalidaEmpleado('2468013579','2024-04-26','16:30', @p_mensaje);
*/