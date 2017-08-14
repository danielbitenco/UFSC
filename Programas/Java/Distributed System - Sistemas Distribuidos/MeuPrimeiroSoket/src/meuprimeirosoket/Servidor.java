/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuprimeirosoket;

/**
 *
 * @author Daniel
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor extends Thread{

    public static void main(String[] args) {
        Servidor servidor = new Servidor();

        try {
            servidor.iniciaServidor();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void iniciaServidor() throws Exception {
        System.out.println("iniciando servidor");
        DatagramSocket sockt = new DatagramSocket(9875);

        //criar um pacote
        while (true) {

            byte[] buffer = new byte[1024];

            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            sockt.receive(pacote);

            AtendeCliente at = new AtendeCliente(sockt, pacote);
            at.start();
            at.join();

        }

    }
}
