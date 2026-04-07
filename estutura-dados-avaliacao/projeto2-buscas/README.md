# Projeto 2 - Sistemas de Busca

## Descrição
Este projeto implementa e compara três algoritmos de busca:

- Busca Sequencial
- Busca Binária
- Busca em Árvore de Busca (BST)

O objetivo é analisar o desempenho teórico e prático de cada método.

## Tecnologias
- Java
- VS Code

## Estrutura
- src: código-fonte
- resultados: saída dos experimentos
- relatorio: documento em PDF

## Como executar

1. Compilar:
javac src/*.java

2. Executar:
java -cp src Main

## Experimentos

Foram utilizados vetores com tamanhos:
- 1000
- 5000
- 10000

Cada experimento foi executado 30 vezes.

## Resultados esperados

- Busca Sequencial: O(n)
- Busca Binária: O(log n)
- Árvore BST: O(log n) em média e O(n) no pior caso