package Cliente;


/**
 *
 * @author Daniel
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente{
    
    private int id;
    private File file;

    public static void main(String[] args) throws Exception {
        Cliente cli = new Cliente();
        
        cli.leArquivoEENvia();
        
        

    }
    
    
    public void leArquivoEENvia() throws Exception{
        int controle = 0;
        file = new File("C:\\Users\\Daniel\\Desktop\\UFSC\\2016 -2\\Sistemas Distribuidos\\UDP\\photo22.jpg");
        FileInputStream  fileIn = new FileInputStream(file);
        
      
        DatagramSocket socket = new DatagramSocket();

//        System.out.println(this.id);
        //criar um pacote
        byte[] buffer = new byte[1024];
        
        do{
        
            controle = fileIn.read(buffer);

            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 9875);
            System.out.println("Enviando");
            socket.send(pacote);

        }while(controle != -1);
        

        System.out.println("ENVIOU TODOS");
        
        
        byte[] endBuffer = new byte[1024];
        String dado = String.valueOf(controle);
        endBuffer = dado.getBytes();
        DatagramPacket pacote = new DatagramPacket(endBuffer, endBuffer.length, InetAddress.getByName("127.0.0.1"), 9875);
        System.out.println("Enviando");
        socket.send(pacote);

        
    }
    

}
