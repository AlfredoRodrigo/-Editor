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
public class InterageTXT implements visual.Estrategia {
    
    private javax.swing.JFileChooser fileSelector = new javax.swing.JFileChooser();
    private File arquivo;
    
    public InterageTXT(File arquivo) {
        this.arquivo = arquivo;
    }
    
    @Override
    public String lerDocumento() {
        int returnVal = fileSelector.showOpenDialog(null);
        //JTextPane pagina = new JTextPane();
        String linha = "";
        String resultado = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arquivo = fileSelector.getSelectedFile();
            String caminho = arquivo.getPath();
            try {
                FileReader arq = new FileReader(caminho);
                BufferedReader lerArquivo = new BufferedReader(arq);
                linha = lerArquivo.readLine();
                while (linha != null) {
                    resultado = resultado + "\n" + linha;
                    linha = lerArquivo.readLine();
                    System.out.println("DENTRO DO WHILE");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Acesso ao arquivo cancelado pelo usuário.");
        }
        return resultado;
    }

    @Override
    public void escreverDocumento(JTextPane pagina) {
        if (arquivo == null) {
            int returnVal = fileSelector.showSaveDialog(pagina);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File arquivo = fileSelector.getSelectedFile();
            }
        }
        try {
            FileWriter arq = new FileWriter(new File(arquivo.getPath()));
            arq.write(pagina.getText());
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(InterageTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public File getArquivo() {
        return this.arquivo;
    }
    
    @Override
    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
    
}
