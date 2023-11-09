package br.unifor.grafo.kruskal;
class Aresta implements Comparable<Aresta>
{
    String v1, v2;
    int peso;

    public Aresta(String v1, String v2, int peso)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }
    public String getV1()
    {
        return v1;
    }
    public String getV2()
    {
        return v2;
    }
    public int getPeso()
    {
        return peso;
    }
    @Override
    public String toString()
    {
        return "(" + v1 + ", " + v2 + ") : Peso = " + peso;
    }
    public int compareTo(Aresta aresta)
    {
    	//== N�o � comparada de forma que os valores duplicados n�o s�o eliminados.
    	return (this.peso < aresta.peso) ? -1: 1;
    }
}