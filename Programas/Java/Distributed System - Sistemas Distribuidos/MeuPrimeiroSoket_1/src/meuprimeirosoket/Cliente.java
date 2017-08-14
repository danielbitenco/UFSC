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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente extends Thread{
    
    private int id;

    public static void main(String[] args) {

        for (int i = 0; i < 50000; i++) {
            Cliente cliente = new Cliente(i);

            try {
                cliente.start();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    public Cliente(int id){
        this.setIdeee(id);
    }

    public void run() {
        try {
            this.iniciaCliente();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void iniciaCliente() throws Exception {
        DatagramSocket sockt = new DatagramSocket();

        System.out.println(this.id);
        //criar um pacote
        byte[] buffer = new byte[1024];
        String dado = String.valueOf(this.getId());
        buffer = dado.getBytes();
        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 9875);
        System.out.println("Enviando");
        sockt.send(pacote);

        byte[] bufferOut = new byte[1024];
        buffer = dado.getBytes();
        DatagramPacket pacoteOut = new DatagramPacket(bufferOut, bufferOut.length, InetAddress.getByName("127.0.0.1"), 9875);

        sockt.receive(pacoteOut);
        
        String teste = new String(pacoteOut.getData(),0,pacoteOut.getLength());

        System.out.println("Menssage Recebida " + teste);
        System.out.println("Info de Cabeçalho " + pacoteOut.getAddress().getHostName() + " na porta " + pacoteOut.getPort());

    }

    /**
     * @return the id
     */
    public int getIdeee() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setIdeee(int id) {
        this.id = id;
    }

}
