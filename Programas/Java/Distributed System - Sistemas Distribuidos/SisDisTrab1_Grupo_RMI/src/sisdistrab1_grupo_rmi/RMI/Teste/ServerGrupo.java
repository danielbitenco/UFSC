/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI.Teste;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Daniel
 */
public class ServerGrupo {
    
    public static void main(String[] args) throws Exception{
        MulticastSocket ms = new MulticastSocket(1010);

        ms.joinGroup(InetAddress.getByName("224.0.0.1"));


        boolean saida = false;

        byte[] buffer = new byte[1024];
        buffer = new String("Server do Grupo Online").getBytes();
        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("224.0.0.1"), 1010);
        ms.send(pacote);

        while(true){
            //if(id == 0){

            //}else{
                buffer = new byte[1024];
                pacote = new DatagramPacket(buffer, buffer.length,  InetAddress.getByName("224.0.0.1"), 1010);
                ms.receive(pacote);

                String teste = new String(pacote.getData(),0,pacote.getLength());
                System.out.println(teste);

            //}

            if (saida)
                break;
        }

        ms.leaveGroup(InetAddress.getByName("224.0.0.1"));
        ms.close();

    }
    
}
