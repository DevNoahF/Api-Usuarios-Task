-- Migrations para adicionar a coluna sexo na tabela usuario
ALTER TABLE tb_usuarios
ADD COLUMN sexo VARCHAR(255);