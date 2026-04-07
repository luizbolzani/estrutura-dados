import java.util.Random;
import java.util.Arrays;

public class Experimento {

    public static void executar() {
        int[] tamanhos = {1000, 5000, 10000};
        int repeticoes = 30;

        System.out.println("===== PROJETO 2 - SISTEMAS DE BUSCA =====\n");

        for (int tamanho : tamanhos) {
            long[] temposSequencial = new long[repeticoes];
            long[] temposBinaria = new long[repeticoes];
            long[] temposArvore = new long[repeticoes];

            for (int i = 0; i < repeticoes; i++) {
                int[] vetor = gerarVetorOrdenado(tamanho);
                int alvo = vetor[vetor.length - 1]; // busca o último elemento

                long inicio, fim;

                // Busca sequencial
                inicio = System.nanoTime();
                Buscas.buscaSequencial(vetor, alvo);
                fim = System.nanoTime();
                temposSequencial[i] = fim - inicio;

                // Busca binária
                inicio = System.nanoTime();
                Buscas.buscaBinaria(vetor, alvo);
                fim = System.nanoTime();
                temposBinaria[i] = fim - inicio;

                // Busca em arvore BST
                ArvoreBST arvore = new ArvoreBST();
                for (int valor : vetor) {
                    arvore.inserir(valor);
                }

                inicio = System.nanoTime();
                arvore.buscar(alvo);
                fim = System.nanoTime();
                temposArvore[i] = fim - inicio;
            }

            System.out.println("Tamanho do vetor: " + tamanho);

            System.out.printf("Busca Sequencial -> Media: %.2f ns | Desvio Padrao: %.2f ns%n",
                    Estatistica.media(temposSequencial),
                    Estatistica.desvioPadrao(temposSequencial));

            System.out.printf("Busca Binaria    -> Media: %.2f ns | Desvio Padrao: %.2f ns%n",
                    Estatistica.media(temposBinaria),
                    Estatistica.desvioPadrao(temposBinaria));

            System.out.printf("Busca em Arvore  -> Media: %.2f ns | Desvio Padrao: %.2f ns%n",
                    Estatistica.media(temposArvore),
                    Estatistica.desvioPadrao(temposArvore));

            System.out.println();
        }
    }

    private static int[] gerarVetorOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        return vetor;
    }
}