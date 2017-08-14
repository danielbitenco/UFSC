/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI.Teste;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisdistrab1_grupo_rmi.RMI.Autentica;

/**
 *
 * @author Daniel
 */
public class Cliente2 {
    
    public static void main(String[] args) throws IOException {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 9807);
            Autentica aut = (Autentica) registro.lookup("Aut");

            InetSocketAddress endereco = aut.autentica("daniel", "daniel");
            //System.out.println("Conectando ao : "+ endereco.getHostString() + " " + endereco.getPort());

            if (Objects.equals("fail",endereco.getHostName()))
                System.out.println("Nao Conectado. Usuario ou senha invalidos");
            else{
                String ipGrupo = endereco.getAddress().getHostAddress();
                int portGrupo = endereco.getPort();
                System.out.println("Conectando ao endereco do grupo\nIP: "+ ipGrupo + " Porta: " + portGrupo );
                //TODO: conectar ao grupo
                
                MulticastSocket ms = new MulticastSocket(portGrupo);
        
                ms.joinGroup(InetAddress.getByName(ipGrupo));
        
//                boolean saida = false;
//                while(!saida){
                    byte[] buffer = new byte[1024];
                    buffer = new String("Ola grupo, sou o usuario 2 ").getBytes();
                    DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ipGrupo), portGrupo);
                    ms.send(pacote);
                    //System.out.println(buffer.toString());
                    
                                       
//                }
                ms.leaveGroup(InetAddress.getByName(ipGrupo));
                ms.close();

                 
            }


        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
