USE db_geos;

DROP TABLE IF EXISTS DASHBOARD;
DROP TABLE IF EXISTS AGENDA_BATERIA;
DROP TABLE IF EXISTS AGENDA;
DROP TABLE IF EXISTS AFILIACION;
DROP TABLE IF EXISTS ACTIVIDADECONOMICA;
DROP TABLE IF EXISTS SOLICITUD_TRABAJADOR_EXAMEN;
DROP TABLE IF EXISTS COMENTARIOS_SOLICITUD;
DROP TABLE IF EXISTS SOL_EMP_TRA;
DROP TABLE IF EXISTS EXAMENES;
DROP TABLE IF EXISTS BATERIA;
DROP TABLE IF EXISTS ESTADOS_SOLICITUD;
DROP TABLE IF EXISTS SOLICITUD;
DROP TABLE IF EXISTS TRABAJADOR;
DROP TABLE IF EXISTS ARCHIVOS;
DROP TABLE IF EXISTS EMPLEADOR;
DROP TABLE IF EXISTS PRESTADOR;
DROP TABLE IF EXISTS USUARIOS;


-- Usuarios
CREATE TABLE USUARIOS (
    IDUSUARIO INT PRIMARY KEY AUTO_INCREMENT,
    RUT VARCHAR(255) UNIQUE NOT NULL,
    NOMBRES VARCHAR(255) NOT NULL,
    APELLIDOS VARCHAR(255) NOT NULL,
    REGION VARCHAR(255) NOT NULL,
    COMUNA VARCHAR(255) NOT NULL,
    TIPO VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    FONO VARCHAR(255) NOT NULL,
    CLAVE VARCHAR(255) NOT NULL,
    VIGENTE BOOLEAN NOT NULL
);

-- Prestador
CREATE TABLE PRESTADOR (
    IDPRESTADOR INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(255) NOT NULL,
    DIRECCION VARCHAR(255) NOT NULL,
    FONO VARCHAR(255) NOT NULL,
    CONTACTO VARCHAR(255) NOT NULL,
    CORREO VARCHAR(255) NOT NULL,
    REGION VARCHAR(255) NOT NULL,
    COMUNA VARCHAR(255) NOT NULL,
    FECHAINICIO DATE NOT NULL,
    FECHAFIN DATE NOT NULL,
    VIGENTE BOOLEAN NOT NULL
);

-- Empleador
CREATE TABLE EMPLEADOR (
    IDEMPLEADOR INT PRIMARY KEY AUTO_INCREMENT,
    RUT VARCHAR(255) UNIQUE NOT NULL,
    RAZONSOCIAL VARCHAR(255) NOT NULL,
    CONTACTO VARCHAR(255) NOT NULL,
    FONO VARCHAR(255) NOT NULL,
    CORREO VARCHAR(255) NOT NULL,
    TIPO VARCHAR(255) NOT NULL,
    DIRECCION VARCHAR(255) NOT NULL,
    REGION VARCHAR(255) NOT NULL,
    COMUNA VARCHAR(255) NOT NULL,
    CODIGOAE VARCHAR(255) NOT NULL,
    VIGENTE BOOLEAN NOT NULL
);


-- Archivos
CREATE TABLE ARCHIVOS (
    ID_ARCHIVO INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(255) NOT NULL,
    TIPO_ARCHIVO VARCHAR(255) NOT NULL
);

-- Trabajador
CREATE TABLE TRABAJADOR (
    IDTRABAJADOR INT PRIMARY KEY AUTO_INCREMENT,
    RUT VARCHAR(255) UNIQUE NOT NULL,
    NOMBRES VARCHAR(255) NOT NULL,
    APELLIDOS VARCHAR(255) NOT NULL,
    VIGENTE BOOLEAN NOT NULL,
    IDEMPLEADOR INT,
    ID_ARCHIVO INT,
    FOREIGN KEY (IDEMPLEADOR) REFERENCES EMPLEADOR(IDEMPLEADOR),
    FOREIGN KEY (ID_ARCHIVO) REFERENCES ARCHIVOS(ID_ARCHIVO)
);

-- Estados_Solicitud
CREATE TABLE ESTADOS_SOLICITUD (
    ID_ESTADO INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE_ESTADO VARCHAR(255) NOT NULL,
    ESTADO VARCHAR(255) NOT NULL
);


