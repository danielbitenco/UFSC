/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Daniel
 */
public class QueueExemplo {
    public static void main(String[] args) {
        Queue fila = new LinkedList();
        
        fila.add("elemento 1");
        System.out.println(fila);
        fila.add("elemento 2");
        System.out.println(fila);
        fila.add("elemento 3");
        System.out.println(fila);
        fila.add("elemento 4");
        System.out.println(fila);
        
        System.out.println("");
        
        System.out.println(fila); //Fila Fist In First Out
        fila.remove();
        
        System.out.println(fila);
        fila.remove();
        
        System.out.println(fila);
        fila.remove();
        
        System.out.println(fila);
        fila.remove();
        
        System.out.println(fila);
        
    }
}
