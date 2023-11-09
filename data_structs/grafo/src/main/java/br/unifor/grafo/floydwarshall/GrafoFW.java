package br.unifor.grafo.floydwarshall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrafoFW {
	private int grafo[][];

	public GrafoFW(File matrizTxt) {
		if (matrizTxt != null) {
			try {
				int contLinha = 0;
				BufferedReader leitor = new BufferedReader(new FileReader(matrizTxt));
				while (leitor.ready()) {
					String line = leitor.readLine();
					if (line != null) {
						if (++contLinha == 1) {
							grafo = new int[Integer.parseInt(line.trim())][Integer.parseInt(line.trim())];
						} else {
							String[] adjacente = line.split(" ");
							for (int i=0; i<adjacente.length; i++) {
								grafo[contLinha-2][i] = Integer.parseInt(adjacente[i]);
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
	}
	
	public int Vertices(){
		return grafo.length;
	}
	public int getGrafo(int i, int j) {
		return grafo[i][j];
	}

	public void setGrafo(int i, int j, int valor) {
		this.grafo[i][j]=valor;
	}

	public void imprimir(){
		System.out.print("   ");
		for(int i=0;i<grafo.length;i++){
			System.out.print("V"+i+" ");
		}
		System.out.println();
		for(int i=0;i<grafo.length;i++){
			System.out.print("V"+i+" ");
			for(int j=0;j<grafo.length;j++){
				System.out.print(" "+grafo[i][j]+" ");	
			}
			System.out.println();	
		}
		System.out.println();
	}
	
}
