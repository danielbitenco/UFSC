/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuprimeirosoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class AtendeCliente extends Thread {

    private DatagramPacket dt;
    private DatagramSocket ds;

    public AtendeCliente( DatagramPacket dt, DatagramSocket ds) {
        setDt(dt);
        setDs(ds);
    }

    public void run() {
        byte[] buffer = new byte[1024];

        String teste = new String(dt.getData(), 0, dt.getLength());
        System.out.println(teste);
        byte[] bufferIn = new byte[1024];
        String dado = "Oi thread"+teste;
        bufferIn = dado.getBytes();

        DatagramPacket pacoteIn = new DatagramPacket(bufferIn, bufferIn.length, dt.getAddress(), dt.getPort());

        try {
            ds.send(pacoteIn);
        } catch (IOException ex) {
            Logger.getLogger(AtendeCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ds.close();

    }

    /**
     * @return the dt
     */
    public DatagramPacket getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(DatagramPacket dt) {
        this.dt = dt;
    }

    /**
     * @return the ds
     */
    public DatagramSocket getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DatagramSocket ds) {
        this.ds = ds;
    }

 

}
