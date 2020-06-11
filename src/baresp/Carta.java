/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

/**
 *
 * @author rgion
 */
public abstract class Carta {
    private int numeroCarta;

    public Carta(int numeroCarta) {
        this.setNumeroCarta(numeroCarta); 
    }
    public Carta(Carta c) {
        this.setNumeroCarta(c.getNumeroCarta());
    }
    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }
    public abstract void mostrarCarta(int num);
    
}
