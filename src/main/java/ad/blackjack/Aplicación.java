package ad.blackjack;

public class Aplicación {
    public static void main(String[] args) {
        Juego juego = new Juego();
        System.out.println(juego.mostrarBaraja());
        for (int i = 0; i <2 ; i++) {
            juego.cartaJugador();
            juego.cartaOrdenador();
        }
        System.out.println("-----------------------------");
        System.out.println(juego.mostrarBaraja());
        System.out.println("-----------------------------");
        System.out.println(juego.mostrarJugador());
        System.out.println(juego.mostrarOrdenador());
    }
}
