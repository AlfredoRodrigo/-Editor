/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Alfredo Silva
 */
public class Conexao {

    private String ip;
    private int porta; //nome do host (ipconfig /all)
    private String name;
    private String mensagem;
    
    public Conexao(String ip, int porta, String nome) {
        this.ip = ip;
        this.porta = porta;
        this.name = nome;
        new Thread(new Recebe()).start();
    }
    
    class Recebe implements Runnable {

        byte[] dadosReceber = new byte[255];
        boolean erro = false;
        DatagramSocket socket = null;

        @Override
        public void run() {
            while (true) {
                try {
                    socket = new DatagramSocket(getPorta());
                } catch (SocketException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }
                erro = false;
                while (!erro) {
                    DatagramPacket pacoteRecebido = new DatagramPacket(dadosReceber, dadosReceber.length);
                    try {
                        socket.receive(pacoteRecebido);
                        byte[] b = pacoteRecebido.getData();
                        String msg = "";
                        for (int i = 0; i < b.length; i++) {
                            if (b[i] != 0) {
                                msg += (char) b[i];
                            }
                        }
                        InitSection.getInstancia().getPagina().setText(InitSection.getInstancia().getPagina().getText() + msg);
                    } catch (Exception e) {
                        System.out.println("erro");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        erro = true;
                    }
                }
            }
        }
    }
    
    class Envia implements Runnable {

        String texto;

        public Envia(String texto) {
            this.texto = texto;
        }

        @Override
        public void run() {

            byte[] dados = texto.getBytes();

            try {
                DatagramSocket clientSocket = new DatagramSocket();
                InetAddress addr = InetAddress.getByName(getIp());
                DatagramPacket pacote = new DatagramPacket(dados, dados.length, addr, getPorta());
                clientSocket.send(pacote);
                clientSocket.close();
            } catch (SocketException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getPorta() {
        return porta;
    }

    public String getIp() {
        return ip;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
    public void notifica(String mensagem) {
        this.mensagem = mensagem;
        //notificar observadores
        //notifyObservers();
    }
    
    public void envia(String texto) {
        new Thread(new Envia(texto)).start();
    }
    
}