-- Solicitud
CREATE TABLE SOLICITUD (
    IDSOLICITUD INT PRIMARY KEY AUTO_INCREMENT,
    FECHASOLICITUD DATE NOT NULL,
    IDUSUARIO INT,
    IDEMPLEADOR INT,
    NOMBRE VARCHAR(255) NOT NULL,
    RAZON VARCHAR(255) NOT NULL,
    ESTADO VARCHAR(255) NOT NULL,
    IDPRESTADOR INT,
    DIRECCION_PRESTADOR VARCHAR(255),
    ID_ESTADO INT,
    ID_ARCHIVO INT,
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIOS(IDUSUARIO),
    FOREIGN KEY (IDEMPLEADOR) REFERENCES EMPLEADOR(IDEMPLEADOR),
    FOREIGN KEY (IDPRESTADOR) REFERENCES PRESTADOR(IDPRESTADOR),
    FOREIGN KEY (ID_ESTADO) REFERENCES ESTADOS_SOLICITUD(ID_ESTADO),
    FOREIGN KEY (ID_ARCHIVO) REFERENCES ARCHIVOS(ID_ARCHIVO)
);

-- Bateria
CREATE TABLE BATERIA (
    IDBATTERIA INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(255) NOT NULL,
    RECOMENDACION VARCHAR(255) NOT NULL,
    JORNADA VARCHAR(255) NOT NULL,
    VIGENTE BOOLEAN NOT NULL,
    IDPRESTADOR INT,
    FOREIGN KEY (IDPRESTADOR) REFERENCES PRESTADOR(IDPRESTADOR)
);


-- Examenes
CREATE TABLE EXAMENES (
    IDEXAMEN INT PRIMARY KEY AUTO_INCREMENT,
    IDBATTERIA INT,
    NOMBRE VARCHAR(255) NOT NULL,
    EVALUACION VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDBATTERIA) REFERENCES BATERIA(IDBATTERIA)
);


-- Sol_Emp_Tra
CREATE TABLE SOL_EMP_TRA (
    IDSOLEMPTRA INT PRIMARY KEY AUTO_INCREMENT,
    IDSOLICITUD INT,
    IDEMPLEADOR INT,
    IDTRABAJADOR INT,
    FOREIGN KEY (IDSOLICITUD) REFERENCES SOLICITUD(IDSOLICITUD),
    FOREIGN KEY (IDEMPLEADOR) REFERENCES EMPLEADOR(IDEMPLEADOR),
    FOREIGN KEY (IDTRABAJADOR) REFERENCES TRABAJADOR(IDTRABAJADOR)
);

-- Comentarios_Solicitud
CREATE TABLE COMENTARIOS_SOLICITUD (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FECHACOMENTARIO DATE NOT NULL,
    TEXTO TEXT NOT NULL,
    IDSOLICITUD INT,
    FOREIGN KEY (IDSOLICITUD) REFERENCES SOLICITUD(IDSOLICITUD)
);

-- Solicitud_Trabajador_Examen
CREATE TABLE SOLICITUD_TRABAJADOR_EXAMEN (
    IDAGENDA INT PRIMARY KEY AUTO_INCREMENT,
    IDSOLICITUD INT,
    IDTRABAJADOR INT,
    FOREIGN KEY (IDSOLICITUD) REFERENCES SOLICITUD(IDSOLICITUD),
    FOREIGN KEY (IDTRABAJADOR) REFERENCES TRABAJADOR(IDTRABAJADOR)
);

-- Actividad_Economica
CREATE TABLE ACTIVIDADECONOMICA (
    CODIGOAE VARCHAR(255) PRIMARY KEY,
    DESCRIPCION VARCHAR(255) NOT NULL,
    ESTADO VARCHAR(255) NOT NULL
);

-- Afiliacion
CREATE TABLE AFILIACION (
    IDAFILIACION INT PRIMARY KEY AUTO_INCREMENT,
    FECHACONSULTA DATE NOT NULL,
    AFILIADO BOOLEAN NOT NULL,
    IDEMPLEADOR INT,
    FOREIGN KEY (IDEMPLEADOR) REFERENCES EMPLEADOR(IDEMPLEADOR)
);

-- Agenda
CREATE TABLE AGENDA (
    IDAGENDA INT PRIMARY KEY AUTO_INCREMENT,
    FECHAEXAMEN DATE NOT NULL,
    COMENTARIO TEXT NOT NULL,
    HORAEXAMEN TIME NOT NULL,
    IDSOLICITUD INT,
    FOREIGN KEY (IDSOLICITUD) REFERENCES SOLICITUD(IDSOLICITUD)
);

-- Agenda_Bateria
CREATE TABLE AGENDA_BATERIA (
    IDAGENDA INT,
    IDBATTERIA INT,
    PRIMARY KEY (IDAGENDA, IDBATTERIA),
    FOREIGN KEY (IDAGENDA) REFERENCES AGENDA(IDAGENDA),
    FOREIGN KEY (IDBATTERIA) REFERENCES BATERIA(IDBATTERIA)
);

