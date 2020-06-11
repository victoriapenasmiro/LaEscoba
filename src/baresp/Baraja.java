/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

/**
 *
 * @author rafae
 */
public abstract class Baraja {
    private int numCartas;
    private int numCartasPalo;

    public Baraja() {
    }

    public Baraja(int numCartas, int numCartasPalo) {
        this.numCartas = numCartas;
        this.numCartasPalo = numCartasPalo;
    }

    public int getNumCartas() {
        return numCartas;
    }

    public void setNumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public int getNumCartasPalo() {
        return numCartasPalo;
    }

    public void setNumCartasPalo(int numCartasPalo) {
        this.numCartasPalo = numCartasPalo;
    }
    
    public abstract void iniciarBaraja();
    
    
}
