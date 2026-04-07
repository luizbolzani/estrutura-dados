public class ArvoreBST {
    private NoBST raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoBST inserirRec(NoBST no, int valor) {
        if (no == null) return new NoBST(valor);

        if (valor < no.valor)
            no.esquerda = inserirRec(no.esquerda, valor);
        else
            no.direita = inserirRec(no.direita, valor);

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NoBST no, int valor) {
        if (no == null) return false;
        if (no.valor == valor) return true;

        if (valor < no.valor)
            return buscarRec(no.esquerda, valor);
        else
            return buscarRec(no.direita, valor);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NoBST no) {
        if (no == null) return -1;
        return 1 + Math.max(alturaRec(no.esquerda), alturaRec(no.direita));
    }
}