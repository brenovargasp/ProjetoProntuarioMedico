CREATE DATABASE bd_UBS;

USE bd_UBS;

CREATE TABLE Funcionarios (
  idFuncionarios INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  cpf VARCHAR(12) NULL,
  senha VARCHAR(8) NULL,
  cargo INTEGER UNSIGNED NULL,
  PRIMARY KEY(idFuncionarios)
);

CREATE TABLE Pacientes (
  cpf VARCHAR(12) NOT NULL,
  nome VARCHAR(45) NULL,
  email VARCHAR(50) NULL,
  data_nasc DATE NULL,
  celular VARCHAR(45) NULL,
  endereco VARCHAR(45) NULL,
  cidade VARCHAR(20) NULL,
  cep VARCHAR(20) NULL,
  nr_SUS BIGINT UNSIGNED NULL,
  genero VARCHAR(2) NULL,
  PRIMARY KEY(cpf)
);

CREATE TABLE Especialidades (
  idEspecialidades INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(idEspecialidades)
);

CREATE TABLE Atendimento (
  idAtendimentos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Especialidades_idEspecialidades INTEGER UNSIGNED NOT NULL,
  Paciente_cpf VARCHAR(12) NOT NULL,
  data_atendimento DATE NULL,
  tipo INTEGER UNSIGNED NULL,
  nr_atendimento INTEGER UNSIGNED NULL,
  pressao_art FLOAT NULL,
  temperatura FLOAT NULL,
  sintomas VARCHAR(45) NULL,
  frequencia_card FLOAT NULL,
  status_aten INTEGER UNSIGNED NULL,
  PRIMARY KEY(idAtendimentos),
  INDEX Atendimento_FKIndex1(Paciente_cpf),
  INDEX Atendimento_FKIndex2(Especialidades_idEspecialidades),
  FOREIGN KEY(Paciente_cpf)
    REFERENCES Pacientes(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Especialidades_idEspecialidades)
    REFERENCES Especialidades(idEspecialidades)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Prontuario (
  idProntuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Funcionario_idFuncionario INTEGER UNSIGNED NOT NULL,
  Atendimento_idAtendimento INTEGER UNSIGNED NOT NULL,
  anamnese TEXT NULL,
  plano_terapeutico TEXT NULL,
  encaminhamento VARCHAR(45) NULL,
  PRIMARY KEY(idProntuario),
  INDEX Prontuario_FKIndex1(Atendimento_idAtendimento),
  INDEX Prontuario_FKIndex2(Funcionario_idFuncionario),
  FOREIGN KEY(Atendimento_idAtendimento)
    REFERENCES Atendimento(idAtendimentos)  -- Corrigido idAtendimentos
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Funcionario_idFuncionario)  -- Corrigido Funcionario_idFuncionario
    REFERENCES Funcionarios(idFuncionarios)  -- Referencia correta para idFuncionarios
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

INSERT INTO Pacientes (cpf, nome, email, data_nasc, celular, endereco, cidade, cep, nr_SUS, genero) VALUES
('12345678901', 'Lucas Oliveira', 'lucas.oliveira@example.com', '1985-03-25', '5511998765432', 'Rua das Flores, 123', 'São Paulo', '01001-000', 1234567890, 'M'),
('23456789012', 'Mariana Costa', 'mariana.costa@example.com', '1990-07-15', '5511987654321', 'Avenida Brasil, 456', 'Rio de Janeiro', '20001-000', 2345678901, 'F'),
('34567890123', 'Carlos Santos', 'carlos.santos@example.com', '1978-12-05', '5511976543210', 'Rua da Harmonia, 789', 'Belo Horizonte', '30001-000', 3456789012, 'M'),
('45678901234', 'Fernanda Lima', 'fernanda.lima@example.com', '1995-05-20', '5511965432109', 'Avenida Paulista, 101', 'São Paulo', '01002-000', 2345678901, 'F'),  -- Ajustado para valor dentro do intervalo
('56789012345', 'Rafael Almeida', 'rafael.almeida@example.com', '1983-11-10', '5511954321098', 'Rua do Comércio, 202', 'Curitiba', '80001-000', 5678901234, 'M'),
('67890123456', 'Amanda Ferreira', 'amanda.ferreira@example.com', '1992-08-30', '5511943210987', 'Avenida das Américas, 303', 'Rio de Janeiro', '20002-000', 6789012345, 'F'),
('78901234567', 'Gustavo Martins', 'gustavo.martins@example.com', '1980-01-15', '5511932109876', 'Rua da Paz, 404', 'Porto Alegre', '90001-000', 7890123456, 'M'),
('89012345678', 'Juliana Rodrigues', 'juliana.rodrigues@example.com', '1988-04-25', '5511921098765', 'Avenida Central, 505', 'Florianópolis', '88001-000', 8901234567, 'F'),
('90123456789', 'Pedro Carvalho', 'pedro.carvalho@example.com', '1975-09-12', '5511910987654', 'Rua das Palmeiras, 606', 'Salvador', '40001-000', 9012345678, 'M'),
('01234567890', 'Bianca Souza', 'bianca.souza@example.com', '1993-02-17', '5511909876543', 'Avenida Rio Branco, 707', 'Recife', '50001-000', 1234567899, 'F');

INSERT INTO Funcionarios (nome, cpf, senha, cargo) VALUES
('José Silva', '11122233344', 'abc123', 1),
('Maria Santos', '22233344455', 'def456', 2),
('Carlos Oliveira', '33344455566', 'ghi789', 3),
('Ana Costa', '44455566677', 'jkl012', 4),
('Fernanda Pereira', '55566677788', 'mno345', 1),
('Paulo Lima', '66677788899', 'pqr678', 2),
('Mariana Souza', '77788899900', 'stu901', 3),
('Rodrigo Alves', '88899900011', 'vwx234', 4),
('Aline Rodrigues', '99900011122', 'yzab56', 1),
('Gustavo Santos', '00011122233', 'cdef78', 2);

INSERT INTO Especialidades (nome) VALUES
(1),  -- Cardiologia
(2),  -- Dermatologia
(3),  -- Endocrinologia
(4),  -- Gastroenterologia
(5),  -- Ginecologia
(6),  -- Neurologia
(7),  -- Ortopedia
(8),  -- Pediatria
(9),  -- Psiquiatria
(10); -- Urologia

INSERT INTO Atendimento (Especialidades_idEspecialidades, Paciente_cpf, data_atendimento, tipo, nr_atendimento, pressao_art, temperatura, sintomas, frequencia_card, status_aten) VALUES
(1, '12345678901', '2024-06-01', 1, 1001, 120.5, 36.7, 'Dor no peito', 72.0, 1),
(2, '23456789012', '2024-06-02', 2, 1002, 110.0, 37.1, 'Erupção cutânea', 80.0, 2),
(1, '34567890123', '2024-06-03', 1, 1003, 115.5, 36.8, 'Fadiga', 78.0, 1),
(2, '45678901234', '2024-06-04', 2, 1004, 130.2, 37.5, 'Dor abdominal', 85.0, 2),
(1, '56789012345', '2024-06-05', 1, 1005, 125.0, 36.9, 'Cólica menstrual', 70.0, 1),
(2, '67890123456', '2024-06-06', 2, 1006, 118.5, 37.0, 'Dor de cabeça', 75.0, 2),
(1, '78901234567', '2024-06-07', 1, 1007, 110.8, 36.6, 'Dor nas costas', 68.0, 1),
(2, '89012345678', '2024-06-08', 2, 1008, 122.3, 37.2, 'Febre alta', 90.0, 2),
(1, '90123456789', '2024-06-09', 1, 1009, 115.2, 36.7, 'Ansiedade', 76.0, 1),
(2, '01234567890', '2024-06-10', 2, 1010, 130.0, 37.3, 'Dor lombar', 88.0, 2);
-- tipo: 1 para consulta, 2 para emergência
-- status_aten: 1 para em andamento, 2 para concluído

USE bd_UBS;

SELECT * FROM Pacientes;

SELECT * FROM Funcionarios;

SELECT * FROM Especialidades;

SELECT * FROM Atendimento;

SELECT * FROM Prontuario;