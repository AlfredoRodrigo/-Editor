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
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author Alfredo Silva
 */
public class LerRTF implements visual.EstrategiaDeLeitura {
    
    private javax.swing.JFileChooser fileSelector = new javax.swing.JFileChooser();
    private File arquivo;
    
    public LerRTF(File arquivo) {
        this.arquivo = arquivo;
    }
    
    @Override
    public JTextPane executar(File arquivo) {
        JTextPane pagina = new JTextPane();
        StyledDocument documentoEstilizado = new DefaultStyledDocument();
        String caminho = arquivo.getPath();
        RTFEditorKit kit = new RTFEditorKit();
        if (!(caminho.endsWith(".rtf"))) {
                caminho = caminho + ".rtf";
        }
        try {
            FileInputStream inStream = new FileInputStream(caminho);
            kit.read(inStream, documentoEstilizado, 0);
            inStream.close();
            pagina.setStyledDocument(documentoEstilizado);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        
        return pagina;
    }
    
}
