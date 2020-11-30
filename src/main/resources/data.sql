/*

DROP TABLE IF EXISTS lanchonete-api;

CREATE TABLE ingrediente (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  preco DECIMAL(15,2) NOT NULL
);
*/

INSERT INTO ingrediente (nome, preco) VALUES
  ('Alface', 0.40),
  ('Bacon', 2.00),
  ('Hambúrguer', 3.00),
  ('Ovo', 0.80),
  ('Queijo', 1.50);
  
 INSERT INTO LANCHE (nome) values
('X-Bacon'),
('X-Burger'),
('X-Egg'),
('X-Egg Bacon');

INSERT INTO LANCHES_INGREDIENTES (LANCHE_ID, INGREDIENTE_ID)
VALUES
(1,2),
(1,3),
(1,5);
