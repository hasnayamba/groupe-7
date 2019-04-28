DROP DATABASE tcheto;
CREATE DATABASE tcheto CHARACTER SET 'utf8';
USE tcheto
-- creation de la table Direction
CREATE TABLE user (
 idUser TINYINT UNSIGNED AUTO_INCREMENT,
 nomUser VARCHAR(100),
 prenomUser VARCHAR(25) NOT NULL,
 adresseMac VARCHAR(25) NOT NULL,
 PRIMARY KEY(idUser) -- definir la cle primaire
)ENGINE=InnoDB;
-- creation de la table Departement
CREATE TABLE SOS (
 idSOS TINYINT UNSIGNED AUTO_INCREMENT,
 type TINYINT UNSIGNED,
 latitude float,
 longitude float,
 idUser TINYINT UNSIGNED,
 PRIMARY KEY(idSOS), -- definir la cle primaire
 FOREIGN KEY (idUser)  REFERENCES user (idUser)  
)ENGINE=InnoDB;

INSERT INTO user VALUES(1,'hadiza','mohamadou','null');
INSERT INTO user VALUES(2,'hama','barhamou','null');
INSERT INTO user VALUES(3,'hamina','hama','null');

INSERT INTO SOS VALUES(1,2,13.521389,2.105278,1);
INSERT INTO SOS VALUES(2,2,13.51366,2.1098,1);
INSERT INTO SOS VALUES(3,2,13.532736,2.197897,1)
