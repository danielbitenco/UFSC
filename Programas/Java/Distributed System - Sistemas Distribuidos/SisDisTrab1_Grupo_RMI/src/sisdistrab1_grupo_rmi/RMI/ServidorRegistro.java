/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ServidorRegistro {
    
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(9807);
            System.out.println("Iniciando Servidor de Registro....");
            AutenticaImpl aut = new AutenticaImpl();
            
            //System.out.println("Registrando Objeto Aute");
            registro.rebind("Aut", aut);
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
