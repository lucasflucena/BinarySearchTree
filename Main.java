package com.company.lucasflucena;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(new Node(30));
        arvore.insert(21);
        arvore.insert(38);
        arvore.insert(18);
        arvore.insert(19);
        arvore.insert(39);
        arvore.insert(37);

        Node n = arvore.search(80);
        if (n != null) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento não encontrado");
        }

        arvore.delete(30);
        arvore.print();
    }
}
