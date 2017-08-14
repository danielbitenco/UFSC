/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI;

import java.net.InetSocketAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class AutenticaImpl extends UnicastRemoteObject  implements Autentica{

//    private String user;
//    private String pass;
//    
    public AutenticaImpl()throws RemoteException{
        
    }
    private String ServerIp = "224.0.0.1";
    private int ServerPort = 1010;
    //private String[] userLogin = {"abc","cbd","cbd"};
    private String[] userLogin = {"daniel"};
    private String[] passLogin = {"daniel"};

//    public AutenticaImpl(String user, String pass)throws RemoteException{
//        this.user = user;
//        this.pass = pass;
//    }
    
    @Override
    public InetSocketAddress  autentica(String user, String pass) throws RemoteException {
        
        if(Objects.equals(userLogin[0], user) && Objects.equals(passLogin[0], pass)){
            return new InetSocketAddress(ServerIp, ServerPort);
        }
        else
            return new InetSocketAddress("fail", 0);
    }
}
