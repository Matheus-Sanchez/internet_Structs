package br.unifor.grafo.kruskal;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

class KruskalArestas
{
    Vector<HashSet<String>> arvores = new Vector<HashSet<String>>(); //conjunto de vertices
    TreeSet<Aresta> kruskalArestas = new TreeSet<Aresta>();

    public TreeSet<Aresta> getArestas()
    {
        return kruskalArestas;
    }
    HashSet<String> getArvore(String vertice)
    {
        for (HashSet<String> arvore : arvores) {
            if (arvore.contains(vertice)) {
                return arvore;
            }
        }
        return null;
    }

    /**
����� * A aresta a ser inserida tem dois v�rtices - v1 e v2.
����� * Temos um vetor que cont�m grupos de v�rtices (avores).
����� * Primeiro vamos verificar se v1 ou v2 existe em qualquer grupo
����� * Se nem v1 nem v2 existir em qualquer grupo
����� * Criamos um novo grupo que cont�m ambos os v�rtices.
����� * Se um dos v�rtices existe num grupo e o outro n�o,
����� * Adicionamos o v�rtice que n�o existe para o grupo do outro v�rtice
����� * Se ambos os v�rtices existir em diferentes grupos
����� * Fundimos os dois grupos em um
����� * Todos os cen�rios acima significa que a aresta � uma aresta de Kruskal v�lido
����� * Nesse cen�rio, vamos adicionar a aresta das arestas Kruskal
����� * No entanto, se ambos os v�rtices existir no mesmo grupo
����� * N�s n�o consideramos a aresta como uma vantagem Kruskal v�lida
     */
    public void insereAresta(Aresta aresta)
    {
        String v1 = aresta.getV1();
        String v2 = aresta.getV2();

        HashSet<String> arvoreA = getArvore(v1);
        HashSet<String> arvoreB = getArvore(v2);

        if (arvoreA == null) {
        	kruskalArestas.add(aresta);
            if (arvoreB == null) {
                HashSet<String> htNewVertexGroup = new HashSet<String>();
                htNewVertexGroup.add(v1);
                htNewVertexGroup.add(v2);
                arvores.add(htNewVertexGroup);
            }
            else {
                arvoreB.add(v1);        	
            }
        }
        else {
            if (arvoreB == null) {
                arvoreA.add(v2);
                kruskalArestas.add(aresta);
            }
            else if (arvoreA != arvoreB) {
                arvoreA.addAll(arvoreB);
                arvores.remove(arvoreB);
                kruskalArestas.add(aresta);
            }
        }
    }
}