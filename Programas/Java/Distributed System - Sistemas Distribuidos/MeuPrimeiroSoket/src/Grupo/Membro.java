/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Membro extends Thread {
  
    private int id;
    
    public Membro(int id){
        this.id = id;
    }
    
    public static void main(String[] args) {
        
        for (int x= 0; x<20; x++){
            try {
                Membro2 m = new Membro2(x);
                m.start();
                //m.join();
                
                if(x == 0)
                    sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Membro2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public void run(){
        try {
            iniciaMembro2();
        } catch (IOException ex) {
            Logger.getLogger(Membro2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Membro2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciaMembro2 () throws Exception{
        MulticastSocket ms = new MulticastSocket(9876);
        
        ms.joinGroup(InetAddress.getByName("224.0.0.1"));
        
        boolean saida = false;
        while(true){
            if(id == 0){
                byte[] buffer = new byte[1024];
                buffer = new String("Oi ").getBytes();
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("224.0.0.1"), 9876);
                ms.send(pacote);
            }else{
                byte[] buffer = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("224.0.0.1"), 9876);
                ms.receive(pacote);
                
                String teste = new String(pacote.getData(),0,pacote.getLength());
                System.out.println(teste +" "+ id);

            }
            
            
            
            
            if (saida)
                break;
        }
        
        ms.leaveGroup(InetAddress.getByName("224.0.0.1"));
        ms.close();
        
    }
    
}
