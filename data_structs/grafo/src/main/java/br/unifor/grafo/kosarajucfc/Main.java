package br.unifor.grafo.kosarajucfc;

import java.util.Scanner;

public class Main {

public static void main(String[] args){
//	Scanner s = new Scanner(System.in);
//	int menuInicial;
//	do {
//		System.out.println("-------- MENU Kosaraju -----");
//		System.out.println();
//		System.out.println("Escolha uma opcao");
//		System.out.println("1- Criar Grafo");
//		System.out.println("2- Ler Arquivo");
//		System.out.println("3- Sair");
//		menuInicial = s.nextInt();
//		ListaAdjacencia a = new ListaAdjacencia ();
//		switch (menuInicial) {
//		case 1:
//			System.out.println("Quantos vértices terá o grafo?");
//			int qtd_vertices = s.nextInt();
//			Vertice vertices[] = new Vertice[qtd_vertices];
//			for (int i=0; i<qtd_vertices; i++) {
//				vertices[i] = new Vertice("v"+i);
//				System.out.println(vertices[i]+",");
//			}
//			
//			
//			System.out.println("Quantos arestas terá o grafo?");
//			int qtd_arestas = s.nextInt();
//			for (int i = 0; i< qtd_arestas; i++) {
//				System.out.println("Aresta - "+(i+1));
//				System.out.println("Vértice Origem (0 a "+qtd_vertices+") :");
////				Vertice vo = new Vertice(i, s.nextInt()+"");
//				int vertice_origem = s.nextInt();
//				System.out.println("Vértice Destino (0 a "+qtd_vertices+") :");
//				int vertice_destino = s.nextInt();
//				a.adicionaAresta(vertices[vertice_origem], vertices[vertice_destino], 1);
//				
//				  
//
//			}
//			
//			System.out.println("Lista de  Adjacencia  "+a.obterTodasArestas());
//
//		    System.out.println("Lista de Vertices  "+a.toStringVertices());
//		    
//			   //Kosaraju
//		    Kosaraju k = new Kosaraju();
//		    k.retornaconjuntoResultado(a);
//			
//			break;
//
//		case 2:
////			  lerArquivo();
//			break;
//
//		case 3:
//			System.out.println("...");
//			break;
//
//		default:
//			System.out.println("Opcao Invalida!");
//		}
//	} while (menuInicial != 3);
	
        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");
        Vertice v5 = new Vertice("v5");
        Vertice v6 = new Vertice("v6");
        Vertice v7 = new Vertice("v7");
//        Vertice v8 = new Vertice("v8");

     ListaAdjacencia a = new ListaAdjacencia ();

     a.adicionaAresta(v1, v4, 1);//e1
     a.adicionaAresta(v1, v5, 1);//e2
     a.adicionaAresta(v1, v3, 1);//e3
     a.adicionaAresta(v2, v5, 1);//e4
     a.adicionaAresta(v3, v7, 1);//e5
     a.adicionaAresta(v4, v2, 1);//e6
     a.adicionaAresta(v4, v3, 1);//e7
     a.adicionaAresta(v4, v5, 1);//e8
     a.adicionaAresta(v5, v7, 1);//e9
     a.adicionaAresta(v6, v4, 1);//e10
     a.adicionaAresta(v6, v7, 1);//e11
     a.adicionaAresta(v7, v2, 1);//e12
    System.out.println("Lista de  Adjacencia  "+a);

    System.out.println("Lista de Vertices  "+a.toStringVertices());


     //Kosaraju
    Kosaraju k = new Kosaraju();
    k.retornaconjuntoResultado(a);

}

}

