
import java.io.File;
import java.security.AccessController;
import sun.awt.OSInfo;
import visual.LerTXT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo Silva
 */
public class TesteLeitura {
    public static void main(String[] args) {
        String texto = "Oi, alfredo!";
        System.out.println(texto);
        System.out.println(texto.length());
        texto = texto.replace(", alfredo!", "");
        System.out.println(texto);
        System.out.println(texto.length());
    }
    
}
