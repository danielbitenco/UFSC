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
public class TrataConexao extends Thread{
    
    private Socket conexao;
    
    public TrataConexao(Socket c){
        this.conexao = c;
    }
    
    @Override
    public void run(){
        try {
            iniciaTratamento();
        } catch (Exception ex) {
            Logger.getLogger(TrataConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void iniciaTratamento() throws Exception{
        
        System.out.println("Conectado");

        ObjectInputStream input = new ObjectInputStream(conexao.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(conexao.getOutputStream());

        String dado = "oi";

        while(!dado.equalsIgnoreCase("FIM")){
            dado = (String) input.readObject();
            System.out.println("Dados do Canal " + dado);
            output.writeObject("Oi, eu sou o servidor");
            output.flush();
        }

      conexao.close();
    }

    
}
