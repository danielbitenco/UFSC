/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author Daniel
 */
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor  {

    public static void main(String[] args) throws Exception {
        Servidor servidor = new Servidor();

        try {
            servidor.iniciaServidor();
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciaServidor() throws Exception {
        System.out.println("iniciando servidor");
        DatagramSocket socket = new DatagramSocket(9875);
        File file = new File("C:\\Users\\Daniel\\Desktop\\UFSC\\2016 -2\\Sistemas Distribuidos\\UDP\\recebido22.jpg");
        FileOutputStream fos = new FileOutputStream(file); //Cria um fluxo de escrita de dados no sistema de arquivos.


        String teste = "";

        //criar um pacote
        while (true) {

            while(true){
                
                byte[] buffer = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                socket.receive(pacote);

                teste = new String(pacote.getData(), 0, pacote.getLength());
                if(!teste.equals("-1")){
                    fos.write(pacote.getData(), 0, pacote.getData().length); // Escreve no arquivo refenciado, os dados provenientes do pacote enviado pela rede.
                    fos.flush(); // Descarrega os dados no arquivo.
                }else
                    break;

            };
            
            System.out.println("RECEBIDO");
            fos.close();///Fecha o fluxo de dados, quando acabar o envio de dados.
            System.out.println("RECEBIDO");

        }

    }
}
