/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel
 */
public class Cliente  extends Thread {
    
    private int id;
    
    public static void main(String[] args) {
        

        for(int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(i);
            cliente.start();
        }
        
    }
    
    public Cliente(int id){
        this.id = id;
    }

    public void run() {
        try {
            this.iniciaCliente();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void iniciaCliente() throws Exception{
        
        Socket conexao = new Socket("127.0.0.1", 9898);
        System.out.println("Conectado ao servidor");
        
        
        ObjectOutputStream output = new ObjectOutputStream(conexao.getOutputStream());
        //output.writeObject("Oi, eu sou o cliente ");
        //output.flush();
                
        ObjectInputStream input = new ObjectInputStream(conexao.getInputStream());
        //System.out.println("Dados do Canal "+input.readObject());
        
        
        
        String dado = "oi";
        while(!dado.equalsIgnoreCase("FIM")){
            output.writeObject("Oi, eu sou o Cliente" + String.valueOf(this.id));
            output.flush();

            dado = (String) input.readObject();
            System.out.println("Dados do Canal " + dado);
        }

        
        
        conexao.close();        
    }
    
}
