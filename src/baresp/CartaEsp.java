/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

import java.util.ArrayList;

/**
 *
 * @author rgion
 */
public class CartaEsp extends Carta {

    private PalosBarajaEspañola palo;

    public CartaEsp(PalosBarajaEspañola palo, int numeroCarta) {
        super(numeroCarta);
        this.setPalo(palo);
    }

    public CartaEsp(CartaEsp ce) {
        super((Carta) ce);
        this.setPalo(ce.getPalo());
    }

    public PalosBarajaEspañola getPalo() {
        return palo;
    }

    public void setPalo(PalosBarajaEspañola palo) {
        this.palo = palo;
    }

    @Override
    public void mostrarCarta(int num) {
        String carta = "Carta nº"+num+": ";
        switch (this.getNumeroCarta()) {
            case 8:
                carta += "SOTA";
                break;
            case 9:
                carta += "CABALLO";
                break;
            case 10:
                carta += "REY";
                break;
            default:
                carta += Integer.toString(this.getNumeroCarta());
                break;
        }
        System.out.println(carta+" de "+this.getPalo());
    }
    public static void mostrarCartas(ArrayList<CartaEsp> listaCartas){
        // dado un arraylist de cartas de la baraja española muestra
        // todas las tarjetas.
        for (int i=0;i<listaCartas.size();i++){
            listaCartas.get(i).mostrarCarta(i);
        }
        
    }    
}