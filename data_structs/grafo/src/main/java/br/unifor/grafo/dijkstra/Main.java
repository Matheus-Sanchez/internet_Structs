package br.unifor.grafo.dijkstra;

import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	public static void main(String... args) throws VerticeException {
		
		int menuInicial;
		do {
			System.out.println("-------- MENU Dijkstra -----");
			System.out.println();
			System.out.println("Escolha uma opcao");
			System.out.println("1- Ler Arquivo");
			System.out.println("2- Criar Grafo");
			System.out.println("3- Sair");
			menuInicial = s.nextInt();

			switch (menuInicial) {
			case 1:
//				lerArquivo();
				break;

			case 2:
				  Grafo g = criaGrafo();

				  printVertices(g);
				  System.out.println();
				  printArestas(g);

				  Vertice v = g.getVertice(0);
				//  GrafoUtil.dethFirstSearch(v);

				  GrafoUtil.resetStatus(g);

				//  GrafoUtil.breathFirstSearch(v);

				  GrafoUtil.resetStatus(g);

				  GrafoUtil.dijkstra(v);
				  GrafoUtil.imprimeCaminhoMinimo(g);
				break;

			case 3:
				System.out.println("...");
				break;

			default:
				System.out.println("Opcao Invalida!");
			}
		} while (menuInicial != 3); 
	 

 }

	private static void printArestas(Grafo g) {
		System.out.println("Número de Arestas = " + g.numArestas());
		for (Aresta edge : g.arestas()) {
			System.out.println("Aresta: " + edge.getV1().getName() + " - "
					+ edge.getV2().getName() + ", peso: " + edge.getPeso());
		}
		System.out.println();
	}

	private static void printVertices(Grafo g) {
		System.out.println("Vertices = " + g.numVertices());
		for (Vertice vertex : g.vertices()) {
			System.out.print("Vertice:" + vertex.getName());
			System.out.print(" - Adjacentes");
			for (Vertice va : vertex.getAdjacentes()) {
				System.out.print(" - " + va.getName());
			}
			System.out.println();
		}
	}

	private static Grafo criaGrafo() throws VerticeException {
		Grafo g = new Grafo();
		System.out.println("Quantos vértices terá o grafo?");
		int qtd_vertices = s.nextInt();
		Vertice vertices[] = new Vertice[qtd_vertices];
		for (int i=0; i<qtd_vertices; i++) {
			vertices[i] = g.insereVertice(i, "V"+i);
		}
		
//		Vertice v0 = g.insereVertice(0, "V0");
//		Vertice v1 = g.insereVertice(1, "V1");
//		Vertice v2 = g.insereVertice(2, "V2");
//		Vertice v3 = g.insereVertice(3, "V3");
//		Vertice v4 = g.insereVertice(4, "V4");
//		Vertice v5 = g.insereVertice(5, "V5");
//		Vertice v6 = g.insereVertice(6, "V6");
		
		System.out.println("Quantos arestas terá o grafo?");
		int qtd_arestas = s.nextInt();
		for (int i = 0; i< qtd_arestas; i++) {
			System.out.println("Aresta - "+(i+1));
			System.out.println("Vértice Origem (0 a "+qtd_vertices+") :");
//			Vertice vo = new Vertice(i, s.nextInt()+"");
			int vertice_origem = s.nextInt();
			System.out.println("Vértice Destino (0 a "+qtd_vertices+") :");
			int vertice_destino = s.nextInt();
			System.out.println("Peso:");
			int peso = s.nextInt();
			g.insereAresta(vertices[vertice_origem], vertices[vertice_destino], peso);
		}
//		g.insereAresta(v0, v1, 2);
//		g.insereAresta(v0, v2, 3);
//		g.insereAresta(v0, v3, 4);
//		g.insereAresta(v1, v4, 7);
//		g.insereAresta(v1, v2, 1);
//		g.insereAresta(v2, v5, 9);
//		g.insereAresta(v2, v3, 2);
//		g.insereAresta(v3, v6, 1);
//		g.insereAresta(v4, v5, 2);
//		g.insereAresta(v5, v6, 2);
		return g;
	}

}
