import java.util.Random;

public class CaixeiroViajante {

    public static double resolver(int n) {
        Random rand = new Random();
        double[][] dist = new double[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = rand.nextInt(100) + 1;

        boolean[] visitado = new boolean[n];
        int atual = 0;
        visitado[0] = true;

        double custo = 0;

        for (int i = 1; i < n; i++) {
            int proximo = -1;
            double menor = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && dist[atual][j] < menor) {
                    menor = dist[atual][j];
                    proximo = j;
                }
            }

            visitado[proximo] = true;
            custo += menor;
            atual = proximo;
        }

        custo += dist[atual][0];
        return custo;
    }
}