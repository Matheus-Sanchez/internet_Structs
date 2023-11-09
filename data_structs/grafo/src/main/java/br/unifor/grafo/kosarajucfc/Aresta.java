package br.unifor.grafo.kosarajucfc;

/**
 *
 * @author Elizabeth Fortunato
 */
public class Aresta implements Comparable<Aresta>{
    //Comparable: impões ordenação total sobre cada classe que a implementá-la.
    //Objetos que implementam esta interface podem ser usadas como chaves em um mapa classificados ou elementos de um conjunto ordenado, sem a necessidade de especificar um comparador.


   
   final Vertice de, ate;//vertice de entrada e vertice de saida
   final int peso;
   
   public Aresta(final Vertice argDe, final Vertice argAte, final int argPeso){
       de = argDe;
       ate = argAte;
       peso = argPeso;
   }
   
   public int compareTo(final Aresta argAresta){
       return peso - argAresta.peso;// peso de uma aresta qualquer mesmos o peso da aresta argAresta.
   }
   
   public String toString(){
     return "( "+ de + " " +ate +" "+ peso+" )" ;  
       
   }
}
