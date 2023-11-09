package br.unifor.grafo.dijkstra;
import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

 private List<Vertice> adjacentes = new ArrayList<Vertice>();

 private List<Aresta> arestas = new ArrayList<Aresta>();

 private Integer id;

 private String nome;

 private int dist = Integer.MAX_VALUE;

 private Vertice anterior;

 private String status = GrafoUtil.NAOVISITADO;

 public Vertice(Integer id, String name) {
  this.id = id;
  this.nome = name;
 }

 public int getGrau() {
  return this.adjacentes.size();
 }

 public List<Vertice> getAdjacentes() {
  return adjacentes;
 }

 public void setAdjacentes(List<Vertice> adjacents) {
  this.adjacentes = adjacents;
 }

 public void addAdjacentes(Vertice adjacents) {
  this.adjacentes.add(adjacents);
 }

 public List<Aresta> getArestas() {
  return arestas;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public Aresta insereAresta(Vertice w, Integer o) {
  Aresta e = new Aresta();
  e.setV1(this);
  e.setV2(w);
  e.setPeso(o);
  this.arestas.add(e);
  return e;
 }

 public Aresta insereAresta(Vertice w, Aresta e, Integer peso) {
  e.setV1(w);
  e.setV2(this);
  e.setPeso(peso);
  this.arestas.add(e);
  return e;
 }

 public void removeTodasArestas() {
  this.arestas = new ArrayList<Aresta>();
 }

 @Override
 public boolean equals(Object obj) {
  if (obj instanceof Vertice) {
   if (this.id.equals(((Vertice) obj).getId())) {
    return true;
   }
  }
  return false;
 }

 @Override
 public String toString() {
  return "(V�rtice ID:" + id + "-" + nome + ", grau:" + getGrau()
    + ")";
 }

 public int compareTo(Vertice other) {
  return Double.compare(dist, other.getDist());
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public int getDist() {
  return dist;
 }

 public void setDist(int dist) {
  this.dist = dist;
 }

 public Vertice getAnterior() {
  return anterior;
 }

 public void setAnterior(Vertice anterior) {
  this.anterior = anterior;
 }

 public String getName() {
  return nome;
 }

 public void setName(String nome) {
  this.nome = nome;
 }
}