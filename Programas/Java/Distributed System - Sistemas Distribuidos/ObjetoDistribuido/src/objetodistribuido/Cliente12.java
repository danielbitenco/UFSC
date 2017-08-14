/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetodistribuido;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Cliente12 {

    public static void main(String[] args) {

        while (true) {
            try {
                Registry registro = LocateRegistry.getRegistry("127.0.0.1", 9807);

                Luluzinha lulu = (Luluzinha) registro.lookup("Joana");

                System.out.println("o peso de lulu é" + lulu.calculaPeso(22.2));
            } catch (RemoteException ex) {
                Logger.getLogger(Cliente12.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Cliente12.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
