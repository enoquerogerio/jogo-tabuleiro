/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author roger
 */
public class tabuleiro {

    static void preencherTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (i == 0 && j == 4) {
                    tabuleiro[i][j] = "F";
                } else if (i == 4 && j == 0) {
                    tabuleiro[i][j] = "J";
                } else {
                    tabuleiro[i][j] = (".");
                }
            }
        }
    }

    static void colocarBombas(String[][] tabuleiro) {
        Random random = new Random();
        int bombas = random.nextInt((3 - 2) + 1) + 2;
        for (int i = 1; i <= bombas; i++) {
            int x = random.nextInt(5);
            int y = random.nextInt((3 - 2) + 1) + 2;
            tabuleiro[x][y] = "B";
        }
    }

    static void colocarVida(String[][] tabuleiro) {
        Random random = new Random();
        boolean estado = true;
        int x = random.nextInt(5);
        int y = random.nextInt(5);
        do {
            if (tabuleiro[x][y].equals("B") != true && tabuleiro[x][y].equals("J") != true && tabuleiro[x][y].equals("F") != true){
                tabuleiro[x][y] = "P";
                estado = false;
            } else {
                x = random.nextInt(5);
                y = random.nextInt(5);
            }
        }while(estado);
    }

    static void jogar(String[][] tabuleiro, int vida/*, String letra*/) {
        int pote = 7; String caracter;
        boolean estado = true;
        Scanner leitor = new Scanner(System.in);
        String letra = "";
        int i = 4, j = 0;
        int k=4, m=0; 
        int movimentos=0;
        while(estado){
            System.out.println("Pote: " + pote);
            if(pote !=0){
                System.out.print("Faça seu movimento: ");
                letra = leitor.next(); 
            }
            letra = letra.toLowerCase();            
            switch(letra){
                case "w":
                    k--;
                    if(tabuleiro[k][m].equals("B") == true) {
                        tabuleiro[i][j] = ".";
                        i--;
                        tabuleiro[i][j] = "J";
                        pote--;
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê pisou na bomba!\n");
                        estado = false;
                    }else if(tabuleiro[k][m].equals("P") == true){
                        pote += vida;
                        tabuleiro[i][j] = ".";
                        i--;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                        movimentos++;
                    }else if(tabuleiro[k][m].equals("F") == true) {
                        movimentos++;
                        tabuleiro[i][j] = ".";
                        i--;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê não morreu. Hahahaha\n");
                        estado = false;
                    }else if(pote == 0){
                        System.out.println("\nVocê esgotou a tua vida!\n");
                        estado = false;
                    }else{
                        tabuleiro[i][j] = ".";
                        i--;
                        tabuleiro[i][j] = "J";
                        pote--;
                        movimentos++;
                        imprimirTabuleiro(tabuleiro);
                    }
                    break;
                case "s":
                    k++;
                    if(tabuleiro[k][m].equals("B") == true) {
                        tabuleiro[i][j] = ".";
                        i++;
                        tabuleiro[i][j] = "J";
                        pote--;
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê pisou na bomba!\n");
                        estado = false;
                    }else if(tabuleiro[k][m].equals("P") == true) {
                        movimentos++;
                        pote += vida;
                        tabuleiro[i][j] = ".";
                        i++;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                    }else if(tabuleiro[k][m].equals("F") == true){
                        movimentos++;
                        tabuleiro[i][j] = ".";
                        i++;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê não morreu. Hahahaha\n");
                        estado = false;
                    }else if (pote == 0){
                        System.out.println("\nVocê esgotou a tua vida!\n");
                        estado = false;
                    }else{
                        tabuleiro[i][j] = ".";
                        i++;
                        tabuleiro[i][j] = "J";
                        pote--;
                        movimentos++;
                        imprimirTabuleiro(tabuleiro);
                    }
                    break;
                case "a":
                    m--;
                    if (tabuleiro[k][m].equals("B") == true){
                        tabuleiro[i][j] = ".";
                        j--;
                        tabuleiro[i][j] = "J";
                        pote--;
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê pisou na bomba!\n");
                        estado = false;
                    }else if (tabuleiro[k][m].equals("P") == true){
                        movimentos++;
                        pote += vida;
                        tabuleiro[i][j] = ".";
                        j--;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                    }else if (tabuleiro[k][m].equals("F") == true) {
                        movimentos++;
                        tabuleiro[i][j] = ".";
                        j--;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê não morreu. Hahahaha\n");
                        estado = false;
                    }else if (pote == 0){
                        System.out.println("\nVocê esgotou a tua vida!\n");
                        estado = false;
                    }else {
                        tabuleiro[i][j] = ".";
                        j--;
                        tabuleiro[i][j] = "J";
                        pote--;
                        movimentos++;
                        imprimirTabuleiro(tabuleiro);
                    }            
                    break;
                case "d":
                    m++;
                    if (tabuleiro[k][m].equals("B") == true) {
                        tabuleiro[i][j] = ".";
                        j++;
                        tabuleiro[i][j] = "J";
                        pote--;
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê pisou na bomba!\n");
                        estado = false;
                    }else if (tabuleiro[k][m].equals("P") == true) {
                        pote += vida;
                        tabuleiro[i][j] = ".";
                        j++;
                        movimentos++;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                    }else if (tabuleiro[k][m].equals("F") == true){
                        movimentos++;
                        tabuleiro[i][j] = ".";
                        j++;
                        tabuleiro[i][j] = "J";
                        imprimirTabuleiro(tabuleiro);
                        System.out.println("\nVocê não morreu. Hahahaha\n");
                        estado = false;
                    }else if (pote == 0) {
                        System.out.println("\nVocê esgotou a tua vida!\n");
                        estado = false;
                    }else{
                        tabuleiro[i][j] = ".";
                        j++;
                        tabuleiro[i][j] = "J";
                        pote--;
                        movimentos++;
                        imprimirTabuleiro(tabuleiro);
                    }
                    break;
                default:
                    System.out.println("\nMovimento errado!\n");
            }
        }
    }

    public static void imprimirTabuleiro(String[][] tabuleiro) {
        System.out.println("O objetivo é mover-se (J) até ao ponto final (F).\nAo longo do caminho há bombas e podes pegar mais vidas (P) para alcançar a meta.");
        System.out.println("Use as seguintes letras para se mover no tabuleiro");
        System.out.println("W - Subir\nS - Descer\nA - Mover-se na esquerda\nD - Mover-se na direita\n");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j].equals("B") == true) {
                    System.out.print("." + "    ");
                } else {
                    System.out.print(tabuleiro[i][j] + "    ");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        Random random = new Random();
        String[][] tabuleiro = new String[5][5];
        int vida = random.nextInt((5 - 3) + 1) + 3;
        String opcao;
        boolean estado = true;
        
        
        do {
            System.out.println("\n1 - Jogar\n0 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.next();
            
            if(opcao.equals("1") == true){
                preencherTabuleiro(tabuleiro);
                colocarBombas(tabuleiro);
                colocarVida(tabuleiro);
                imprimirTabuleiro(tabuleiro);                
                jogar(tabuleiro, vida);
            }else if(opcao.equals("0") == true)
                estado = false;
        }while(estado);
    }


}
