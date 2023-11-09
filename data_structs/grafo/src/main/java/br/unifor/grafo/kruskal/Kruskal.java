package br.unifor.grafo.kruskal;

import java.util.TreeSet;

public class Kruskal
{
    public static void main(String[] args)
    {
        //TreeSet � usado para classificar as arestas antes de passar para o algoritmo
        TreeSet<Aresta> arestas = new TreeSet<Aresta>();

        //Sample problem - replace these values with your problem set
        arestas.add(new Aresta("A", "B", 7)); 
        arestas.add(new Aresta("A", "D", 5)); 
        arestas.add(new Aresta("B", "D", 9)); 
        arestas.add(new Aresta("B", "C", 8)); 
        arestas.add(new Aresta("C", "E", 5)); 
        arestas.add(new Aresta("B", "E", 7)); 
        arestas.add(new Aresta("D", "E", 15));
        arestas.add(new Aresta("D", "F", 6));
        arestas.add(new Aresta("F", "E", 8));
        arestas.add(new Aresta("E", "G", 9));
        arestas.add(new Aresta("F", "G", 11));

        System.out.println("Grafo");
        KruskalArestas vv = new KruskalArestas();

        for (Aresta aresta : arestas) {
            System.out.println(aresta);
            vv.insereAresta(aresta);
        }

        System.out.println("Kruskal");
        int total = 0;
        for (Aresta aresta : vv.getArestas()) {
            System.out.println(aresta);
            total += aresta.getPeso();
        }
        System.out.println("Peso Total: " + total);
    }
}