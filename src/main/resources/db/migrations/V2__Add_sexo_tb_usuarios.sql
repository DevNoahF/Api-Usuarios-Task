-- Migrations para adicionar a coluna sexo na tabela usuario
ALTER TABLE TB_USUARIOS
ADD COLUMN sexo VARCHAR(255);