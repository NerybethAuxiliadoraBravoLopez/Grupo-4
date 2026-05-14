
CREATE DATABASE SistemaRegistroHabitos;
USE SistemaRegistroHabitos;

-- Tabla Grado
CREATE TABLE Grado (
    id_grado INT PRIMARY KEY AUTO_INCREMENT,
    nombre_grado VARCHAR(100),
    nivel VARCHAR(50)
);

-- Tabla Usuario
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    contrasena VARCHAR(255),
    tipo_usuario VARCHAR(50),
    estado BOOLEAN
);

--  Tabla Habito 
CREATE TABLE Habito (
    id_habito INT PRIMARY KEY AUTO_INCREMENT,
    nombre_habito VARCHAR(100),
    tipo_habito VARCHAR(50),
    unidad_medida VARCHAR(50),
    estado VARCHAR(20)
);

--  Tabla Seccion 
CREATE TABLE Seccion (
    id_seccion INT PRIMARY KEY AUTO_INCREMENT,
    nombre_seccion VARCHAR(50),
    id_grado INT,
    FOREIGN KEY (id_grado) REFERENCES Grado(id_grado)
);

-- 6. Tabla Estudiante (depende de Grado)
CREATE TABLE Estudiante (
    id_estudiante INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150),
    fecha_nacimiento DATE,
    id_grado INT,
    FOREIGN KEY (id_grado) REFERENCES Grado(id_grado)
);

-- Tabla Registro
CREATE TABLE Registro (
    id_registro INT PRIMARY KEY AUTO_INCREMENT,
    id_estudiante INT,
    id_habito INT,
    fecha_registro DATE,
    valor FLOAT,
    observacion TEXT,
    id_usuario INT,
    fecha_creacion DATE,
    FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
    FOREIGN KEY (id_habito) REFERENCES Habito(id_habito),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);


INSERT INTO Grado (nombre_grado, nivel) VALUES
('Séptimo Grado', 'Secundaria'),
('Octavo Grado', 'Secundaria'),
('Noveno Grado', 'Secundaria'),
('Décimo Grado', 'Secundaria'),
('Undécimo Grado', 'Secundaria'),
('Séptimo Grado B', 'Secundaria'),
('Octavo Grado B', 'Secundaria'),
('Noveno Grado B', 'Secundaria'),
('Décimo Grado B', 'Secundaria'),
('Undécimo Grado B', 'Secundaria');

INSERT INTO Usuario (nombre, apellido, email, contrasena, tipo_usuario, estado) VALUES
('Ana', 'Martinez', 'ana.mtz@colegio.com', 'pass123', 'Administrador', 1),
('Carlos', 'Gomez', 'carlos.g@colegio.com', 'secure456', 'Docente Ciencias', 1),
('Lucia', 'Lopez', 'lucia.l@colegio.com', 'admin789', 'Administrador', 1),
('Jorge', 'Rodriguez', 'jorge.r@colegio.com', 'clavedocente', 'Docente Matemáticas', 1),
('Elena', 'Perez', 'elena.p@colegio.com', 'perez2026', 'Docente Literatura', 1),
('David', 'Sánchez', 'david.s@colegio.com', 'david99', 'Consejero Escolar', 1),
('Sofia', 'Diaz', 'sofia.d@colegio.com', 'sofia123', 'Supervisor', 1),
('Miguel', 'Torres', 'miguel.t@colegio.com', 'torres456', 'Docente Inglés', 1),
('Laura', 'Castro', 'laura.c@colegio.com', 'laura789', 'Administrador', 1),
('Pedro', 'Morales', 'pedro.m@colegio.com', 'pedro2026', 'Docente Historia', 1);

-- 3. DATOS REALES: HABITO (Situaciones de Secundaria)
INSERT INTO Habito (nombre_habito, tipo_habito, unidad_medida, estado) VALUES
('Entrega de Ensayos', 'Académico', 'Porcentaje', 'Activo'),
('Puntualidad en Bloque 1', 'Conducta', 'Minutos tarde', 'Activo'),
('Participación en Debates', 'Académico', 'Interacciones', 'Activo'),
('Uso Correcto de Celular', 'Disciplina', 'Llamadas de atención', 'Activo'),
('Trabajo de Laboratorio', 'Académico', 'Calificación', 'Activo'),
('Asistencia a Tutorías', 'Apoyo', 'Horas asistidas', 'Activo'),
('Respeto en Comunidad', 'Convivencia', 'Incidentes', 'Activo'),
('Cuidado del Mobiliario', 'Disciplina', 'Reportes de daño', 'Activo'),
('Liderazgo en Proyectos', 'Social', 'Puntos acumulados', 'Activo'),
('Uso de Uniforme Completo', 'Disciplina', 'Cumplimiento', 'Activo');

