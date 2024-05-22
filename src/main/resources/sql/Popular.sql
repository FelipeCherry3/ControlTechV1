use ControleTechFabrica3;

select * from produto;

-- Desabilitar verificações de chave estrangeira
SET FOREIGN_KEY_CHECKS = 0;

-- Truncar todas as tabelas
TRUNCATE TABLE users_has_produto;
TRUNCATE TABLE software_has_licencas;
TRUNCATE TABLE produto_has_fornecedor;
TRUNCATE TABLE produto_has_categoria;
TRUNCATE TABLE ativoFisico;
TRUNCATE TABLE software;
TRUNCATE TABLE licencas;
TRUNCATE TABLE produto;
TRUNCATE TABLE localArmazenado;
TRUNCATE TABLE subLocal;
TRUNCATE TABLE fornecedor;
TRUNCATE TABLE categoria;
TRUNCATE TABLE users;

-- Reabilitar verificações de chave estrangeira

-- Populando a tabela 'users'
INSERT INTO users (nome, login, user_password, endereco) VALUES
('Alice Silva', 'alice.s', MD5('senha123'), 'Rua A, 123'),
('Bruno Costa', 'bruno.c', MD5('senha456'), 'Rua B, 456'),
('Carla Souza', 'carla.s', MD5('senha789'), 'Rua C, 789');

-- Populando a tabela 'subLocal'
INSERT INTO subLocal (nomeLocal, endereco, descricao) VALUES
('Armazém Central', 'Av. Central, 1000', 'Local principal de armazenamento'),
('Depósito Secundário', 'Rua Secundária, 500', 'Depósito para materiais diversos');

-- Populando a tabela 'localArmazenado'
INSERT INTO localArmazenado (nomeLocal, endereco, descricao, subLocal) VALUES
('Estoque A', 'Av. Central, 1000 - Sala 1', 'Estoque de eletrônicos', 1),
('Estoque B', 'Av. Central, 1000 - Sala 2', 'Estoque de móveis', 1),
('Depósito Auxiliar', 'Rua Secundária, 500 - Sala 1', 'Depósito de suporte', 2);

-- Populando a tabela 'produto'
INSERT INTO produto (nome, qntEstoque, valorItem, dataAquisicao, statusAtivo, descricao, idLocalArmazenado) VALUES
('Notebook Dell', 10, 3500.00, '2023-01-15', 'Ativo', 'Notebook para uso corporativo', 1),
('Cadeira Ergonomica', 25, 750.00, '2023-03-20', 'Ativo', 'Cadeira para escritório', 2),
('Monitor Samsung', 15, 1200.00, '2023-02-10', 'Ativo', 'Monitor de 27 polegadas', 1);

-- Populando a tabela 'ativoFisico'
INSERT INTO ativoFisico (id_user, id_produto) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Populando a tabela 'software'
INSERT INTO software (versao, data_expira, n_licenca, tipo_OS, id_produto) VALUES
('1.0.0', '2024-12-31', 'LIC123456', 'Windows', 1),
('2.1.0', '2025-06-30', 'LIC654321', 'Linux', 1),
('3.3.2', '2024-11-15', 'LIC987654', 'macOS', 1);

-- Populando a tabela 'licencas'
INSERT INTO licencas (chave, observacoes, id_usuario) VALUES
('ABCD-1234-EFGH-5678', 'Licença anual', 1),
('IJKL-9012-MNOP-3456', 'Licença semestral', 2),
('QRST-7890-UVWX-1234', 'Licença trimestral', 3);

-- Populando a tabela 'categoria'
INSERT INTO categoria (nome) VALUES
('Eletrônicos'),
('Móveis'),
('Acessórios');

-- Populando a tabela 'fornecedor'
INSERT INTO fornecedor (nome, endereco, cnpj) VALUES
('Tech Supplies Ltda', 'Rua das Empresas, 1234', '12.345.678/0001-90'),
('Furnish Co', 'Av. das Indústrias, 5678', '98.765.432/0001-09');

-- Populando a tabela 'users_has_produto'
INSERT INTO users_has_produto (id_users, id_produto) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Populando a tabela 'software_has_licencas'
INSERT INTO software_has_licencas (id_licenca, id_software) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Populando a tabela 'produto_has_fornecedor'
INSERT INTO produto_has_fornecedor (id_produto, id_fornecedor) VALUES
(1, 1),
(2, 2),
(3, 1);

-- Populando a tabela 'produto_has_categoria'
INSERT INTO produto_has_categoria (id_produto, id_categoria) VALUES
(1, 1),
(2, 2),
(3, 1);