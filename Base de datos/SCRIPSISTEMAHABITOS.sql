

-- -----------------------------------------------------
-- Schema sistemahabitos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemahabitos` DEFAULT CHARACTER SET utf8mb4 ;
USE `sistemahabitos` ;

-- -----------------------------------------------------
-- Table `sistemahabitos`.`grado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`grado` (
  `id_grado` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_grado` VARCHAR(100) NULL DEFAULT NULL,
  `nivel` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_grado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sistemahabitos`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`estudiante` (
  `id_estudiante` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `apellido` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(150) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `id_grado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_estudiante`),
  INDEX `id_grado` (`id_grado` ASC) VISIBLE,
  CONSTRAINT `estudiante_ibfk_1`
    FOREIGN KEY (`id_grado`)
    REFERENCES `sistemahabitos`.`grado` (`id_grado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sistemahabitos`.`habito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`habito` (
  `id_habito` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_habito` VARCHAR(100) NULL DEFAULT NULL,
  `tipo_habito` VARCHAR(50) NULL DEFAULT NULL,
  `unidad_medida` VARCHAR(50) NULL DEFAULT NULL,
  `estado` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_habito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sistemahabitos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `apellido` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(150) NULL DEFAULT NULL,
  `contrasena` VARCHAR(255) NULL DEFAULT NULL,
  `tipo_usuario` VARCHAR(50) NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sistemahabitos`.`registro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`registro` (
  `id_registro` INT(11) NOT NULL AUTO_INCREMENT,
  `id_estudiante` INT(11) NULL DEFAULT NULL,
  `id_habito` INT(11) NULL DEFAULT NULL,
  `fecha_registro` DATE NULL DEFAULT NULL,
  `valor` FLOAT NULL DEFAULT NULL,
  `observacion` TEXT NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `fecha_creacion` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_registro`),
  INDEX `id_estudiante` (`id_estudiante` ASC) VISIBLE,
  INDEX `id_habito` (`id_habito` ASC) VISIBLE,
  INDEX `id_usuario` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `registro_ibfk_1`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `sistemahabitos`.`estudiante` (`id_estudiante`),
  CONSTRAINT `registro_ibfk_2`
    FOREIGN KEY (`id_habito`)
    REFERENCES `sistemahabitos`.`habito` (`id_habito`),
  CONSTRAINT `registro_ibfk_3`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `sistemahabitos`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sistemahabitos`.`seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemahabitos`.`seccion` (
  `id_seccion` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_seccion` VARCHAR(50) NULL DEFAULT NULL,
  `id_grado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_seccion`),
  INDEX `id_grado` (`id_grado` ASC) VISIBLE,
  CONSTRAINT `seccion_ibfk_1`
    FOREIGN KEY (`id_grado`)
    REFERENCES `sistemahabitos`.`grado` (`id_grado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Tabla Reportes 
CREATE TABLE Reportes (
    id_reporte INT PRIMARY KEY AUTO_INCREMENT,
    nombre_reporte VARCHAR(150),
    tipo_reporte VARCHAR(50),      
    fecha_generacion DATE,
    ruta_archivo VARCHAR(255),    
    id_usuario INT,               
    parametros TEXT,              
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);


-- GRADO
INSERT INTO Grado (nombre_grado, nivel) VALUES
('Primer Grado', 'Primaria'),
('Segundo Grado', 'Primaria'),
('Tercer Grado', 'Primaria'),
('Cuarto Grado', 'Primaria'),
('Quinto Grado', 'Primaria'),
('Sexto Grado', 'Primaria'),
('Septimo Grado', 'Secundaria'),
('Octavo Grado', 'Secundaria'),
('Noveno Grado', 'Secundaria'),
('Decimo Grado', 'Secundaria');

-- USUARIO
INSERT INTO Usuario (nombre, apellido, email, contrasena, tipo_usuario, estado) VALUES
('Ana', 'Martinez', 'ana.mtz@correo.com', 'pass123', 'Administrador', 1),
('Carlos', 'Gomez', 'carlos.g@correo.com', 'secure456', 'Docente', 1),
('Lucia', 'Lopez', 'lucia.l@correo.com', 'admin789', 'Administrador', 1),
('Jorge', 'Rodriguez', 'jorge.r@correo.com', 'clavedocente', 'Docente', 1),
('Elena', 'Perez', 'elena.p@correo.com', 'perez2026', 'Docente', 1),
('David', 'Sánchez', 'david.s@correo.com', 'david99', 'Docente', 0),
('Sofia', 'Diaz', 'sofia.d@correo.com', 'sofia123', 'Docente', 1),
('Miguel', 'Torres', 'miguel.t@correo.com', 'torres456', 'Administrador', 1),
('Laura', 'Castro', 'laura.c@correo.com', 'laura789', 'Administrador', 1),
('Pedro', 'Morales', 'pedro.m@correo.com', 'pedro2026', 'Docente', 1);

-- HABITO
INSERT INTO Habito (nombre_habito, tipo_habito, unidad_medida, estado) VALUES
('Lectura Diaria', 'Academico', 'Paginas', 'Activo'),
('Asistencia', 'Conducta', 'Dias', 'Activo'),
('Puntualidad', 'Conducta', 'Minutos tarde', 'Activo'),
('Entrega de Tareas', 'Academico', 'Porcentaje', 'Activo'),
('Descanso', 'Salud', 'Interacciones', 'Activo'),
('Uso de Uniforme', 'Disciplina', 'Cumplimiento', 'Activo'),
('Respeto a Compañeros', 'Convivencia', 'Incidentes', 'Activo'),
('Higiene Personal', 'Salud', 'Cumplimiento', 'Activo'),
('Trabajo en Equipo', 'Social', 'Calificacion', 'Activo'),
('Orden del Aula', 'Disciplina', 'Cumplimiento', 'Inactivo');

-- SECCION
INSERT INTO Seccion (nombre_seccion, id_grado) VALUES
('Seccion A', 1),
('Seccion B', 1),
('Seccion A', 2),
('Seccion A', 3),
('Seccion B', 3),
('Seccion A', 4),
('Seccion A', 5),
('Seccion A', 6),
('Seccion A', 7),
('Seccion A', 10);

-- ESTUDIANTE
INSERT INTO Estudiante (nombre, apellido, email, fecha_nacimiento, id_grado) VALUES
('Juan', 'Alvarez', 'juan.alvarez@estudiante.com', '2015-04-12', 1),
('Maria', 'Benitez', 'maria.benitez@estudiante.com', '2015-08-22', 1),
('Luis', 'Cabrera', 'luis.cabrera@estudiante.com', '2014-01-15', 2),
('Andres', 'Delgado', 'andres.delgado@estudiante.com', '2013-11-05', 3),
('Rosa', 'Espinoza', 'rosa.espinoza@estudiante.com', '2012-06-30', 4),
('Kevin', 'Flores', 'kevin.flores@estudiante.com', '2011-02-14', 5),
('Camila', 'Gutierrez', 'camila.gutierrez@estudiante.com', '2010-09-18', 6),
('Diego', 'Herrera', 'diego.herrera@estudiante.com', '2009-05-25', 7),
('Natalia', 'Ibarra', 'natalia.ibarra@estudiante.com', '2008-12-01', 8),
('Gabriel', 'Juarez', 'gabriel.juarez@estudiante.com', '2006-07-07', 10);

-- REGISTRO
INSERT INTO Registro (id_estudiante, id_habito, fecha_registro, valor, observacion, id_usuario, fecha_creacion) VALUES
(1, 1, '2026-05-01', 0.0, 'Ausente', 2, '2026-05-01'),
(2, 1, '2026-05-01', 0.0, 'No cumplió en nada', 2, '2026-05-01'),
(3, 2, '2026-05-02', 3.0, 'Bajo rendimiento', 4, '2026-05-02'),
(4, 3, '2026-05-02', 0.0, 'Ausente', 4, '2026-05-02'),
(5, 4, '2026-05-03', 0.0, 'No cumplió en nada', 5, '2026-05-03'),
(6, 5, '2026-05-03', 2.0, 'Bajo rendimiento', 5, '2026-05-03'),
(7, 6, '2026-05-04', 0.0, 'Ausente', 10, '2026-05-04'),
(8, 7, '2026-05-04', 0.0, 'No cumplió en nada', 10, '2026-05-04'),
(9, 8, '2026-05-05', 1.5, 'Bajo rendimiento', 7, '2026-05-05'),
(10, 9, '2026-05-05', 0.0, 'Ausente', 7, '2026-05-05');

-- REPORTES
INSERT INTO Reportes (nombre_reporte, tipo_reporte, fecha_generacion, ruta_archivo, id_usuario, parametros) VALUES
('Rendimiento Academico Mayo', 'PDF', '2026-05-10', '/outputs/pdf/rep_mayo.pdf', 1, 'grado=1&seccion=A'),
('Alumnos con Inasistencias', 'Excel', '2026-05-11', '/outputs/excel/inasistencias.xlsx', 3, 'rango=semanal'),
('Grafico Cumplimiento Uniforme', 'Grafico', '2026-05-11', '/outputs/img/chart_uniforme.png', 1, 'mes=mayo'),
('Reporte Individual Juan Alvarez', 'PDF', '2026-05-12', '/outputs/pdf/rep_juan.pdf', 2, 'estudiante=1'),
('Consolidado de Conducta', 'Excel', '2026-05-12', '/outputs/excel/conducta.xlsx', 4, 'grado=all'),
('Grafico Lectura Primer Grado', 'Grafico', '2026-05-13', '/outputs/img/chart_lectura.png', 2, 'grado=1'),
('Lista de Usuarios Activos', 'PDF', '2026-05-13', '/outputs/pdf/usuarios.pdf', 9, 'estado=activo'),
('Bitacora de Incidentes', 'Excel', '2026-05-13', '/outputs/excel/incidentes.xlsx', 9, 'mes=mayo'),
('Reporte Individual Maria Benitez', 'PDF', '2026-05-13', '/outputs/pdf/rep_maria.pdf', 5, 'estudiante=2'),
('Estadisticas Trabajo en Equipo', 'Grafico', '2026-05-13', '/outputs/img/teamwork.png', 7, 'periodo=primer-parcial');

SELECT * FROM Grado;
SELECT * FROM Usuario;
SELECT * FROM Habito;
SELECT * FROM Seccion;
SELECT * FROM Estudiante;
SELECT * FROM Registro;
SELECT * FROM Reportes;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
