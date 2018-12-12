/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.File;
import javax.swing.JTextPane;

/**
 *
 * @author Alfredo Silva
 */
public interface Estrategia {
    public String lerDocumento();
    public void escreverDocumento(JTextPane pagina);
    public File getArquivo();
    public void setArquivo(File arquivo);
}
