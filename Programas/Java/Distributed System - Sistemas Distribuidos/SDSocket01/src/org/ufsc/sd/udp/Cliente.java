package org.ufsc.sd.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente extends Thread{

	public static void main(String[] args) {
		
		
		for(int i)
		Cliente cliente  = new Cliente();
		
		
		try {
			cliente.iniciaCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	
	public void run(){
		try {
			this.iniciaCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciaCliente() throws Exception{
		DatagramSocket sockt = new DatagramSocket();
		
		//criar um pacote
		
		byte[] buffer = new byte[1024];
		String dado = "OI";
		buffer = dado.getBytes();
		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 9875);
		System.out.println("Enviando");
		sockt.send(pacote);
		
	
		byte[] bufferOut = new byte[1024];
		buffer = dado.getBytes();
		DatagramPacket pacoteOut = new DatagramPacket(bufferOut, bufferOut.length, InetAddress.getByName("127.0.0.1"), 9875);

		
		sockt.receive(pacoteOut);
		System.out.println("Menssage Recebida "+pacoteOut.getData().toString());
		System.out.println("Info de Cabeçalho "+pacoteOut.getAddress().getHostName()+ " na porta " + pacoteOut.getPort());


	}

}
