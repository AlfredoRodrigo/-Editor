/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;

/**
 *
 * @author Alfredo Silva
 */
public class Facade {
    Body corpo;
    public Facade (Body corpo) {
        this.corpo = corpo;
    }
    
    public void pintar() {
        if (corpo.getBotaoModoNoturno().isSelected()) {
            corpo.getControleDeslizanteMargemEsquerda().setBackground(Color.DARK_GRAY);
            corpo.getControleDeslizanteMargemDireita().setBackground(Color.DARK_GRAY);
            corpo.getPainelFundoEsquerdo().setBackground(Color.DARK_GRAY);
            corpo.getPainelFundoDireito().setBackground(Color.DARK_GRAY);
            corpo.getPainelSuperior1().setBackground(Color.DARK_GRAY);
            corpo.getPainelSuperior2().setBackground(Color.DARK_GRAY);
        } else {
            Color cor = new Color(240, 240, 240);
            corpo.getControleDeslizanteMargemEsquerda().setBackground(cor);
            corpo.getControleDeslizanteMargemDireita().setBackground(cor);
            corpo.getPainelFundoEsquerdo().setBackground(cor);
            corpo.getPainelFundoDireito().setBackground(cor);
            corpo.getPainelSuperior1().setBackground(cor);
            corpo.getPainelSuperior2().setBackground(cor);
        }
    }
}
