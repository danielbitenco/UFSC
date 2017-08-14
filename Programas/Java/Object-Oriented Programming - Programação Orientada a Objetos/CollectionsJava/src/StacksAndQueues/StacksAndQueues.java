/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Daniel
 */
public class StacksAndQueues {
    public static void main(String args[]) {

        Queue fila = new LinkedList();
        Stack pilha = new Stack();


        // Queue add
        long inicio = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            fila.add(i);
        }
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        System.out.println("Fila \tAdd--> INICIO: " + inicio + " -->FIM: " + fim +" -->DURACAO " + duracao + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

        // Stack push
        inicio = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            pilha.push(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Pilha \tAdd--> INICIO: " + inicio + " -->FIM: " + fim +" -->DURACAO " + duracao  + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);
        
        /**
         * *************************************************
         */
        // Queue remove
        inicio = System.nanoTime();
        for (int i = 9999; i >= 0; i--) {
            fila.remove();
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Fila \tRemove--> INICIO: " + inicio + " -->FIM: " + fim +" -->DURACAO " + duracao  + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

        // Stack pop
        inicio = System.nanoTime();
        for (int i = 9999; i >= 0; i--) {
            pilha.pop();
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Pilha \tRemove--> INICIO: " + inicio + " -->FIM: " + fim +" -->DURACAO " + duracao + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

       

    }
}
