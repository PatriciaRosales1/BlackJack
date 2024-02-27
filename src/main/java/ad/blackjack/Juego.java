package ad.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//Clase Juego
public class Juego {
    boolean iniciado; //para el estado
    List<Carta> baraja;
    List<Carta> ordenador;
    List<Carta> jugador;

    public Juego() {
        this.iniciarPartida();
    }


    //Método para iniciar la partida
    public void iniciarPartida() {
        this.iniciado = true;
        this.baraja = new ArrayList<>();
        this.ordenador = new ArrayList<>();
        this.jugador = new ArrayList<>();
        this.crearBaraja();
    }


    //Método para crear la baraja
    public void crearBaraja() {
        char[] palos = {'C', 'T', 'P', 'D'};
        String[] nombres = {"AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int valor;

        for (char palo : palos) {
            for (int i = 0; i < 13; i++) {
                valor = (i >= 10) ? 10 : i + 1;
                Carta carta = new Carta(palo, nombres[i], valor);
                this.baraja.add(carta);
            }
        }
    }


    //Método para sacar una carta que aún no esté
    public Carta sacarCarta(){
        Carta carta=null;
        Random aleatorio = new Random(System.currentTimeMillis());
        boolean control=true;
        while(control) {
            carta = this.baraja.get(aleatorio.nextInt(56));
            if (!carta.isRepartida()) {
                carta.setRepartida(true);
                control=false;
            }
        }
        return carta;
    }


    //Método para repartir carta al jugador
    public void cartaJugador(){
        this.jugador.add(this.sacarCarta());
    }


    //Método para repartir carta al ordenador
    public void cartaOrdenador(){
        this.ordenador.add(this.sacarCarta());
    }


    //Getters y setters
    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public List<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(List<Carta> baraja) {
        this.baraja = baraja;
    }

    public List<Carta> getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(List<Carta> ordenador) {
        this.ordenador = ordenador;
    }

    public List<Carta> getJugador() {
        return jugador;
    }

    public void setJugador(List<Carta> jugador) {
        this.jugador = jugador;
    }


    //Método para ver la baraja
    public String mostrarBaraja() {
        return "Baraja: " + this.baraja;
    }


    //Método para mostrar la suma de las cartas del ordenador
    public String mostrarOrdenador(){
        AtomicInteger suma= new AtomicInteger();
        this.ordenador.forEach( carta -> {
            suma.addAndGet(carta.getValor());});
        return "Cartas Ordenador ( " + suma + "): " + this.ordenador;
    }


    //Método para mostrar la suma de las cartas del jugador
    public String mostrarJugador(){
        AtomicInteger suma= new AtomicInteger();
        this.jugador.forEach( carta -> {
            suma.addAndGet(carta.getValor());});
        return "Cartas Jugador ( " + suma + "): " +this.jugador;
    }


    @Override
    public String toString() {
        return "Juego{" +
                "iniciado=" + iniciado +
                ", baraja=" + baraja +
                ", ordenador=" + ordenador +
                ", jugador=" + jugador +
                '}';
    }
}

