/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetodistribuido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Daniel
 */
public class LuluzinhaImpl extends UnicastRemoteObject implements Luluzinha{
    
    public LuluzinhaImpl () throws RemoteException{
        
    }

    @Override
    public double calculaPeso(double a) throws RemoteException {
        System.out.println("Calculando o peso da Lulu" + (a+100));
        return a+100;
    }
    
}
