/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baresp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafa
 */
public class Escoba {

    public static final int PUNTOSBAZA = 15;
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private ArrayList<CartaEsp> cartasCentro = new ArrayList<CartaEsp>();
    private BarajaEspañola baraja = new BarajaEspañola(40, 10);

    public Escoba() {
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public ArrayList<CartaEsp> getCartasCentro() {
        return cartasCentro;
    }

    public BarajaEspañola getBaraja() {
        return baraja;
    }

    public void setBaraja(BarajaEspañola baraja) {
        this.baraja = baraja;
    }

    public void setCartasCentro(ArrayList<CartaEsp> cartasCentro) {
        this.cartasCentro = cartasCentro;
    }

    public void iniciarJuego() {
        System.out.println("Dame el nombre del jugador 1");
        Scanner lector = new Scanner(System.in);
        this.getJugador1().setNombre(lector.nextLine());
        System.out.println("Dame el nombre del jugador 2");
        this.getJugador2().setNombre(lector.nextLine());
        this.getBaraja().iniciarBaraja();
        this.getBaraja().barajar();
        this.repartirCentro();
        this.repartirJugador(this.getJugador1());
        this.repartirJugador(this.getJugador2());
    }

    public void jugarEscoba() {
        iniciarJuego();
        // mientras quedan cartas por jugar, jugamos
        while (this.getJugador2().getCartasMano().size()!=0
                || this.getBaraja().getSinRepartir().size()!=0) {
            //la idea del juego es que mostramos el estado de las cartas en el centro
            // y es turno del jugador 1 y luego del jugador2
            this.jugarTurnoJugador(this.getJugador1());
            this.jugarTurnoJugador(this.getJugador2());
            //verificamos después del turno de los dos jugadores
            //si se han quedado sin cartas en la mano
            if (this.getJugador1().getCartasMano().isEmpty()&&
                this.getBaraja().getSinRepartir().size()!=0) {
                this.repartirJugador(this.getJugador1());
                this.repartirJugador(this.getJugador2());
            }

        }
        finalizarEscoba();
    }

    public void repartirCentro() {
        //repartimos 4 cartas al centro al iniciar el juego
        this.getCartasCentro().add(this.getBaraja().repartirCarta());
        this.getCartasCentro().add(this.getBaraja().repartirCarta());
        this.getCartasCentro().add(this.getBaraja().repartirCarta());
        this.getCartasCentro().add(this.getBaraja().repartirCarta());
    }

    public void repartirJugador(Jugador jugador) {
        //repartimos 3 cartas al centro al iniciar el juego
        jugador.getCartasMano().add(this.getBaraja().repartirCarta());
        jugador.getCartasMano().add(this.getBaraja().repartirCarta());
        jugador.getCartasMano().add(this.getBaraja().repartirCarta());
    }

    public void jugarTurnoJugador(Jugador jugador) {
        //la idea de este turno es que el jugador
        //viendo sus cartas seleccione una de las cartas
        //de la mano, y varias del centro
        System.out.println("=Cartas del centro de la mesa=");
        CartaEsp.mostrarCartas(this.getCartasCentro());

        System.out.println("=Cartas del jugador " + jugador.getNombre() + "=");
        CartaEsp.mostrarCartas(jugador.getCartasMano());
        Scanner lector = new Scanner(System.in);
        System.out.println("Qué carta quieres seleccionar?");
        int numCarta = Integer.parseInt(lector.nextLine());
        int sumatorio = jugador.getCartasMano().get(numCarta).getNumeroCarta();
        System.out.println("1)Quieres tirar la carta al centro? ");
        System.out.println("2)Quieres recoger cartas del centro?");
        int opcion = Integer.parseInt(lector.nextLine());

        if (opcion == 1) {
            System.out.println("=Cartas del centro de la mesa=");
            this.getCartasCentro().add(jugador.getCartasMano().remove(numCarta));
        } else {
            //pedimos al usuario qué cartas quiere retirar del centro
            //asumimos que si el usuario si  
            //no decide bien las cartas seleccionadas para sumar 15
            // la carta se queda en el centro
            CartaEsp.mostrarCartas(this.getCartasCentro());
            System.out.println("¿cuantas cartas quieres quitar del centro?");
            int numCartas = Integer.parseInt(lector.nextLine());
            int[] listaIndices = new int[numCartas];
            System.out.println("puntuación de las cartas seleccionadas="
                    + sumatorio);
            for (int i = 0; i < numCartas; i++) {
                System.out.println("Carta nº" + i + ": ");
                listaIndices[i] = Integer.parseInt(lector.nextLine());
                sumatorio += this.getCartasCentro().get(listaIndices[i]).getNumeroCarta();
                System.out.println("puntuación de las cartas seleccionadas="
                    + sumatorio);
            }
            //ya nos han pasado las cartas del centro
            //ahora nos toca ver si se las lleva o la deja en el centro
            
            if (sumatorio == PUNTOSBAZA) {
                for (int i = 0; i < numCartas; i++) {
                    jugador.getCartasGanadas().add(this.getCartasCentro().remove(listaIndices[i]-i));                    
                }
                jugador.getCartasGanadas().add(jugador.getCartasMano().remove(numCarta));
            } else {
                this.getCartasCentro().add(jugador.getCartasMano().remove(numCarta));
            }
            //en este momento validamos si hemos dejado sin cartas el centro
            // para marcar las escoba
            if (this.getCartasCentro().isEmpty()) {
                System.out.println("Felicidades: ESCOBA");
                jugador.setPuntos(jugador.getPuntos() + 1);
            }
        }
    }

    public void finalizarEscoba() {
        //cuando llegamos a este punto es momento de
        //ver quien ha ganado para ello hay que tener en cuenta las cartas ganadas
        if (this.getJugador1().getCartasGanadas().size()
                > this.getJugador2().getCartasGanadas().size()) {
            this.getJugador1().setPuntos(this.getJugador1().getPuntos() + 1);
        } else {
            this.getJugador2().setPuntos(this.getJugador2().getPuntos() + 1);
        }
        System.out.println("Resumen de puntos - Escoba FBMOLL");
        System.out.println(this.getJugador1().getNombre() + " - Puntos: "
                + this.getJugador1().getPuntos());
        System.out.println(this.getJugador2().getNombre() + " - Puntos: "
                + this.getJugador2().getPuntos());
        this.obtenerGanador();
    }

    public void obtenerGanador() {
        String ganador ="El ganador ha sido ";
        if (this.getJugador1().getPuntos() > this.getJugador2().getPuntos()) {
            ganador += this.getJugador1().getNombre();
        } else if (this.getJugador1().getPuntos() > this.getJugador2().getPuntos()) {
            ganador += this.getJugador2().getNombre();
        }else{
            ganador="EMPATE";
        }
        System.out.println(ganador);
    }

}
