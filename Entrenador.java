import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> pokemones;
    private int rondasGanadas;

    public Entrenador(String nombre, List<Pokemon> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.rondasGanadas = 0;
    }

    public Pokemon elegirPokemon(int indice) {
        return pokemones.get(indice);
    }

    public void incrementarVictorias() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}