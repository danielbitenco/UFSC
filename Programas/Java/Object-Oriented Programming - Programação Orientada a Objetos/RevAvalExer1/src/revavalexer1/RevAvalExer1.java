/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revavalexer1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class RevAvalExer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Integer> notas = getTodasNotas();
        
        qtdValoresLidosA(notas);
        pressAnyKeyToContinue();
        
        exibeValoresEmOrdemChegadaB(notas);
        pressAnyKeyToContinue();
        
        exibeValoresEmOrdemInversaChegadaC(notas);
        pressAnyKeyToContinue();
        
        somaDosValoresD(notas);
        pressAnyKeyToContinue();
        
        double media = mediaDosValoresE(notas);
        pressAnyKeyToContinue();
        
        acimaDaMediaF(notas,media);
        pressAnyKeyToContinue();
        
        abaixoSeteG(notas);
        pressAnyKeyToContinue();
        
        mensagemFinalH();
        pressAnyKeyToContinue();
        
        

    }

    static ArrayList<Integer> getTodasNotas() {
        Integer i;
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> notas = new ArrayList<Integer>();

        do {
            System.out.println("Digite um numero (-1 encerra): ");
            i = scan.nextInt();

            if (i != -1) {
                notas.add(i);
            }
        } while (i != -1);

        return notas;
    }

    static void qtdValoresLidosA(ArrayList<Integer> n) {
        System.out.println("Mostre a quantidade de valores que foram lidos");
        System.out.println("Foram lidos " + n.size());
        System.out.println("");
    }

    static void exibeValoresEmOrdemChegadaB(ArrayList<Integer> n) {
        System.out.println("Exibir todos os valores na ordem em que foram informados, um ao lado do outro");
        for (int x = 0; x < n.size(); x++) {
            System.out.print(n.get(x) + " | ");
        }
        System.out.println("");

    }

    static void exibeValoresEmOrdemInversaChegadaC(ArrayList<Integer> n) {
        System.out.println("Exiba todos os valores na ordem inversa à que foram informados, um abaixo do outro");
        for (int x = n.size() - 1; x >= 0; x--) {
            System.out.println(n.get(x));
        }
        System.out.println("");

    }

    static void somaDosValoresD(ArrayList<Integer> n) {
        System.out.println("Calcule e mostre a soma dos valores");
        double soma = 0;
        for (int x = 0; x < n.size(); x++) {
            soma += n.get(x);
        }
        System.out.println("Soma total eh: " + soma);
        System.out.println("");

    }

    static double mediaDosValoresE(ArrayList<Integer> n) {
        System.out.println("Calcule e mostre a média dos valores");
        double media = 0;
        for (int x = 0; x < n.size(); x++) {
            media += n.get(x);
        }

        System.out.println("A media eh: " + media/n.size());
        System.out.println("");

        return media/n.size();
    }

    static void acimaDaMediaF(ArrayList<Integer> n, double media) {
        System.out.println("Calcule e mostre a quantidade de valores acima da média calculada");

        for (int x = 0; x < n.size(); x++) {
            if (n.get(x) > media) {
                System.out.print(n.get(x) + " | ");
            }
        }
        System.out.println("");

    }

    static void abaixoSeteG(ArrayList<Integer> n) {
        System.out.println("Calcule e mostre a quantidade de valores abaixo de sete");

        for (int x = 0; x < n.size(); x++) {
            if (n.get(x) < 7) {
                System.out.print(n.get(x) + " | ");
            }
        }
        System.out.println("");

    }

    static void mensagemFinalH() {
        System.out.println("Até mais!!!!!!!!!");

    }

    static void pressAnyKeyToContinue() {
        System.out.println("Aperte qualquer tecla para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
