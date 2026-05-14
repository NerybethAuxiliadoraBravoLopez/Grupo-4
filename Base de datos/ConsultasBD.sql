USE SistemaRegistroHabitos;

SELECT 
    e.nombre AS Estudiante, 
    e.apellido AS Apellido, 
    g.nombre_grado AS Grado,
    h.nombre_habito AS Indicador, 
    r.observacion AS Estado
FROM Registro r
INNER JOIN Estudiante e ON r.id_estudiante = e.id_estudiante
INNER JOIN Grado g ON e.id_grado = g.id_grado
INNER JOIN Habito h ON r.id_habito = h.id_habito
WHERE r.observacion IN ('Ausente', 'No cumplió en nada', 'Bajo rendimiento');


UPDATE Registro 
SET valor = 4.5, observacion = 'Mejoró rendimiento'
WHERE id_estudiante = 3 AND id_habito = 2;

SELECT * FROM Registro;



DELETE FROM Reportes 
WHERE id_reporte = 10;

SELECT * FROM Reportes;

