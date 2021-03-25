package com.estrutura2;

import java.util.*;

public class Rotas {

    List<Node> nodes;
    List<Edge> edges;

    public Rotas() {
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }

    public static class Node{

        String abv;
        int timeZone;
        int x;
        int y;
        String desc;
        List<Edge> adj;

        public Node(String abv, int timeZone, int x, int y, String desc) {
            this.abv = abv;
            this.timeZone = timeZone;
            this.x = x;
            this.y = y;
            this.adj = new ArrayList<Edge>();
        }

        void addAdj(Edge e){
            adj.add(e);
        }

    }

    public static class Edge{

        Node origem, destino;

        public Edge(Node origem, Node destino) {
            this.origem = origem;
            this.destino = destino;
        }
    }

    public Node addNode(String abv, int timeZone, int x, int y, String desc){
        Node newNode = new Node(abv,timeZone,x,y,desc);
        nodes.add(newNode);
        return newNode;
    }

    public Edge addEdge(Node origem, Node destino){
        Edge newEdge = new Edge(origem, destino);
        origem.addAdj(newEdge);
        edges.add(newEdge);
        return newEdge;
    }

    public String printGraph(){

        int i = 0, j = 0;

        for (i = 0; i < this.nodes.size(); i++){
            System.out.println("Código de Origem: "+ this.nodes.get(i).abv);
            System.out.println("Timezone: "+ this.nodes.get(i).timeZone);
            System.out.println("X: "+ this.nodes.get(i).x);
            System.out.println("Y: "+ this.nodes.get(i).y);
            //System.out.println("Description: "+this.nodes.get(i).desc);
            System.out.println("______________");

            for(j = 0; j < this.nodes.get(i).adj.size(); j++){
                System.out.println("\t\tCodigo de Destino: "+this.nodes.get(i).adj.get(j).destino.abv);
                System.out.println("\t\tTimezone: "+this.nodes.get(i).adj.get(j).destino.timeZone);
                System.out.println("\t\tX: "+this.nodes.get(i).adj.get(j).destino.x);
                System.out.println("\t\tY: "+this.nodes.get(i).adj.get(j).destino.y);
                //System.out.println("\t\tDescription: "+this.nodes.get(i).adj.get(j).destino.desc);
                System.out.println("__________________________");
            }

        }
        return null;
    }

    public int find(String abv){

        int found = 0;

        for (int i = 0; i < this.nodes.size(); i++){
            if(this.nodes.get(i).abv.equals(abv)){
                return i;
            }
        }
        return 0;
    }

    public void numero1(int pos){
        System.out.println("Código de Origem: "+ this.nodes.get(pos).abv);
        System.out.println("Timezone: "+ this.nodes.get(pos).timeZone);
        System.out.println("X: "+ this.nodes.get(pos).x);
        System.out.println("Y: "+ this.nodes.get(pos).y);
        System.out.println("______________");

        System.out.println("Partindo de '"+this.nodes.get(pos).abv+"' podemos ir para:");
        for(int j = 0; j < this.nodes.get(pos).adj.size(); j++){
            System.out.println("\t\tCodigo de Destino: "+this.nodes.get(pos).adj.get(j).destino.abv);
            System.out.println("\t\tTimezone: "+this.nodes.get(pos).adj.get(j).destino.timeZone);
            System.out.println("\t\tX: "+this.nodes.get(pos).adj.get(j).destino.x);
            System.out.println("\t\tY: "+this.nodes.get(pos).adj.get(j).destino.y);
            System.out.println("__________________________");
        }
    }

    public void numero2(String abv){

        System.out.println("Os aeroportos que dão rota ao aeroporto '"+abv+"' são:");
        for(int i = 0; i < this.nodes.size(); i++){
            for (int j = 0; j < this.nodes.get(i).adj.size(); j++){
                if (this.nodes.get(i).adj.get(j).destino.abv.equals(abv)){
                    System.out.println(this.nodes.get(i).adj.get(j).origem.abv);
                }
            }
        }
    }

    public void numero3(int pos){

        System.out.println("O aeroporto '"+this.nodes.get(pos).abv+"' tem vôo direto para:");
        System.out.println("______________");

        for(int j = 0; j < this.nodes.get(pos).adj.size(); j++){
            System.out.println("\t\tCodigo de Destino: "+this.nodes.get(pos).adj.get(j).destino.abv);
            System.out.println("\t\tTimezone: "+this.nodes.get(pos).adj.get(j).destino.timeZone);
            System.out.println("\t\tX: "+this.nodes.get(pos).adj.get(j).destino.x);
            System.out.println("\t\tY: "+this.nodes.get(pos).adj.get(j).destino.y);
            System.out.println("__________________________");
        }
    }
}