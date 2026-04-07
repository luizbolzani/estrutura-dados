public class Estatistica {

    public static double media(long[] valores) {
        double soma = 0;

        for (long v : valores) {
            soma += v;
        }

        return soma / valores.length;
    }

    public static double desvioPadrao(long[] valores) {
        double media = media(valores);
        double soma = 0;

        for (long v : valores) {
            soma += Math.pow(v - media, 2);
        }

        return Math.sqrt(soma / valores.length);
    }
}