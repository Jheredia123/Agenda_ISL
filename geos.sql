-- Database: db_geos

-- Drop tables if they exist
DROP TABLE IF EXISTS agenda_examen;
DROP TABLE IF EXISTS comentarios_solicitud;
DROP TABLE IF EXISTS prestador;
DROP TABLE IF EXISTS dashboard;
DROP TABLE IF EXISTS solicitud_trabajador_examen;
DROP TABLE IF EXISTS EXAMEN;
DROP TABLE IF EXISTS AGENDA;
DROP TABLE IF EXISTS SOLICITUD;
DROP TABLE IF EXISTS TRABAJADOR;
DROP TABLE IF EXISTS EMPLEADOR;
DROP TABLE IF EXISTS USUARIOS;

-- Create table USUARIOS
CREATE TABLE USUARIOS (
    idusuario INT PRIMARY KEY AUTO_INCREMENT,
    rut VARCHAR(255) UNIQUE NOT NULL,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    region VARCHAR(255) NOT NULL,
    comuna VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    fono VARCHAR(255) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL
);

-- Create table EMPLEADOR
CREATE TABLE EMPLEADOR (
    idempleador INT PRIMARY KEY AUTO_INCREMENT,
    rut VARCHAR(255) UNIQUE NOT NULL,
    razonsocial VARCHAR(255) NOT NULL,
    contacto VARCHAR(255) NOT NULL,
    fono VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL
);

-- Create table TRABAJADOR
CREATE TABLE TRABAJADOR (
    idtrabajador INT PRIMARY KEY AUTO_INCREMENT,
    rut VARCHAR(255) UNIQUE NOT NULL,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    region VARCHAR(255) NOT NULL,
    comuna VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL
);

-- Create table SOLICITUD
CREATE TABLE SOLICITUD (
    idslicitud INT PRIMARY KEY AUTO_INCREMENT,
    fechasolicitud DATE NOT NULL,
    idempleador INT NOT NULL,
    idtrabajador INT NOT NULL,
    comentariossolicitud VARCHAR(255),
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idempleador) REFERENCES EMPLEADOR(idempleador),
    FOREIGN KEY (idtrabajador) REFERENCES TRABAJADOR(idtrabajador)
);

-- Create table AGENDA
CREATE TABLE AGENDA (
    idagenda INT PRIMARY KEY AUTO_INCREMENT,
    idslicitud INT NOT NULL,
    fechainicio DATE NOT NULL,
    fechafin DATE NOT NULL,
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idslicitud) REFERENCES SOLICITUD(idslicitud)
);

-- Create table EXAMEN
CREATE TABLE EXAMEN (
    idexamen INT PRIMARY KEY AUTO_INCREMENT,
    idagenda INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    comentario VARCHAR(255),
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idagenda) REFERENCES AGENDA(idagenda)
);

-- Create table solicitud_trabajador_examen
CREATE TABLE solicitud_trabajador_examen (
    idsolicitud_trabajador_examen INT PRIMARY KEY AUTO_INCREMENT,
    idslicitud INT NOT NULL,
    idexamen INT NOT NULL,
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idslicitud) REFERENCES SOLICITUD(idslicitud),
    FOREIGN KEY (idexamen) REFERENCES EXAMEN(idexamen)
);

-- Create table dashboard
CREATE TABLE dashboard (
    iddashboard INT PRIMARY KEY AUTO_INCREMENT,
    fecha_reporte DATE NOT NULL,
    cantidad_solicitudes INT NOT NULL,
    cantidad_trabajadores_registrados INT NOT NULL,
    cantidad_empleadores_registrados INT NOT NULL,
    cantidad_examenes_realizados INT NOT NULL
);

-- Create table prestador
CREATE TABLE prestador (
    idprestador INT PRIMARY KEY AUTO_INCREMENT,
    rut VARCHAR(255) UNIQUE NOT NULL,
    razonsocial VARCHAR(255) NOT NULL,
    contacto VARCHAR(255) NOT NULL,
    fono VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL
);

-- Create table comentarios_solicitud
CREATE TABLE comentarios_solicitud (
    idcomentario_solicitud INT PRIMARY KEY AUTO_INCREMENT,
    idslicitud INT NOT NULL,
    comentario VARCHAR(255) NOT NULL,
    fecha_comentario DATE NOT NULL,
    usuario_creacion VARCHAR(255) NOT NULL,
    FOREIGN KEY (idslicitud) REFERENCES SOLICITUD(idslicitud)
);

-- Create table agenda_examen
CREATE TABLE agenda_examen (
    idagenda_examen INT PRIMARY KEY AUTO_INCREMENT,
    idagenda INT NOT NULL,
    idexamen INT NOT NULL,
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idagenda) REFERENCES AGENDA(idagenda),
    FOREIGN KEY (idexamen) REFERENCES EXAMEN(idexamen)
);
