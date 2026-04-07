import java.util.Random;

public class ExperimentoOrdenacao {

    public static void executar() {
        int[] tamanhos = {1000, 5000, 10000};
        int repeticoes = 30;

        System.out.println("===== PROJETO 3 - ORDENACAO =====\n");

        for (int tamanho : tamanhos) {
            testarCaso("Melhor Caso", gerarVetorOrdenado(tamanho), repeticoes, tamanho);
            testarCaso("Caso Medio", gerarVetorAleatorio(tamanho), repeticoes, tamanho);
            testarCaso("Pior Caso", gerarVetorReverso(tamanho), repeticoes, tamanho);
            System.out.println("--------------------------------------------------");
        }
    }

    private static void testarCaso(String tipoCaso, int[] vetorBase, int repeticoes, int tamanho) {
        long[] temposMerge = new long[repeticoes];
        long[] temposQuick = new long[repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetorMerge = vetorBase.clone();
            int[] vetorQuick = vetorBase.clone();

            long inicio, fim;

            inicio = System.nanoTime();
            Ordenacoes.mergeSort(vetorMerge, 0, vetorMerge.length - 1);
            fim = System.nanoTime();
            temposMerge[i] = fim - inicio;

            inicio = System.nanoTime();
            Ordenacoes.quickSort(vetorQuick, 0, vetorQuick.length - 1);
            fim = System.nanoTime();
            temposQuick[i] = fim - inicio;
        }

        System.out.println("Tamanho do vetor: " + tamanho + " | " + tipoCaso);
        System.out.printf("Merge Sort -> Media: %.2f ns | Desvio Padrao: %.2f ns%n",
                Estatistica.media(temposMerge),
                Estatistica.desvioPadrao(temposMerge));

        System.out.printf("Quick Sort -> Media: %.2f ns | Desvio Padrao: %.2f ns%n%n",
                Estatistica.media(temposQuick),
                Estatistica.desvioPadrao(temposQuick));
    }

    private static int[] gerarVetorOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        return vetor;
    }

    private static int[] gerarVetorReverso(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    private static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100000);
        }

        return vetor;
    }
}