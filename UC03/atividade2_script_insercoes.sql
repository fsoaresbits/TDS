-- Script de inserção de dados com base nas informações do PDF.

USE corridas_kart;

INSERT INTO Temporada (numero)
VALUES (1);

INSERT INTO Etapa (local, data, hora, Temporada_idTemporada)
VALUES
	('São Paulo',      '2024-01-15', '14:00', 1),
	('Rio de Janeiro', '2024-02-20', '16:00', 1),
    ('Campo Grande',   '2024-03-18', '15:00', 1),
	('Londrina',       '2024-04-22', '13:00', 1),
	('Porto Alegre',   '2024-05-10', '10:00', 1);

INSERT INTO Patrocinio (nomePatrocinio)
VALUES
	('MotorTech'),
	('Velocidade Extrema'),
	('Alta Performance'),
	('Turbo Racing'),
	('Pneus ProDrive');

INSERT INTO Equipe (nome, patrocinio_idPatrocinio)
VALUES
	('Escuderia Veloz',    1),
	('Rápidos & Furiosos', 2),
	('Fênix Racing',       3),
	('Equipe Tempestade',  4),
	('Corredores de Aço',  5);

INSERT INTO Piloto (Nome, peso, capitao, Equipe_idEquipe, nacionalidade)
VALUES
	('Lucas Andrade',     '70.5', '1', 1, 'Brasil'),
	('Renato Figueiredo', '75',   '0', 1, 'Brasil'),
	('Mateus Silva',      '68',   '0', 2, 'Brasil'),
	('Bruno Almeida',     '78.3', '1', 2, 'Brasil'),
	('Carla Pereira',     '60',   '1', 3, 'Portugal'),
	('Gabriela Torres',   '58.5', '0', 3, 'Brasil'),
	('João Costa',        '80.5', '0', 4, 'Brasil'),
	('Thiago Santos',     '72.5', '0', 4, 'Brasil'),
	('Mariana Gomes',     '62',   '1', 5, 'Portugal'),
	('Beatriz Lopes',     '63.2', '1', 5, 'Portugal');

INSERT INTO Etapa_has_Piloto (Etapa_idEtapa, Piloto_idPiloto)
VALUES
	(1, 1),
	(1, 3),
	(1, 5),
	(1, 7),
	(1, 9),
	(1, 2),
	(1, 4),
	(1, 6),
	(1, 8),
	(1, 10);

-- Altera Campo Grande e Londrina para Salvador e Goiânia na tabela Etapa devido a atraso nas licenças.
UPDATE Etapa
SET local = 'Salvador'
WHERE idEtapa = 3;

UPDATE Etapa
SET local = 'Goiânia'
WHERE idEtapa = 4;

-- Remover patrocinador da 'Corredores de Aço' por quebra ética; desativar safe updates para a exclusão.
SET SQL_SAFE_UPDATES = 0;

UPDATE Equipe
SET patrocinio_idPatrocinio = NULL
WHERE nome = 'Corredores de Aço';

DELETE FROM Patrocinio
WHERE idPatrocinio = 5;

-- Exibição dos dados dos pilotos.
SELECT * FROM Piloto;