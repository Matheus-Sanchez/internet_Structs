package br.unifor.grafo.dijkstra;

public class Aresta {

 private Vertice v1;

 private Vertice v2;

 private Integer peso;

 private String status = GrafoUtil.NAOVISITADO;

 public Vertice getV1() {
  return v1;
 }

 public void setV1(Vertice v1) {
  this.v1 = v1;
 }

 public Vertice getV2() {
  return v2;
 }

 public void setV2(Vertice v2) {
  this.v2 = v2;
 }

 public Integer getPeso() {
  return peso;
 }

 public void setPeso(Integer peso) {
  this.peso = peso;
 }

 @Override
 public String toString() {
  return "Peso = " + peso;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }
}
