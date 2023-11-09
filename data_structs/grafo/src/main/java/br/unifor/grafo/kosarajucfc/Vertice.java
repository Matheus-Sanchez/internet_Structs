

package br.unifor.grafo.kosarajucfc;

/**
 *
 * @author Elizabeth Fortunato
 */
public class Vertice implements Comparable<Vertice> {
   
   String nome;
   boolean visitada = false; 

   
   public Vertice(final String argNome) {// construtor da classe
       nome = argNome;// inicializando o construtor como o atributo.
   }
   
   public void setNome(String newNome){
      nome = newNome;      
       
   }
   
   public String getNome(){
      return nome; 
   }
   
   public int compareTo(final Vertice argNo) {// método que compara se um no é igual a ele mesmo.
       if(argNo == this){// se o no for igual a ele mesmo entao
           
           return 0;// retorna 0
           
       }else{
           
           return -1;// retorna 1
      
       }   
   }
   
  public String toString(){//impressao do nome do vertice.
      return " "+nome;
  } 
}