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
import java.net.Socket;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Alfredo Silva
 */
public class Conexao {

    private Socket cliente;
    private String host; //nome do host (ipconfig /all)
    private int porta;
    private String nome;
    
    public Conexao(String host, int porta, String nome) {
        this.host = host;
        this.porta = porta;
        this.nome = nome;
    }
    
    public Serializable recebeConteudoPagina() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        return (Serializable)entrada.readObject();
    }
    
    public void enviaConteudoPagina(StyledDocument styledDocument) throws IOException {
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.flush();
        saida.writeObject(styledDocument);
        saida.flush();
    }
    
    public String getHost() {
        return this.host;
    }
    
    public int getPorta() {
        return this.porta;
    }
    
    public String getNome() {
        return this.nome;
    }
    
}
