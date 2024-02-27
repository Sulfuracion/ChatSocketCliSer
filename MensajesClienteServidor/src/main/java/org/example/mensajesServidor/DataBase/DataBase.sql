-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS chatCliSer;
USE chatCliSer;

-- Crear tabla Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear tabla Mensajes
CREATE TABLE IF NOT EXISTS Mensajes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_remitente INT NOT NULL,
    id_destinatario INT NOT NULL,
    txtMensaje TEXT NOT NULL,
    fechaHoraMensaje DATETIME NOT NULL,
    CONSTRAINT fk_remitente FOREIGN KEY (id_remitente) REFERENCES Usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_destinatario FOREIGN KEY (id_destinatario) REFERENCES Usuarios(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO Usuarios (name, password) VALUES('root', '');
-- Insertar usuarios ficticios
INSERT INTO Usuarios (name, password) VALUES
('usuario1', 'clave1'),
('usuario2', 'clave2'),
('usuario3', 'clave3'),
('usuario4', 'clave4');





