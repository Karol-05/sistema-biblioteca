-- SISTEMA DE BIBLIOTECA
-- QUATRO CONSULTAS SQL

-- CONSULTA 1
-- Listar todos os itens do acervo.

SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY codigo;

-- CONSULTA 2
-- Listar empréstimos em aberto,
-- mostrando o usuário e o título do item.

SELECT
    u.nome AS usuario,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u ON u.id = e.usuario_id
INNER JOIN item i ON i.id = e.item_id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_retirada;

-- CONSULTA 3
-- Calcular o total de multas por usuário.

SELECT
    u.id,
    u.nome,
    COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON e.usuario_id = u.id
GROUP BY u.id, u.nome
ORDER BY u.nome;

-- CONSULTA 4
-- Listar itens que nunca foram emprestados.

SELECT
    i.id,
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON e.item_id = i.id
WHERE e.id IS NULL
ORDER BY i.codigo;
