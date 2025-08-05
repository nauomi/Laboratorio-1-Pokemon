import java.util.*;

public class Juego {

    public void iniciarJuego() {
        Entrenador e1 = new Entrenador("Ash", Arrays.asList(
            new Pokemon("Charmander", "Fuego", 30, 20, new HabilidadEspecial("Llama Final", "ataque", 15, 30)),
            new Pokemon("Bulbasaur", "Planta", 25, 25, new HabilidadEspecial("Escudo Natural", "defensa", 20, 40)),
            new Pokemon("Pikachu", "Eléctrico", 28, 18, new HabilidadEspecial("Impacto Relámpago", "daño", 10, 50)),
            new Pokemon("Squirtle", "Agua", 26, 24, new HabilidadEspecial("Tsunami", "ataque", 12, 35))
        ));

        Entrenador e2 = new Entrenador("Gary", Arrays.asList(
            new Pokemon("Cyndaquil", "Fuego", 27, 22, new HabilidadEspecial("Llama Final", "ataque", 15, 30)),
            new Pokemon("Chikorita", "Planta", 24, 26, new HabilidadEspecial("Escudo Natural", "defensa", 20, 40)),
            new Pokemon("Electabuzz", "Eléctrico", 29, 19, new HabilidadEspecial("Impacto Relámpago", "daño", 10, 50)),
            new Pokemon("Totodile", "Agua", 25, 25, new HabilidadEspecial("Tsunami", "ataque", 12, 35))
        ));

        for (int ronda = 0; ronda < 4; ronda++) {
            Pokemon p1 = e1.elegirPokemon(ronda);
            Pokemon p2 = e2.elegirPokemon(ronda);

            p1.activarHabilidad();
            p2.activarHabilidad();

            Batalla batalla = new Batalla(p1, p2);
            int resultado = batalla.pelear();

            if (resultado == 1) {
                e1.incrementarVictorias();
                System.out.println("Ronda " + (ronda + 1) + ": gana " + e1.getNombre());
            } else if (resultado == 2) {
                e2.incrementarVictorias();
                System.out.println("Ronda " + (ronda + 1) + ": gana " + e2.getNombre());
            } else {
                System.out.println("Ronda " + (ronda + 1) + ": empate");
            }
        }

        declararGanadorFinal(e1, e2);
    }

    public void declararGanadorFinal(Entrenador e1, Entrenador e2) {
        System.out.println("Resultado final:");
        System.out.println(e1.getNombre() + ": " + e1.getRondasGanadas() + " rondas ganadas.");
        System.out.println(e2.getNombre() + ": " + e2.getRondasGanadas() + " rondas ganadas.");
        if (e1.getRondasGanadas() > e2.getRondasGanadas()) {
            System.out.println("Ganador: " + e1.getNombre());
        } else if (e2.getRondasGanadas() > e1.getRondasGanadas()) {
            System.out.println("Ganador: " + e2.getNombre());
        } else {
            System.out.println("¡Empate!");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}