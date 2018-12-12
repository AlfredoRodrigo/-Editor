/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author Alfredo Silva
 */
public class InterageRTF implements interfaces.Estrategia {
    
    private javax.swing.JFileChooser fileSelector = new javax.swing.JFileChooser();
    private File arquivo;
    
    public InterageRTF(File arquivo) {
        this.arquivo = arquivo;
    }
    
    @Override
    public String lerDocumento() {
        int returnVal = fileSelector.showOpenDialog(null);
        JTextPane pagina = new JTextPane();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arquivo = fileSelector.getSelectedFile();
            String caminho = arquivo.getPath();
            StyledDocument doc = pagina.getStyledDocument();
            RTFEditorKit kit = new RTFEditorKit();
            if (!(caminho.substring((caminho.length() - 4), (caminho.length())).equals(".rtf"))) {
                caminho = caminho + ".rtf";
            }
            try {
                FileInputStream inStream = new FileInputStream(caminho);
                kit.read(inStream, doc, 0);
                inStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Acesso ao arquivo cancelado pelo usuário.");
        }
        return pagina.getText();
    }

    @Override
    public void escreverDocumento(JTextPane pagina) {
        try {
            if (arquivo == null) {
                int returnVal = fileSelector.showSaveDialog(pagina);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File arquivo = fileSelector.getSelectedFile();
                }
            }
            String caminho = arquivo.getPath();
            StyledDocument doc = pagina.getStyledDocument();
            RTFEditorKit kit = new RTFEditorKit();
            if (!(caminho.substring((caminho.length() - 4), (caminho.length())).equals(".rtf"))) {
                caminho = caminho + ".rtf";
            }
            try {
                FileOutputStream outStream = new FileOutputStream(caminho);
                kit.write(outStream, doc, 0, doc.getLength());
                outStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
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
