public class ArvoreBST {
    private No raiz;

    public ArvoreBST() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }

        return atual;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No atual, int valor) {
        if (atual == null) {
            return false;
        }

        if (atual.valor == valor) {
            return true;
        }

        if (valor < atual.valor) {
            return buscarRec(atual.esquerda, valor);
        } else {
            return buscarRec(atual.direita, valor);
        }
    }
}