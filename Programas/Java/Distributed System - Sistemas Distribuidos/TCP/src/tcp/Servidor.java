/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Servidor {

    
    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        
        try {
            servidor.iniciaServidor();
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        
    public void iniciaServidor() throws Exception {
        ServerSocket server = new ServerSocket(9898);
        
        System.out.println("iniciando Servidor");
        
        while(true){
            Socket conexao = server.accept();
            TrataConexao tc = new TrataConexao(conexao);
            tc.start();
        }
        
    }
    
    
}
