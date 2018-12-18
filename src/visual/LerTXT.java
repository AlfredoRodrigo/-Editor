/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;

/**
 *
 * @author Alfredo Silva
 */
public class LerTXT implements visual.EstrategiaDeLeitura {
    
    private javax.swing.JFileChooser fileSelector = new javax.swing.JFileChooser();
    private File arquivo;
    
    public LerTXT(File arquivo) {
        this.arquivo = arquivo;
    }
    
    @Override
    public JTextPane executar(File arquivo) {
        JTextPane pagina = new JTextPane();
        String linha = "";
        String resultado = "";
        String caminho = arquivo.getPath();
        if (!(caminho.endsWith(".txt"))) {
                caminho = caminho + ".txt";
        }
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arq);
            linha = lerArquivo.readLine();
            while (linha != null) {
                resultado = resultado + "\n" + linha;
                linha = lerArquivo.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        pagina.setText(resultado);
        return pagina;
    }
    
}
