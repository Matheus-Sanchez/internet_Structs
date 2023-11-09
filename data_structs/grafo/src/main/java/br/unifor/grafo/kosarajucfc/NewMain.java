package br.unifor.grafo.kosarajucfc;

/**
 *
 * @author Elizabeth Cristina
 */

public class NewMain {

public static void excucao(String[] args){
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");
        Vertice v5 = new Vertice("v5");
        Vertice v6 = new Vertice("v6");
        Vertice v7 = new Vertice("v7");
        Vertice v8 = new Vertice("v8");


     ListaAdjacencia a = new ListaAdjacencia ();

     a.adicionaAresta(v1, v2, 1);//e1
     a.adicionaAresta(v2, v3, 1);//e2
     a.adicionaAresta(v3, v4, 1);//e3
     a.adicionaAresta(v4, v3, 1);//e4
     a.adicionaAresta(v8, v4, 1);//e5
     a.adicionaAresta(v4, v8, 1);//e6
     a.adicionaAresta(v8, v7, 1);//e7
     a.adicionaAresta(v7, v6, 1);//e8
     a.adicionaAresta(v6, v7, 1);//e9
     a.adicionaAresta(v5, v6, 1);//e10
     a.adicionaAresta(v5, v1, 1);//e11
     a.adicionaAresta(v2, v5, 1);//e12

     System.out.println(a.obterTodasArestas().size());

    System.out.println("Lista de  Adjacencia  "+a);

    System.out.println("Lista de Vertices  "+a.toStringVertices());


     //Kosaraju
    Kosaraju k = new Kosaraju();
    k.retornaconjuntoResultado(a);

}

}
