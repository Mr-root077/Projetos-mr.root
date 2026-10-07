-- ========================================
-- PROJETO SQL - SISTEMA DE LOJA
-- ========================================

-- 1. CRIAR BANCO DE DADOS
CREATE DATABASE loja_sql;

USE loja_sql;

-- ========================================
-- 2. TABELA DE CLIENTES
-- ========================================

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cidade VARCHAR(50),
    data_cadastro DATE
);

-- ========================================
-- 3. TABELAS DE PRODUTOS
-- ========================================

CREATE TABLE produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    preco DECIMAL(10,2) NOT NULL,
    estoque INT NOT NULL,
);


-- =========================================
-- 4. TABELA DE PEDIDOS 
-- =========================================

CREATE TABLE pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido DATE NOT NULL,
    status VARCHAR(30) DEFAULT 'Pendente',

    FOREIGN KEY (id_cliente)
        REFERENCES clientes(id_cliente)
);

-- ==========================================
-- 5. TABELA DE ITENS DOS PEDIDOS
-- ==========================================

CREATE TABLE itens_pedido (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_pedido)
       REFERENCES pedidos(id_pedido),

    FOREIGN KEY (id_produto)
       REFERENCES produtos(id_produto),   
);

-- ===========================================
-- 6. TABELA DE PAGAMENTOS
-- ===========================================

CREATE TABLE pagamentos (
    id_pagmento INT AUTO_INCREMENT PRIMARY KEY,
    id_peidido INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,   
    metodo VARCHAR(30),
    data_pagemento DATE,

    FOREIGN KEY (id_pedido)
      REFERENCES pedidos(id_pedido)
);

-- ============================================
-- 7. INSERIR CLIENTES
-- ============================================

INSERT INTO clientes
(nome, email, telefone, cidade, data_cadastro)
VALUES