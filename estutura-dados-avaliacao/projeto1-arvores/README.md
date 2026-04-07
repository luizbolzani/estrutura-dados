# Projeto 1 - Arvores

## Descricao
Este projeto implementa e compara estruturas de dados baseadas em arvores:

- Arvore Binaria de Busca (BST)
- Arvore AVL (balanceada)
- Heuristica do Caixeiro Viajante

O objetivo e analisar o desempenho dessas estruturas em operacoes de busca e insercao.

## Estrutura
- src: codigo fonte
- resultados: saida dos experimentos
- relatorio: documento final

## Como executar

1. Compilar:
javac src/*.java

2. Executar:
java -cp src Main

## Experimentos
Foram utilizados tamanhos:
- 1000
- 5000
- 10000

Cada experimento foi executado 30 vezes.

## Observacoes
A BST pode se tornar desbalanceada, afetando o desempenho.
A AVL mantem balanceamento automatico, garantindo melhor eficiencia.
O problema do caixeiro viajante foi resolvido utilizando heuristica gulosa.