public class ArvoreAVL {
    private NoAVL raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoAVL inserirRec(NoAVL no, int valor) {
        if (no == null) return new NoAVL(valor);

        if (valor < no.valor)
            no.esquerda = inserirRec(no.esquerda, valor);
        else
            no.direita = inserirRec(no.direita, valor);

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balance = fatorBalanceamento(no);

        // Rotação direita
        if (balance > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        // Rotação esquerda
        if (balance < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        return no;
    }

    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public int altura() {
        return altura(raiz);
    }
}