-- Dashboard
CREATE TABLE DASHBOARD (
    IDDASHBOARD INT PRIMARY KEY AUTO_INCREMENT,
    TOTALBORRADOR INT NOT NULL,
    TOTALAPROBADA INT NOT NULL,
    TOTALRECHAZADA INT NOT NULL,
    TOTALPENDIENTE INT NOT NULL,
    TOTALAGENDADA INT NOT NULL,
    TOTALINICIADA INT NOT NULL,
    TOTALFINALIZADA INT NOT NULL,
    REGION VARCHAR(255) NOT NULL,
    COMUNA VARCHAR(255) NOT NULL,
    IDSOLICITUD INT,
    FOREIGN KEY (IDSOLICITUD) REFERENCES SOLICITUD(IDSOLICITUD)
);



-- PRESTADOR
INSERT INTO PRESTADOR (NOMBRE, DIRECCION, FONO, CONTACTO, CORREO, REGION, COMUNA, FECHAINICIO, FECHAFIN, VIGENTE) VALUES
('HOSPITAL CARLOS VAN BUREN', 'SAN IGNACIO N° 725', '226453766', 'PABLO NERUDA ', 'PNERUDA@VBUREN.CL', 'VALPARAISO', 'VALPARAISO', '2022-01-01', '2023-01-01', TRUE);