INSERT INTO Seccion (nombre_seccion, id_grado) VALUES
('Única', 1),
('Sección A', 2),
('Sección B', 2),
('Única', 3),
('Sección A', 4),
('Sección B', 4),
('Matutina', 5),
('Vespertina', 5),
('Sección A', 6),
('Única', 7);

-- 5. DATOS REALES: ESTUDIANTE (Edades de 12 a 17 años)
INSERT INTO Estudiante (nombre, apellido, email, fecha_nacimiento, id_grado) VALUES
('Juan', 'Alvarez', 'juan.alvarez@secundaria.com', '2014-04-12', 1),
('Maria', 'Benitez', 'maria.benitez@secundaria.com', '2013-08-22', 2),
('Luis', 'Cabrera', 'luis.cabrera@secundaria.com', '2012-01-15', 3),
('Andres', 'Delgado', 'andres.delgado@secundaria.com', '2011-11-05', 4),
('Rosa', 'Espinoza', 'rosa.espinoza@secundaria.com', '2010-06-30', 5),
('Kevin', 'Flores', 'kevin.flores@secundaria.com', '2013-02-14', 6),
('Camila', 'Gutierrez', 'camila.gutierrez@secundaria.com', '2012-09-18', 7),
('Diego', 'Herrera', 'diego.herrera@secundaria.com', '2011-05-25', 8),
('Natalia', 'Ibarra', 'natalia.ibarra@secundaria.com', '2010-12-01', 9),
('Gabriel', 'Juarez', 'gabriel.juarez@secundaria.com', '2009-07-07', 10);

INSERT INTO Registro (id_estudiante, id_habito, fecha_registro, valor, observacion, id_usuario, fecha_creacion) VALUES
(1, 1, '2026-05-01', 0.0, 'Ausente', 2, '2026-05-01'),
(2, 4, '2026-05-01', 0.0, 'No cumplió en nada', 6, '2026-05-01'),
(3, 2, '2026-05-02', 15.0, 'Bajo rendimiento', 4, '2026-05-02'),
(4, 3, '2026-05-02', 0.0, 'Ausente', 4, '2026-05-02'),
(5, 5, '2026-05-03', 0.0, 'No cumplió en nada', 2, '2026-05-03'),
(6, 1, '2026-05-03', 4.0, 'Bajo rendimiento', 5, '2026-05-03'),
(7, 10, '2026-05-04', 0.0, 'Ausente', 6, '2026-05-04'),
(8, 7, '2026-05-04', 3.0, 'No cumplió en nada', 10, '2026-05-04'),
(9, 2, '2026-05-05', 25.0, 'Bajo rendimiento', 4, '2026-05-05'),
(10, 4, '2026-05-05', 0.0, 'Ausente', 6, '2026-05-05');

INSERT INTO Reportes (nombre_reporte, tipo_reporte, fecha_generacion, ruta_archivo, id_usuario, parametros) VALUES
('Reporte de Alertas Séptimo A', 'PDF', '2026-05-10', '/outputs/pdf/alertas_7a.pdf', 6, 'grado=1'),
('Uso Indebido de Celulares Octavo', 'Excel', '2026-05-11', '/outputs/excel/celulares_8.xlsx', 9, 'habito=4'),
('Gráfico de Rendimiento Undécimo', 'Grafico', '2026-05-11', '/outputs/img/promo_2026.png', 1, 'mes=mayo'),
('Reporte Psicoeducativo Juan Alvarez', 'PDF', '2026-05-12', '/outputs/pdf/rep_juan.pdf', 6, 'estudiante=1'),
('Consolidado de Tareas Noveno', 'Excel', '2026-05-12', '/outputs/excel/tareas_9.xlsx', 4, 'grado=3'),
('Gráfico Asistencia Décimo A', 'Grafico', '2026-05-13', '/outputs/img/asistencia_10.png', 2, 'grado=4'),
('Bitácora de Disciplina General', 'PDF', '2026-05-13', '/outputs/pdf/disciplina.pdf', 9, 'tipo=alerta'),
('Alumnos en Tutorías de Matemáticas', 'Excel', '2026-05-13', '/outputs/excel/tutorias.xlsx', 4, 'materia=mate'),
('Reporte Individual Rosa Espinoza', 'PDF', '2026-05-13', '/outputs/pdf/rep_rosa.pdf', 5, 'estudiante=5'),
('Estadísticas de Convivencia Escolar', 'Grafico', '2026-05-13', '/outputs/img/convivencia.png', 6, 'periodo=parcial1');

