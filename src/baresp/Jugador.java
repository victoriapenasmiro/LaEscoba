/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class Jugador {
    private String nombre;
    private ArrayList<CartaEsp> cartasMano=new ArrayList<CartaEsp>();
    private ArrayList<CartaEsp> cartasGanadas=new ArrayList<CartaEsp>();
    private int puntos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<CartaEsp> getCartasMano() {
        return cartasMano;
    }

    public void setCartasMano(ArrayList<CartaEsp> cartasMano) {
        this.cartasMano = cartasMano;
    }

    public ArrayList<CartaEsp> getCartasGanadas() {
        return cartasGanadas;
    }

    public void setCartasGanadas(ArrayList<CartaEsp> cartasGanadas) {
        this.cartasGanadas = cartasGanadas;
    }


    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