INSERT INTO PRESTADOR (NOMBRE, DIRECCION, FONO, CONTACTO, CORREO, REGION, COMUNA, FECHAINICIO, FECHAFIN, VIGENTE) VALUES
('HOSPITAL DE PICHILEMU', 'CALLE ERRAZURIZ  N° 151', '722336600', 'ISABEL PARRA', 'IPARRA@HOSPITALPICHILEMU.CL','LIBERTADOR GENERAL BERNARDO O'HIGGINS','PICHILEMU', '2022-01-01', '2023-01-01', TRUE);

INSERT INTO PRESTADOR (NOMBRE, DIRECCION, FONO, CONTACTO, CORREO, REGION, COMUNA, FECHAINICIO, FECHAFIN, VIGENTE) VALUES
('HOSPITAL DEL CARMEN', 'AVENIDA RINCONADA N° 365', '2298574653', 'JUAN GOMEZ', 'JGOMEZ@CARMEN.CL', 'METROPOLITANA', 'MAIPU', '2022-01-01', '2024-01-01', TRUE);

INSERT INTO PRESTADOR (NOMBRE, DIRECCION, FONO, CONTACTO, CORREO, REGION, COMUNA, FECHAINICIO, FECHAFIN, VIGENTE) VALUES
('CLINICA CHP', 'ALAMEDA N° 3766', '2247345444', 'MARIA FERNANDEZ', 'MMARIA@CHP.CL', 'METROPOLITANA', 'ESTACION CENTRAL', '2022-01-01', '2024-01-01', TRUE);

-- EMPLEADOR 
INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('76645030-K', 'TRANSPORTES CHILEMAT SPA.', 'ERNESTO FAUNDEZ', '932432561', 'EFAUNDEZ@CHILEMAT.CL', 'TE', 'VALPARAISO N°4324', 'VALPARAISO', 'VALPARAISO', '71121', TRUE);

INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('76055292-5', 'ENERSIS S.A.', 'PEDRO CONTRERAS', '954763957', 'PCONTRERAS@ENERSIS.CL', 'TE', 'CAÑETE N°543', 'BIOBIO', 'CAÑETE', '38244', TRUE);

INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('94271000-3', 'CALZADOS BEBA LTDA.', 'JOSEFINA GONZALEZ', '226473517','JGONZALEZ@BEBA.CL', 'TE', 'COQUIMBO','LA SERENA', '61346', TRUE);

INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('83033300-2', 'FARMALOGI S.A.', 'PAMELA ARISTIA', '936892738', 'PARSTIA@FARMA.CL', 'TE', 'PUNTA ARENAS N°345', 'MAGALLANES', 'PUNTA ARENAS', '62554', TRUE);
	 	 	
INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('12856309-1', 'JESSICA ROMERO GALAZ', 'JESSICA ROMERO GALAZ', '968747384', 'JROMERO@GMAIL.COM', 'TI', 'PICHILEMU N°345', 'LIBERTADOR GENERAL BERNARDO O'HIGGINS', 'PICHILEMU', '83269', TRUE);
 	
INSERT INTO EMPLEADOR (RUT, RAZONSOCIAL, CONTACTO, FONO, CORREO, TIPO, DIRECCION, REGION, COMUNA, CODIGOAEO, VIGENTE) VALUES
('14129834-8', 'ADAN GONZALEZ BARRAGAN', 'ADAN GONZALEZ BARRAGAN', '968747384', 'ADBARRAN@GMAIL.COM', 'TI', 'LAS CONDES N°545', 'METROPOLITANA', 'LAS CONDES', '83269', TRUE);



-- ESTADOS SOLICITUD 
INSERT INTO ESTADOS_SOLICITUD (NOMBRE_ESTADO, ESTADO) VALUES
('BORRADOR', 'ACTIVO'),
('APROBADA', 'ACTIVO'),
('RECHAZADA', 'ACTIVO'),
('INICIADA', 'ACTIVO'),
('AGENDADA', 'ACTIVO'),
('FINALIZADA', 'ACTIVO');



-- ACTIVIDADECONOMICA
INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('71121', 'TRANSPORTE URBANO Y SUBURBANO E INTERURBANO', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('38244', 'FABRICACIÓN Y REPARACIÓN DE MÁQUINAS Y EQUIPOS DE IMPRENTA', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('61346', 'MAYORISTAS EN CALZADOS', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('62554', 'FARMACIAS Y PERFUMERÍAS', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('31163', 'ELABORACIÓN DE ALIMENTOS DE CEREALES', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('83245', 'OTROS SERVICIOS TÉCNICOS RELACIONADOS CON LA CONSTRUCCIÓN', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('83269', 'OTROS SERVICIOS DE INGENIERÍA', 'ACTIVO');

INSERT INTO ACTIVIDADECONOMICA (CODIGOAE, DESCRIPCION, ESTADO) VALUES
('62459', 'OTROS NO CLASIFICADOS', 'ACTIVO');

-- BATERIA
INSERT INTO BATERIA (NOMBRE, RECOMENDACION, JORNADA, VIGENTE, IDPRESTADOR) VALUES
('AGENTES PRODUCTORES DE ASMA', 'Postulantes o trabajadores que cumplen la función de manipulación 
o retiro de revestimientos de asbesto. Posteriormente, el trabajador 
debería incorporarse a vigilancia de la salud', 'DIURNA', TRUE, 1);-- SE DEBE VALIDAR EL ID DE UN ORESTADOR REAL 

INSERT INTO BATERIA (NOMBRE, RECOMENDACION, JORNADA, VIGENTE, IDPRESTADOR) VALUES
('HIPERBARIA', 'El trabajador desempeña o desempeñará tareas en condiciones 
hiperbáricas. Además debe ser incorporado a Vigilancia a la 
Salud para evaluar el efecto de la exposición', 'DIURNA', TRUE, 2);

INSERT INTO BATERIA (NOMBRE, RECOMENDACION, JORNADA, VIGENTE, IDPRESTADOR) VALUES
('BATERÍA BÁSICA', 'Postulantes o trabajadores contratados que se encuentran 
postulando o trabajando en un cargo sin exposición a un riesgo o 
peligro específico. Esta evaluación permite pesquisar enfermedades 
del adulto tales como las enfermedades cardiovasculares, 
hipertensión arterial, diabetes y obesidad', 'N/A', TRUE, 2);


INSERT INTO BATERIA (NOMBRE, RECOMENDACION, JORNADA, VIGENTE, IDPRESTADOR) VALUES
('CERTIFICACIÓN APLICADORES DE PLAGUICIDAS', 
'El trabajador será trasladado o se desempeña en un cargo con 
exposición a plaguicidas. Además deberá ser incorporado a 
Vigilancia de Salud para evaluar el efecto de la exposición', 'N/A', TRUE, 3);

INSERT INTO BATERIA (NOMBRE, RECOMENDACION, JORNADA, VIGENTE, IDPRESTADOR) VALUES
('TRABAJO EN ALTURA FÍSICA', 
'El trabajador se desempeña o desempeñara sobre 1,80 m. 
de altura con riesgo de caída libre', 'DIURNA', TRUE, 3);

-- EXAMENES
-- Insert data into EXAMENES
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(1, 'ENCUESTA DE SALUD', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(1, 'ENFERMERIA (ANTROPOMETRIA Y CSV)', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(1, 'ENCUESTA SINTOMAS RESPIRATORIOS ', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(1, 'CONSULTA MEDICA', 'N/A');

INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(2, 'CONTROL DE PRESION', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(2, 'CONSULTA MEDICA', 'N/A');
 
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'CONSULTA MEDICA', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'ENCUESTA DE SALUD', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'ENCUESTA DE SALUD HIOPERBARIA ', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'ENFERMERIA (ANTROPOMETRIA Y CSV)', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'OPTOPOMETRIA', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'ELECTROCARDIOGRAMA', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'ESPIROMETRIA BASAL', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'INDICE DE RUFFIER', 'N/A');
INSERT INTO EXAMENES (IDBATTERIA, NOMBRE, EVALUACION) VALUES
(3, 'RX DE TORAX', 'N/A');


