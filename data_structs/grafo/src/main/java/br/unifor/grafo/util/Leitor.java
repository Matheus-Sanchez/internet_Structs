package br.unifor.grafo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.grafo.tad.Aresta;
import br.unifor.grafo.tad.Grafo;
import br.unifor.grafo.tad.GrafoLista;
import br.unifor.grafo.tad.GrafoMatriz;


public class Leitor {

	private Grafo grafo;
	private Boolean dirigido;
	private Boolean ponderado;
	private Integer representacao;
	private Integer vertice;
	private List<Aresta> arestas;

	public Leitor() {
		grafo = new Grafo();
		arestas = new ArrayList<Aresta>();
	}

	public Grafo captura(File file) throws IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(file));

		while (entrada.ready()) {
			String string = entrada.readLine();
			if (string.startsWith("D")) {
				if (string.contains("0"))
					dirigido = false;
				else
					dirigido = true;
			}
			if (string.startsWith("P")) {
				if (string.contains("0"))
					ponderado = false;
				else
					ponderado = true;
			}
			if (string.startsWith("R")) {
				if (string.contains("0"))
					representacao = 1;
				else
					representacao = 2;
			}
			if (string.startsWith("V")) {
				string = string.substring(2, string.length());
				vertice = Integer.parseInt(string);
			}
			if (string.startsWith("E")) {
				string = string.substring(3, string.length() - 1);
				String[] array = string.split(";");
				for (String aresta : array) {
					adicionaAresta(aresta);
				}
			}
		}
		criarGrafo();
		entrada.close();
		return grafo;
	}

	public void adicionaAresta(String string) {
		Aresta aresta = new Aresta();
		string = string.substring(1, string.length() - 1);
		String[] array = string.split(",");

		if (ponderado) {
			aresta.setV1(Integer.parseInt(array[0]) + 1);
			aresta.setV2(Integer.parseInt(array[1]) + 1);
			aresta.setPeso(Integer.parseInt(array[2]));
		} else {
			aresta.setV1(Integer.parseInt(array[0]) + 1);
			aresta.setV2(Integer.parseInt(array[1]) + 1);
		}
		arestas.add(aresta);
	}

	public void criarGrafo() {
		if (representacao == 1)
			grafo =  new GrafoMatriz(arestas, vertice, ponderado, representacao, dirigido); 
		else if (representacao == 2)
			grafo = new GrafoLista(arestas, vertice, ponderado, representacao, dirigido);
	}
}