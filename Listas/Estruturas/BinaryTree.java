package Estruturas;

public class BinaryTree<T extends Comparable<T>> {
    public NodeTree<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        this.root = insert(data, this.root);
    }

    private NodeTree<T> insert(T data, NodeTree<T> node) {
        if (node == null) {
            node = new NodeTree<T>(data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }
        return node;
    }

    public boolean search(T data) {
        return search(data, this.root);
    }

    private boolean search(T data, NodeTree<T> node) {
        if (node == null) {
            return false;
        } else if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return search(data, node.left);
        } else {
            return search(data, node.right);
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(NodeTree<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public void printPreOrder() {
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPreOrder(NodeTree<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrder(this.root);
        System.out.println();
    }

    private void printPostOrder(NodeTree<T> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int alturaArvoreBinaria() {
        return alturaArvoreBinaria(root);
    }

    public int alturaArvoreBinaria(NodeTree<T> raiz) {
        if (raiz == null) {
            return 0;
        } else {
            int alturaEsquerda = alturaArvoreBinaria(raiz.left);
            int alturaDireita = alturaArvoreBinaria(raiz.right);
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public int getSize() {
        return getSize(this.root);
    }

    private int getSize(NodeTree<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public T getMin() {
        return getMin(this.root);
    }

    private T getMin(NodeTree<T> node) {
        if (node.left == null) {
            return node.data;
        }
        return getMin(node.left);
    }

    public T getMax() {
        return getMax(this.root);
    }

    private T getMax(NodeTree<T> node) {
        if (node.right == null) {
            return node.data;
        }
        return getMax(node.right);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public int verificaHeap() {
        return verificaHeap(root);
    }

    public int verificaHeap(NodeTree<T> raiz) {
        if (raiz == null)
            return 0; // caso base: ??rvore vazia

        int left = verificaHeap(raiz.left); // verifica se a sub??rvore esquerda ?? um heap
        int right = verificaHeap(raiz.right); // verifica se a sub??rvore direita ?? um heap

        if (left == 0 || right == 0)
            return 0; // se pelo menos uma das sub??rvores n??o for heap, a ??rvore inteira tamb??m n??o ??
                      // heap
        if (left <= -1 && right <= -1) { // se as duas sub??rvores s??o minheaps
            if (raiz.data.compareTo(raiz.left.data) <= 0 && raiz.data.compareTo(raiz.right.data) <= 0) {
                // se o n?? raiz ?? menor ou igual aos filhos, ?? um minheap
                return -1;
            } else {
                return 0;
            }
        } else if (left >= 1 && right >= 1) { // se as duas sub??rvores s??o maxheaps
            if (raiz.data.compareTo(raiz.left.data) >= 0 && raiz.data.compareTo(raiz.right.data) >= 0) {
                // se o n?? raiz ?? maior ou igual aos filhos, ?? um maxheap
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0; // se uma sub??rvore for minheap e a outra for maxheap, a ??rvore inteira n??o ??
                      // heap
        }
    }
}
