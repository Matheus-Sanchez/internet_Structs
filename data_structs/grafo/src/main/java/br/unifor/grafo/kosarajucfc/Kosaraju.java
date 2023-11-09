package br.unifor.grafo.kosarajucfc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Elizabeth Cristina
 */
public class Kosaraju {

    private ArrayList<Vertice> pilha;// cria um array list sendo este a pilha. A pilha é do tipo nó(possuindo um nome). Pilha neste caso é um atributo privado.

    public ArrayList<ArrayList<Vertice>> retornaconjuntoResultado(ListaAdjacencia lista) {// métod retorna um array list de array list do tipo de no.

        pilha = new ArrayList<Vertice>();//pilha de vértices.

        ArrayList<ArrayList<Vertice>> SCC = new ArrayList<ArrayList<Vertice>>();

        //for (int i = 0; i < lista.vertices.size(); i++) {// esse for percorre a lista de vertice e retorna todos os vertices para serem utili
        
        pesquisa(lista.vertices.get(0), lista, true);// Busca o gráfico (busca em profundidade), adicionar nós à pilha
        
        lista.reverteGrafo();//  Inverte todas as arestas do grafo.

        while (!pilha.isEmpty()) {// enquanto nao for vazia.

            ArrayList<Vertice> component = new ArrayList<Vertice>();// component agora é um arrayList.

            // Busca o gráfico novamente na pilha de pedidos
            pesquisa(pilha.get(0), lista, false);//método pesquisa agora possui como parameto(elemento que esta no indice 0 da pilha, lista e proximo = false).

            Iterator<Vertice> it = pilha.iterator();// constroi um iterador para percorrer a pilha.
            for (pilha.iterator(); it.hasNext(); ) {// enquanto haver uma um proximo na pilha

                Vertice n = it.next();//retorna o proximo elemento da interaçao.

                if (!n.visitada) {// se n foi visitado
                    component.add(n);// componente recebe vertice.
                    it.remove();// remove n da pilha.

                }
            }

            if (!SCC.contains(component))// retorna true se a lista contem o COMPONENT
            //  Adiciona o componente para o conjunto de resultados
            SCC.add(component);// conjunto resultado é um arrayList onde este armazena component.
       }// fim do while.

       // }// fim for

        System.out.println("Os componentes fortemente conexos são: " + SCC);
        return SCC;
    }// fim kosaraju

    private void pesquisa(Vertice raiz, ListaAdjacencia lista, boolean proximo) {// busca de profundidade.

        raiz.visitada = proximo;// raiz visitida recebe o valor de proximo.

        if (lista.retornaAdjacencia(raiz) == null) {// retorna os valores associdos a raiz[nesse caso é a chave] . Se esse valor for null entao
            if (proximo) {// se proximo for true
                pilha.add(0, raiz);// se proximo for verdadeiro true pilha na posicaçao 0 recebe a raiz(nó).
            }
        }
        for (Aresta e : lista.retornaAdjacencia(raiz)) {// O for irá percorrer todos esses elementos.
            if (e.ate.visitada != proximo) {//se o no ate[destino] for diferente de proximoS
                pesquisa(e.ate, lista, proximo);// método pesquisa possui como raiz = ate, lista = lista e proximo = proximo.
            }
        }
        if (proximo) {
            pilha.add(0, raiz);// se proximo==true pilha na posiçao 0 recebe raiz.
        }
    }


}
