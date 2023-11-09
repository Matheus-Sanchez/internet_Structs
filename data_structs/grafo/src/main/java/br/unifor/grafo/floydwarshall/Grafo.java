package br.unifor.grafo.floydwarshall;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Grafo {
	int vertices = 0;
	int coluna = 0;
	int[][] matAdjacencia;
	boolean direcao;
	int arestas;

	static Scanner s = new Scanner(System.in);

	// CONSTRUTOR DO CRIAR MATRIZ, PASSANDO VERTICES E ARESTA E DIRIGIDO, CRIA A
	// MATRIZ E PEDE AS ARESTAS
	public Grafo(int vertices, int arestas, boolean direcao) {
		this.vertices = vertices;
		this.arestas = arestas;
		this.direcao = direcao;
		matAdjacencia = new int[vertices][vertices];
		CriarGrafo();
		
	}
	public void setGrafo(int i, int j, int valor) {
		this.matAdjacencia[i][j]=valor;
	}
	
	
	public void imprimir(){
		System.out.print("   ");
		for(int i=0;i<matAdjacencia.length;i++){
			System.out.print("V"+i+" ");
		}
		System.out.println();
		for(int i=0;i<matAdjacencia.length;i++){
			System.out.print("V"+i+" ");
			for(int j=0;j<matAdjacencia.length;j++){
				System.out.print(" "+matAdjacencia[i][j]+" ");	
			}
			System.out.println();	
		}
		System.out.println();
	}


	// CONSTRUTOR VAZIO PARA LER A MATRIZ DE UM TXT
	public Grafo() {
//		lerArquivo();
//		ConverterAdj();
	}

	// SELECIONA O TXT ARQUIVO PELO JFILECHOOSER
	public BufferedReader getArquivo() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FiltroFiles());
		int opcao = fc.showOpenDialog(null);
		try {
			if (opcao == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				FileReader fr = new FileReader(file);
				BufferedReader ler = new BufferedReader(fr);
				return ler;
			} else
				throw new FileNotFoundException(
						"Arquivo nao selecionado, escolha um TXT");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// LER O TXT
	public void lerArquivo() {
		BufferedReader leitor = getArquivo();
		try {
			int contadorLinha = 0;
			while (leitor.ready()) {
				String line = leitor.readLine();
				if (line != null) {
					if (++contadorLinha == 1) {
						matAdjacencia = new int[Integer.parseInt(line.trim())][Integer
								.parseInt(line.trim())];
					} else {
						String[] adjacencias = line.split(" ");
						for (int i = 0; i < adjacencias.length; i++) {
							matAdjacencia[contadorLinha - 2][i] = Integer
									.parseInt(adjacencias[i]);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PECORRE A MATRIZ ADJACENTE, IMPRIMINDO-A
	public void ImprimirAdjacencia() {
		for (int i = 0; i < matAdjacencia.length; i++) {
			for (int j = 0; j < matAdjacencia.length; j++) {
				System.out.printf(matAdjacencia[i][j] + "  ");
			}
			System.out.println();
		}
	}


	// VERIFICA SE EXISTE SIMETRIA NA MATRIZ ADJACENTE
	public boolean isDiridoAdjacencia() {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (i != j) {
					if (matAdjacencia[i][j] != matAdjacencia[j][i]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void CriarGrafo() {
			int x, y = 0;
			for (int i = 0; i < arestas; i++) {
				System.out.println("Escolha um vertice origem (0 a " + vertices
						+ "): ");
				x = s.nextInt();
				System.out.println("Escolha um vertice destino (0 a "
						+ vertices + "): ");
				y = s.nextInt();
				while (x == y) {
					System.out.println("Escolha um vertice destino (0 a "
							+ vertices + "): ");
					y = s.nextInt();
				}
				matAdjacencia[x][y] = 1;
				coluna++;

			}
			System.out.println();
			System.out.println("Matriz Inicial: ");
			System.out.println();
			imprimir();
			System.out.println();
		}
	

	// RETORNA A DIRECAO
	public boolean dirigido() {
		return direcao;
	}

	// RETORNA A QUANTIDADE DE VERTICES
	public void numVertices() {
		System.out.println("O grafo possui " + vertices);
	}

}
