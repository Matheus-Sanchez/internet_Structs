package br.unifor.grafo.dijkstra;

public class VerticeException extends Exception {

 private static final long serialVersionUID = 4195477243645994918L;

 public static String ID_DUPLICADO = "ID_DUPLICADO";

 public static String ID_NAO_EXISTE = "ID_NAO_EXISTE";

 public VerticeException(String ex, Object value) {
  if (ID_DUPLICADO.equals(ex)) {
   System.out.println("Error: Vértice ID " + value
     + " duplicado Exception.");
  } else if (ID_NAO_EXISTE.equals(ex)) {
   System.out.println("Error: ID não existe Exception.");
  } else {
   System.out.println("Error: Vértice Exception");
  }
 }
}
