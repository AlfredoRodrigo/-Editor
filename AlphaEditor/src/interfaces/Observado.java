/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Alfredo Silva
 */
public interface Observado {
    public void incluirObservador(Observador observador);
    
    public void removerObservador(Observador observador);
    
    public void notificarObservadores();
}
