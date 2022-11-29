CREATE TABLE tb_cidade(
    id_cidade BIGINT  NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    qtd_habitantes BIGINT
);

INSERT INTO tb_cidade
    (id_cidade,nome,qtd_habitantes)

VALUES
    (1,'Jaboatao dos Guararapes',2532567),
    (2,'Porto Alegre',1455656),
    (3,'Recife',5662322),
    (4,'Teresina',13659656),
    (5,'São Luiz do Maranhão',88898998),
    (6,'Aracaju',77747447),
    (7,'Natal',2145263),
    (8,'Porto Velho',33622564),
    (9,'São Paulo',12523654),
    (11,'Brasilia',11526263),
    (12,'Manaus',178535698),
    (13,'Maceio',1152634),
    (14,'Belo Horizonte',151526263)
;
