package com.company.lucasflucena;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

    public void delete(int key){
        raiz = delete(raiz, key);
    }

    public Node delete(Node raiz, int key){
        //Arvore Vazia
        if (raiz == null) {
            return raiz;
        }

        //Descendo pela árvore
        if (key < raiz.getValue()) {
            raiz.setLeft(delete(raiz.getLeft(), key));
        }
        else if (key > raiz.getValue()) {
            raiz.setRight(delete(raiz.getRight(), key));
        }

        else
        {
            //Nó com 1 filho ou folha
            if (raiz.getLeft() == null) {
                return raiz.getRight();
            }
            else if (raiz.getRight() == null) {
                return raiz.getLeft();
            }

            //Nó com 2 filhos
            raiz.setValue(menorValor(raiz.getRight()));

            raiz.setRight(delete(raiz.getRight(), raiz.getValue()));
        }

        return raiz;
    }

    public int menorValor(Node node)
    {
        int menor = node.getValue();
        while (node.getLeft() != null)
        {
            menor = node.getLeft().getValue();
            node = node.getLeft();
        }
        return menor;
    }

    public  void print()
    {
        printTree(this.raiz);
    }

    public void printTree(Node node)
    {
        if(node == null) return;

        printTree(node.getLeft());
        System.out.print(node.getValue() + "  "  );
        printTree(node.getRight());
    }

    public int getRaiz() {
        return this.raiz.getValue();
    }

    public boolean isBalanced(Node node){
        int lh, rh;

        if (node == null)
            return true;

        lh = height(node.getLeft());
        rh = height(node.getRight());

        if(Math.abs(lh - rh) <= 1 && isBalanced(node.getLeft()) && isBalanced(node.getRight())){
            return true;
        }
        else
            return false;
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lefth = height(node.getLeft());
        int righth = height(node.getRight());

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public boolean isBalanced(int value){
        Node node = raiz.search(value);
        return isBalanced(node);
    }
}