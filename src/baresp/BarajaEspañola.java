/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rgion
 */
public class BarajaEspañola extends Baraja {
    ArrayList<CartaEsp> repartidas=new ArrayList<CartaEsp>();
    ArrayList<CartaEsp> sinRepartir=new ArrayList<CartaEsp>();

    public BarajaEspañola(int numCartas, int numCartasPalo) {
        super(numCartas, numCartasPalo);
    }
    
    @Override
    public void iniciarBaraja() {
        for (int i=1;i<this.getNumCartasPalo()+1;i++){
            sinRepartir.add(new CartaEsp(PalosBarajaEspañola.OROS,i));
            sinRepartir.add(new CartaEsp(PalosBarajaEspañola.BASTOS,i));
            sinRepartir.add(new CartaEsp(PalosBarajaEspañola.COPAS,i));
            sinRepartir.add(new CartaEsp(PalosBarajaEspañola.ESPADAS,i));
        }
    }

    public ArrayList<CartaEsp> getRepartidas() {
        return repartidas;
    }

    public void setRepartidas(ArrayList<CartaEsp> repartidas) {
        this.repartidas = repartidas;
    }

    public ArrayList<CartaEsp> getSinRepartir() {
        return sinRepartir;
    }

    public void setSinRepartir(ArrayList<CartaEsp> sinRepartir) {
        this.sinRepartir = sinRepartir;
    }
    
    public void barajar(){
        ArrayList<CartaEsp> barajada=new ArrayList<CartaEsp>();
        while (this.getSinRepartir().size()!=0){
            barajada.add(this.getSinRepartir().remove(generarAleatorio(this.getSinRepartir().size())));
        }
        this.setSinRepartir(barajada);
    }
    public static int generarAleatorio(int max) {
// Instanciamos la clase Random
        Random random = new Random();
        return random.nextInt(max);
    }
    public void mostrarSinRepartir(){
        for (int i=0;i<sinRepartir.size();i++){
            sinRepartir.get(i).mostrarCarta(i);
        }
    }
    public void mostrarRepartidas(){
        for (int i=0;i<repartidas.size();i++){
            repartidas.get(i).mostrarCarta(i);
        }
    }
    public CartaEsp repartirCarta(){
        //repartimos la siguiente carta del mazo
        // y eliminamos del mazo de sinrepartir
        // añadimos al mazo repartir
        repartidas.add(sinRepartir.get(0));
        return sinRepartir.remove(0);
    }
    
    
}
