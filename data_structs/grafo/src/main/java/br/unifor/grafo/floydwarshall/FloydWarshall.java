package br.unifor.grafo.floydwarshall;

import java.io.File;
import java.util.Scanner;

public class FloydWarshall {
	public FloydWarshall(){}
	public void iniciarFloydWarshall(Grafo grafo){
		Scanner s = new Scanner(System.in);
		//System.out.println("Nome do Arquivo:");			
		//GrafoFW grafo = new GrafoFW(new File ("res"+File.separator+s.nextLine()+".txt"));
		
		//Tres fors checando passando por todos vertices atras de uma aresta i a k passando pelo intermediario j, se tiver ele adiciona a areste
		for(int i=0;i<grafo.matAdjacencia.length;i++){
			for(int j=0;j<grafo.matAdjacencia.length;j++){
				if(i!=j){
					for(int k=0;k<grafo.matAdjacencia.length;k++){
						if(k!=j && k!=i){
							if(grafo.matAdjacencia[j][i] == 1 && grafo.matAdjacencia[i][k] == 1){
								if(grafo.matAdjacencia[j][k] == 0){
									/// Adiciona o vertice
									grafo.setGrafo(j, k, 1);
								}
							}
						}
					}
				}
			}
			
			System.out.println(+(i+1)+"a Iteração: \n");
			grafo.imprimir();
		}
	}
}
