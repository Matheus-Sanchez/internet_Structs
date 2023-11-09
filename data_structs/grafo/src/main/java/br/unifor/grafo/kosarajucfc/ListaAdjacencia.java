package br.unifor.grafo.kosarajucfc;

import java.util.Map;// cria um objeto como se fosse uma tabela onde este possui um chave e valores. Cada chave pode possuir apenas um valor.SS
import java.util.HashMap;// filho de map, permitindo a criaçao de chave NULL e valores nulos. Ordem dos elementos nao interessa podendo remover,adicionar e excluir os valores.
import java.util.ArrayList;// lista de arrays onde seus dados sao acessados atraves de seu indice.
import java.util.List;// sequencia de elementos.  
import java.util.Set;// coleçao de dados que nao possui elementos duplicados. Quando temos dois elementos e1 e e2 e se faz: e1.equals(e2) só pode haver um elemento nulo.
import java.util.Collection;// "objeto que pode-se agrupar varios elementos". Ex: fila, lista, conjuntos, pilha.

/**
 *
 * @author Elizabeth Fortunato
 * */

public class ListaAdjacencia {

    List<Vertice> vertices = new ArrayList<Vertice>();// array list de vertices
    private Map<Vertice, List<Aresta>> adjacencia = new HashMap<Vertice, List<Aresta>>();// adjacencia possui um chave definida como NÒ e valor definido como "lista de arestas"
    private   List<Aresta> lista;//uma lista contendo "lista-> de arestas"
    private List<Aresta> arestas;//lista contém arestas.
    private  ListaAdjacencia novaLista;// lista que contém as arestas inversas.

    
   public void adicionaAresta(Vertice origem, Vertice destino, int peso){
       vertices.add(origem);// adiciona o vertice na lista de vertices.
       if(!adjacencia.containsKey(origem)){// se adjacencia nao possui essa chave ORIGEM
           lista = new ArrayList<Aresta>();// lista recebe um novo array list de arestas
           adjacencia.put(origem, lista);//adjacencia possui uma chave[origem] e valor[array list]
                      
       }else{
           lista = adjacencia.get(origem);// lista recebe o valor associado a origem ou seja um array list.
           adjacencia.put(destino,lista);//
       }
       lista.add(new Aresta(origem, destino, peso));// lista agora possui uma nova aresta
       
   }

   public List<Aresta> retornaAdjacencia(Vertice origem){
       return adjacencia.get(origem);// retorna o valor associado a chave[origem].O retorno é em forma de lista contendo[de, ]
   }
      public String toStringVertices(){
      return vertices.toString(); 
   }

   public void reverteAresta(Aresta e){
       adjacencia.get(e.de).remove(e);//retorna os valores associados a aresta que contem [de] e remove essa aresta
       adicionaAresta(e.ate, e.de, e.peso);// cria uma nova aresta invertendo os campos[ate <-de][de<-ate]
   }

   public void reverteGrafo(){
       adjacencia = obterListaReversa().adjacencia;//adjacencia recebe ela mesma invertida.
   }

   public ListaAdjacencia obterListaReversa(){
    novaLista = new ListaAdjacencia();// cria um novo objeto to tipo desta classe 
       for(List<Aresta> arestas : adjacencia.values()){//aresta é o tipo do conjunteo e adjacencis é o proprio conjunto.
           for(Aresta e : arestas){//e é o tipo do conjunto e arestas é o conjunto
               novaLista.adicionaAresta(e.ate, e.de, e.peso);// nova lista recebe as arestas
           }
       }
       return novaLista;
   }
   
   public String toString(){  

       return adjacencia.toString();
       
   }
   

   public Set<Vertice> obterConjuntoNoOrigem(){// retorna um conjunto         
       
       return adjacencia.keySet();//retorna um conjunto de chaves contidas em adjacencia  
       
   }

   public Collection<Aresta> obterTodasArestas(){//retorna uma coleçao
        arestas = new ArrayList<Aresta>();//cria um novo array list que armazenara as arestas
       for(List<Aresta> e : adjacencia.values()){//percorrre todos os valores de adjacencia onde List<Aresta> é seu tipo
           arestas.addAll(e);// acrescenta todas dos objetos e em aresta.
       }
       return arestas;// retorna uma colecao de dados.
   }
 
   public String toStringArestas(){       
   
       return arestas.toString();

   }
   
}