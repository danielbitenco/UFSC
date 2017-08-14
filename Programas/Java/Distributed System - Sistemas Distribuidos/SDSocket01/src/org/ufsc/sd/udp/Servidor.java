package org.ufsc.sd.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	
	
	public static void main(String[] args){
		Servidor servidor = new Servidor();
		
		try {
			servidor.iniciaServidor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciaServidor() throws Exception{
		System.out.println("iniciando servidor");
		DatagramSocket sockt = new DatagramSocket(9875);
		
		//criar um pacote
		while(true){
			byte[] buffer = new byte[1024];
			
			DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
			sockt.receive(pacote);
			System.out.println("recebeu");

		
			byte[] bufferIn = new byte[1024];
			String dado = "chegou e ja foi";
			bufferIn = dado.getBytes();
			
			DatagramPacket pacoteIn = new DatagramPacket(bufferIn, bufferIn.length, pacote.getAddress(), pacote.getPort());
	
			
			sockt.send(pacoteIn);
		}


	}
}
