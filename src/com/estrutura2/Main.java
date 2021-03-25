package com.estrutura2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int tam = 0, x = 0, y = 0, timeZone = 0, op = -1, pos0 = 0, pos1 = 0;
        String city = "", word0 = "", word1 = "", desc = "";
        File myObj = new File("voo.txt");
        Scanner scan0 = null, scan1 = null;
        Rotas newRotas = new Rotas();
        ArrayList<Airplane> planes = new ArrayList<>();

        try {
            scan0 = new Scanner(myObj);
            if (myObj.exists()) {
                tam = scan0.nextInt();
                for (int i = 0; i < tam; i++) {
                    city = scan0.next();
                    timeZone = scan0.nextInt();
                    x = scan0.nextInt();
                    y = scan0.nextInt();
                    //desc = scan0.nextLine();
                    newRotas.addNode(city, timeZone, x, y, desc);
                }
            }
            while (true) {

                word0 = scan0.next();
                if (word0.equals("!")) {
                    break;
                } else {
                    word1 = scan0.next();
                    pos0 = newRotas.find(word0);
                    pos1 = newRotas.find(word1);
                    newRotas.addEdge(newRotas.nodes.get(pos0), newRotas.nodes.get(pos1));
                }
            }
            //newGraph.printGraph();

            while(true){

                word0 = scan0.next();
                if(word0.equals("#")){
                    break;
                }
                word1 = scan0.next();
                planes.add(new Airplane(word0,word1));
            }

            //String list = planes.toString();
            //System.out.println("String "+list);

        } catch (FileNotFoundException e) {//escaneando arquivo texto e montando o grafo
            e.printStackTrace();
        }

        /*
        a) mostrar a possibilidade de voos dados dois aeroportos;
        b) dado um voo e mostrar a rota possível para o mesmo;
        c) mostrar, a partir de um aeroporto definido, quais os voos diretos (sem escalas e/ou
        conexões) que partem dele e a lista desses destinos;
        d) Dados uma origem e um destino, desenvolver um algoritmo para determinar a viagem com
        menor custo em termos de: distância total a percorrer e tempo de voo.
        e) Desenvolver um algoritmo para determinar se é possível, a partir de um aeroporto qualquer
        atingir qualquer outro (ou se será necessário em alguns casos fazer troca de aeroporto) e quais
        os aeroportos que, se ficassem fora de serviço (apenas um de cada vez), impediriam essa
        situação.
        f) Partindo de um aeroporto selecionado definir uma rota que consiga passar por todos os
        aeroportos com um tempo de voo mínimo.
        */

        while (op != 0) {
            System.out.println("-------MENU-------");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Mostrar possibilidade de vôos dados dois aeroportos");
            System.out.println("2 - Dado um vôo, mostra as rotas possíveis para o mesmo");
            System.out.println("3 - Mostrar, a partir de uma aeroporto definido, quais os voos diretos que partem dele \n" +
                    "e a lista desses destinos");
            System.out.println("4 - Dados uma origem e um destino, desenvolver um algoritmo para determinar a viagem com\n" +
                    "menor custo em termos de: distância total a percorrer e tempo de voo.");
            System.out.println("5 - Desenvolver um algoritmo para determinar se é possível, a partir de um aeroporto\n " +
                    "qualquer atingir qualquer outro (ou se será necessário em alguns casos fazer troca de aeroporto)\n" +
                    "e quais os aeroportos que, se ficassem fora de serviço (apenas um de cada vez), impediriam essa\n" +
                    "situação.");
            System.out.println("6 - Partindo de um aeroporto selecionado definir uma rota que consiga passar por \n" +
                    "todos os aeroportos com um tempo de voo mínimo.");
            scan1 = new Scanner(System.in);
            op = scan1.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Insira o primeiro aeroporto");
                    word0 = scan1.next();
                    System.out.println("Insira o segundo aeroporto");
                    word1 = scan1.next();
                    pos0 = newRotas.find(word0);
                    pos1 = newRotas.find(word1);
                    newRotas.numero1(pos0);
                    newRotas.numero1(pos1);
                    break;
                case 2:
                    System.out.println("Insira o aeroporto");
                    word0 = scan1.next();
                    newRotas.numero2(word0);
                    //comparar todas as opções destino cujas quais correspondem a SFO, marcar posições, printar todas as posições
                    break;
                case 3:
                    System.out.println("Insira o aeroporto");
                    word0 = scan1.next();
                    pos0 = newRotas.find(word0);
                    newRotas.numero3(pos0);
                    break;
                case 4:
                    System.out.println("Insira a origem");
                    System.out.println("Insira o destino");
                    break;
                case 5:
                    System.out.println("Inserir algoritmo que verifica se qualquer nó é alcançavel a partir de outro");
                    break;
                case 6:
                    System.out.println("Insira o aeroporto");
                    break;
                default:
                    System.out.println("Finalizado");
                    break;
            }
        }
    }
}