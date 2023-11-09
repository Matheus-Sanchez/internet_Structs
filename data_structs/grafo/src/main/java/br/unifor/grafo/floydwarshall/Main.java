package br.unifor.grafo.floydwarshall;

import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	private static Grafo grafo;
	public static void main(String args[]) {
		
		//
		MenuPrinc();
	}
	public static void MenuPrinc() {
		int menuPrinc;
		do {
			System.out.println("-------- MENU Floyd-Warshall --------");
			System.out.println();
			System.out.println("1- Criar Grafo");
			System.out.println("2- Ler Grafo");
			System.out.println("3- Sair");
			menuPrinc = s.nextInt();

			switch (menuPrinc) {
			case 1:
				System.out.println();
				System.out.println("Quantidade de vertices: ");
				int vertices = s.nextInt();
				System.out.println("Quantidade de arestas: ");
				int arestas = s.nextInt();
				FloydWarshall fw = new FloydWarshall();
				Grafo grafo = new Grafo(vertices, arestas, false);
				fw.iniciarFloydWarshall(grafo);
				break;
			case 2: // LER MATRIZ
				System.out.println("Selecione a matriz: ");
				System.out.println();
//				grafo = new Grafo();
//				menuSec();
				break;
			case 3: System.out.println("...");
			break;
			default:
				System.out.println();
				System.out.println("Opcao Invalida!");
				// FIM DO SWITCH DO MENU PRINCIPAL
			}

			// SAIDA DO MENU PRINCIPAL
		} while (menuPrinc != 3);

	}
}
