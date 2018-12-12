/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Alfredo Silva
 */
public interface Observador {
    public void atualizar(StyledDocument conteudoPagina);
}
