/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.Stack;



/**
 *
 * @author Daniel
 */
public class StackExemplo {
    public static void main(String[] args) {
        Stack pilha = new Stack();
        
        pilha.add("elemento 1");
        System.out.println(pilha);
        pilha.add("elemento 2");
        System.out.println(pilha);
        pilha.add("elemento 3");
        System.out.println(pilha);
        pilha.add("elemento 4");
        System.out.println(pilha);
        
        System.out.println("");
        
        System.out.println(pilha); //Fila Fist In First Out
        
        pilha.pop();    
        
        System.out.println(pilha);
        
        pilha.pop();    
        
        System.out.println(pilha);
        
        
        pilha.pop();    
        
        System.out.println(pilha);
        
        pilha.pop();    
        
        System.out.println(pilha);
    }
}
