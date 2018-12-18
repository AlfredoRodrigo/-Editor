/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Alfredo Silva
 */
public class Facade {
    
    Body body;
    
    private final String[] funcoes = {"as", "assert", "break", "class", "continue", "def", "del", "exec", "from", "global", "import", "in", "is", "lambda", "pass", "print", "raise", "return"};
    private final String[] condicionais = {"and", "elif", "else", "except", "finally", "for", "if", "not", "or", "try"};
    private final String[] operadores = {"<", ">", "=", ":"};
    private final String[] delimitadores = {"(", ")", "[", "]", "{", "}", "'", "\""};
    
    public Facade (Body body) {
        this.body = body;
    }
    
    public void modoNoturno() {
        if (body.getBotaoModoNoturno().isSelected()) {
            body.getPainelBackground().setBackground(Color.DARK_GRAY);
            body.getControleDeslizanteMargemEsquerda().setBackground(Color.DARK_GRAY);
            body.getControleDeslizanteMargemDireita().setBackground(Color.DARK_GRAY);
        } else {
            Color color = new Color(240, 240, 240);
            body.getPainelBackground().setBackground(color);
            body.getControleDeslizanteMargemEsquerda().setBackground(color);
            body.getControleDeslizanteMargemDireita().setBackground(color);
        }
    }
    
    public void modoCodigo() {
        if (body.getBotaoModoCodigo().isSelected()) {
            paintFunctions(funcoes, new Color(153, 0, 153));
            paintFunctions(condicionais, new Color(255, 102, 0));
            paintFunctions(operadores, new Color(255, 200, 40));
            paintFunctions(delimitadores, new Color(255, 210, 130));
            Font fonte = new Font("Courier New", 0, Integer.parseInt((String)this.body.getComboTamanhoFonte().getSelectedItem()));
            this.body.getPagina().setFont(fonte);
        } else {
            unPaintNoFunctions();
            Font fonte = new Font((String)this.body.getComboFonte().getSelectedItem(), 0, Integer.parseInt((String)this.body.getComboTamanhoFonte().getSelectedItem()));
            this.body.getPagina().setFont(fonte);
        }
    }
    
    private void paintFunctions(String[] func, Color cor) {
        try {
            Document code = this.body.getPagina().getDocument();
            String codePart = code.getText(0, code.getLength());
            int pos = 0;
            for (int i = 0; i < func.length; i++) {
                while ((pos = codePart.indexOf(func[i], pos)) >= 0) {
                    StyledDocument doc = this.body.getPagina().getStyledDocument();
                    Style style = this.body.getPagina().addStyle("FuncStyle", null);
                    StyleConstants.setForeground(style, cor);
                    StyleConstants.setBold(style, this.body.getRootPane().isEnabled());
                    doc.setCharacterAttributes(pos, func[i].length(), style, true);

                    pos += func[i].length();
                }
            }
        } catch (Exception e) {

        }
    }
    
    private void unPaintNoFunctions() {
        StyledDocument code = this.body.getPagina().getStyledDocument();
        Style style = this.body.getPagina().addStyle("defaut", null);
        code.setCharacterAttributes(0, this.body.getPagina().getDocument().getLength(), style, true);

    }
    
}
