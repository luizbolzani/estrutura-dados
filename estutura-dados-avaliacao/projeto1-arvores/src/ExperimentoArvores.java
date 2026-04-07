import java.util.Random;

public class ExperimentoArvores {

    public static void executar() {
        int[] tamanhos = {1000, 5000, 10000};
        int repeticoes = 30;

        System.out.println("===== PROJETO 1 - ARVORES =====\n");

        for (int tamanho : tamanhos) {

            long[] temposBST = new long[repeticoes];
            long[] temposAVL = new long[repeticoes];

            for (int i = 0; i < repeticoes; i++) {

                Random rand = new Random();

                ArvoreBST bst = new ArvoreBST();
                ArvoreAVL avl = new ArvoreAVL();

                int[] valores = new int[tamanho];

                for (int j = 0; j < tamanho; j++) {
                    valores[j] = rand.nextInt(100000);
                    bst.inserir(valores[j]);
                    avl.inserir(valores[j]);
                }

                int alvo = valores[tamanho - 1];

                long inicio, fim;

                inicio = System.nanoTime();
                bst.buscar(alvo);
                fim = System.nanoTime();
                temposBST[i] = fim - inicio;

                inicio = System.nanoTime();
                avl.inserir(alvo);
                fim = System.nanoTime();
                temposAVL[i] = fim - inicio;
            }

            System.out.println("Tamanho: " + tamanho);

            System.out.printf("BST -> Media: %.2f ns%n",
                    Estatistica.media(temposBST));

            System.out.printf("AVL -> Media: %.2f ns%n",
                    Estatistica.media(temposAVL));

            double custo = CaixeiroViajante.resolver(20);
            System.out.println("Caixeiro viajante (custo): " + custo);

            System.out.println("----------------------------");
        }
    }
}