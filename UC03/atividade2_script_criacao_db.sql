-- Script de criação do banco de dados com base no diagrama ER.

DROP DATABASE IF EXISTS corridas_kart;

CREATE DATABASE corridas_kart;

USE corridas_kart;

CREATE TABLE Patrocinio (
	idPatrocinio INT NOT NULL AUTO_INCREMENT,
    nomePatrocinio VARCHAR(45) NOT NULL,
    PRIMARY KEY (IdPatrocinio)
);

CREATE TABLE Temporada (
	idTemporada INT NOT NULL AUTO_INCREMENT,
    numero INT NOT NULL,
    PRIMARY KEY (idTemporada)
);

CREATE TABLE Equipe (
	idEquipe INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    patrocinio_idPatrocinio INT UNIQUE,
    PRIMARY KEY (idEquipe),
    FOREIGN KEY (patrocinio_idPatrocinio) REFERENCES Patrocinio(idPatrocinio)
);

CREATE TABLE Etapa (
	idEtapa INT NOT NULL AUTO_INCREMENT,
    local VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    hora VARCHAR (45),
    Temporada_idTemporada INT NOT NULL,
    PRIMARY KEY (idEtapa),
    FOREIGN KEY (Temporada_idTemporada) REFERENCES Temporada(idTemporada)
);

CREATE TABLE Piloto (
	idPiloto INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(150) NOT NULL,
    peso FLOAT NOT NULL,
    capitao TINYINT NOT NULL,
    Equipe_idEquipe INT NOT NULL,
    nacionalidade VARCHAR(40),
    PRIMARY KEY (idPiloto),
    FOREIGN KEY (Equipe_idEquipe) REFERENCES Equipe(idEquipe)
);

CREATE TABLE Etapa_has_Piloto (
	Etapa_idEtapa INT NOT NULL,
    Piloto_idPiloto INT NOT NULL,
    PRIMARY KEY (Etapa_idEtapa, Piloto_idPiloto),
    FOREIGN KEY (Etapa_idEtapa) REFERENCES Etapa(idEtapa),
    FOREIGN KEY (Piloto_idPiloto) REFERENCES Piloto(idPiloto)
);
