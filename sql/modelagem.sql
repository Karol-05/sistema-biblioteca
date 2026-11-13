-- SISTEMA DE BIBLIOTECA
-- MODELAGEM DO BANCO DE DADOS

CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(10) NOT NULL
        CHECK (tipo IN ('LIVRO', 'REVISTA')),
    autor VARCHAR(120),
    edicao INTEGER,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CHECK (
        (tipo = 'LIVRO' AND autor IS NOT NULL AND edicao IS NULL)
        OR
        (tipo = 'REVISTA' AND edicao IS NOT NULL AND autor IS NULL)
    )
);

CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    tipo VARCHAR(12) NOT NULL
        CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
    limite_itens INTEGER NOT NULL,

    CHECK (
        (tipo = 'ALUNO' AND limite_itens = 3)
        OR
        (tipo = 'PROFESSOR' AND limite_itens = 5)
    )
);

CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL REFERENCES item(id),
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0
        CHECK (valor_multa >= 0)
);

-- DADOS DE TESTE: ITENS

INSERT INTO item
(codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
('L001', 'Dom Casmurro', 'LIVRO', 'Machado de Assis', NULL, FALSE),
('L002', 'O Hobbit', 'LIVRO', 'J. R. R. Tolkien', NULL, TRUE),
('R001', 'Ciencia Hoje', 'REVISTA', NULL, 320, FALSE),
('L003', '1984', 'LIVRO', 'George Orwell', NULL, TRUE);

-- DADOS DE TESTE: USUÁRIOS

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
('Ana Souza', 'ALUNO', 3),
('Carlos Lima', 'PROFESSOR', 5);

-- DADOS DE TESTE: EMPRÉSTIMOS
-- Um empréstimo devolvido e outro em aberto.

INSERT INTO emprestimo
(item_id, usuario_id, data_retirada,
 data_devolucao_prevista, data_devolucao, valor_multa)
VALUES
(1, 1, CURRENT_DATE - 20, CURRENT_DATE - 6,
 CURRENT_DATE - 4, 1.00),

(3, 2, CURRENT_DATE - 2, CURRENT_DATE + 5,
 NULL, 0.00);
