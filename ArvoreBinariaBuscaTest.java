package com.company.lucasflucena;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArvoreBinariaBuscaTest{

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void deveEncontrarElemento() {
        //Arrange
        ArvoreBinariaBusca b = new ArvoreBinariaBusca();
        b.insert(10);
        b.insert(12);
        b.insert(9);

        //Act
        Node n = b.search(9);

        //Assert
        assertNotNull(n);
    }

    @Test
    public void isEmptyDeveRetornarTrueSeNaoHouverElementos() {

        //arrange
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();

        //act
        boolean b = a.isEmpty();

        assertTrue(b);

        //arrange
        a.insert(1);

        //assert
        assertFalse(a.isEmpty());
    }

    @Test
    public void isnotemptydeveretornartruesenaohouverelementos() {
        //arrange
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();
        a.insert(1);

        //act
        boolean b = a.isEmpty();

        //assert
        assertFalse(b);
    }

    @Test
    public void deletaRaiz() {
        //arrange
        /* Arvore Binaria:

              30
           /       \
          19        38
         /  \      /  \
        18   21   37   39   */

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(new Node(30));
        arvore.insert(21);
        arvore.insert(38);
        arvore.insert(18);
        arvore.insert(19);
        arvore.insert(39);
        arvore.insert(37);

        //act
        arvore.delete(30);

        //assert
        /* Arvore Binaria:

              37
           /       \
          19        38
         /  \         \
        18   21        39   */

        assertEquals(37,arvore.getRaiz());
    }

    @Test
    public void deletaFolha() {
        //arrange
        /* Arvore Binaria:

              30
           /       \
          19        38
         /  \      /  \
        18   21   37   39   */

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(new Node(30));
        arvore.insert(21);
        arvore.insert(38);
        arvore.insert(18);
        arvore.insert(19);
        arvore.insert(39);
        arvore.insert(37);

        //act
        arvore.delete(37);

        //assert
        /* Arvore Binaria:

              30
           /       \
          19        38
         /  \         \
        18   21        39   */

        assertEquals(null, arvore.search(37));
        assertEquals(39, arvore.search(38).getRight().getValue()) ;
        assertEquals(null, arvore.search(38).getLeft());
    }

    @Test
    public void deletaComDoisFilhos() {
        //arrange
        /* Arvore Binaria:

              30
           /       \
          19        38
         /  \      /  \
        18   21   37   39   */

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(new Node(30));
        arvore.insert(21);
        arvore.insert(38);
        arvore.insert(18);
        arvore.insert(19);
        arvore.insert(39);
        arvore.insert(37);

        //act
        arvore.delete(38);

        //assert
        /* Arvore Binaria:

              30
           /       \
          19        39
         /  \       /
        18   21    37   */

        assertEquals(null, arvore.search(38));
        assertEquals(37, arvore.search(39).getLeft().getValue()) ;
        assertEquals(null, arvore.search(39).getRight());
    }

    @Test
    public void deletaComUmFilho() {
        //arrange
        /* Arvore Binaria:

              30
           /       \
          19        38
         /  \      /  \
        18   21   37   39   */

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(new Node(30));
        arvore.insert(21);
        arvore.insert(38);
        arvore.insert(18);
        arvore.insert(19);
        arvore.insert(39);
        arvore.insert(37);

        //act
        arvore.delete(38);
        arvore.delete(39);

        //assert
        /* Arvore Binaria:

              30
           /       \
          19        37
         /  \
        18   21      */

        assertEquals(null, arvore.search(39));
        assertEquals(null, arvore.search(37).getLeft()) ;
        assertEquals(null, arvore.search(37).getRight());
    }

}
