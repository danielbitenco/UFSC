/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisdistrab1_grupo_rmi.RMI;

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
public class Cliente extends Thread {

    private int id;

    public static void main(String[] args) throws IOException {
        
        for (int x = 0; x < 5; x++) {
            try {
                Cliente m = new Cliente(x);
                m.start();
                //m.join();

                if (x == 0) {
                    sleep(500);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Cliente(int id) {
        this.id = id;
    }

    public void run() {
        try {
            autenticaCliente();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void autenticaCliente() throws Exception {

        Registry registro = LocateRegistry.getRegistry("127.0.0.1", 9807);
        Autentica aut = (Autentica) registro.lookup("Aut");

        InetSocketAddress endereco = aut.autentica("daniel", "daniel");
        //System.out.println("Conectando ao : "+ endereco.getHostString() + " " + endereco.getPort());

        if (Objects.equals("fail", endereco.getHostName())) {
            System.out.println("Nao Conectado. Usuario ou senha invalidos");
        } else {
            conectaGrupo(endereco);
        }

    }

    public void conectaGrupo(InetSocketAddress endereco) throws IOException {

        String ipGrupo = endereco.getAddress().getHostAddress();
        int portGrupo = endereco.getPort();
        System.out.println("Cliente " + this.id + "conectando ao endereco do grupo\nIP: " + ipGrupo + " Porta: " + portGrupo);
        //TODO: conectar ao grupo

        MulticastSocket ms = new MulticastSocket(portGrupo);

        ms.joinGroup(InetAddress.getByName(ipGrupo));

//                boolean saida = false;
//                while(!saida){
        byte[] buffer = new byte[1024];
        buffer = new String("Ola grupo, sou o usuario " + this.id).getBytes();
        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ipGrupo), portGrupo);
        ms.send(pacote);
        
       while(true){
           byte[] bufferReceive = new byte[1024];
       
            DatagramPacket pacoteReceive = new DatagramPacket(bufferReceive, bufferReceive.length, InetAddress.getByName(ipGrupo), portGrupo);
            ms.receive(pacoteReceive);

            String teste = new String(pacoteReceive.getData(),0,pacoteReceive.getLength());
            System.out.println(teste);
       }
        //System.out.println(buffer.toString());

//                }
        //ms.leaveGroup(InetAddress.getByName(ipGrupo));
        //ms.close();
    }

}
