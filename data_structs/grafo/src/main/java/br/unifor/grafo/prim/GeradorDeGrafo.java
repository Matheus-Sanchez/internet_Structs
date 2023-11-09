package br.unifor.grafo.prim;
	
	import java.util.ArrayList;

	public class GeradorDeGrafo {
       
	        public GeradorDeGrafo(int tamanhoGrafo){
	
	                ArrayList<Vertice> conjuntoDeVertices = new ArrayList<Vertice>();
	               
	                for(int i=0; i< tamanhoGrafo; i++){
	                        Vertice v = new Vertice();
	                        conjuntoDeVertices.add(v);
	                }
	
	                Grafo G = new Grafo();
	                //G.setConjuntoDeVertices(conjuntoDeVertices);
	               
	        }
	       
	       
	       
	}