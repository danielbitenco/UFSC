package collectionsjava;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionsJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Vector vec = new Vector();

        int TAMANHO_MAX = 100000;

        // ArrayList add
        long inicio = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        System.out.println("ArrayList \tAdd--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

        // LinkedList add
        inicio = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("linkedListt \tAdd--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);
        
        // Vector add
        inicio = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            vec.add(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Vector \t\tAdd--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);
        System.out.println("");

        /**
         * *************************************************
         */
        // ArrayList get
        inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("ArrayList \tGet--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (microsegundos) " + duracao / 1000);

        // LinkedList get
        inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("LinkedList \tGet--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (microsegundos) " + duracao / 1000);
        

        // Vector get
        inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vec.get(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Vector \t\tGet--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (microsegundos) " + duracao / 1000);
        System.out.println("");
        /**
         * *************************************************
         */
        // ArrayList remove
        inicio = System.nanoTime();
        for (int i = 9999; i >= 0; i--) {
            arrayList.remove(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("ArrayList \tRemove--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

        // LinkedList remove
        inicio = System.nanoTime();
        for (int i = 9999; i >= 0; i--) {
            linkedList.remove(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("LinkedList \tRemove--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

        // Vector remove
        inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vec.remove(i);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Vector \t\tRemove--> INICIO: " + inicio + " -->FIM: " + fim + " -->DURACAO (milisegundos) " + duracao / 1000 / 1000);

    }
}
