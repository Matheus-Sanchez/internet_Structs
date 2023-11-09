package br.unifor.grafo.tad;

import java.util.List;

/**
 * 
 * @author armandocouto
 *
 */
public class GrafoMatriz extends Grafo implements GrafoTad {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	private int[][] matriz;

	/**
	 * 
	 */
	public GrafoMatriz() { super(); }

	/**
	 * @param aresta
	 * @param vertice
	 * @param ponderado
	 * @param representacao
	 * @param dirigido
	 */
	public GrafoMatriz(List<Aresta> aresta, Integer vertice, Boolean ponderado, Integer representacao, Boolean dirigido) {
		super(aresta, vertice, ponderado, representacao, dirigido);
	}
	
	@Override
	public void imprimir() {
		String retorno = "";
		for (int i = 0; i < this.getVertice(); i++) {
			for (int j = 0; j < this.getVertice(); j++) {
				retorno += this.matriz[i][j] + " ";
			}
			retorno += "\n";
		}
		System.out.println(retorno);
	}

	/**
	 * @return the matriz
	 */
	public int[][] getMatriz() {
		return matriz;
	}

	/**
	 * @param matriz the matriz to set
	 */
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
}