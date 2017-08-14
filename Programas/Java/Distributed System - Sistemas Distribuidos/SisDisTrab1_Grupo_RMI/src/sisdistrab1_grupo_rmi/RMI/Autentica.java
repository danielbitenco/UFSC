/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI;

import java.net.InetSocketAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public interface Autentica extends Remote{
    
    InetSocketAddress  autentica(String user, String pass) throws RemoteException;
    
}
