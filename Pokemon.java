public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;
    private boolean habilidadActiva;
    private int rondasRestantesConHabilidad;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.habilidadActiva = false;
        this.rondasRestantesConHabilidad = 0;
    }

    public int calcularAtaque(Pokemon rival) {
        int total = this.ataque;

        if ((this.tipo.equals("Fuego") && rival.tipo.equals("Planta")) ||
            (this.tipo.equals("Planta") && rival.tipo.equals("Agua")) ||
            (this.tipo.equals("Agua") && rival.tipo.equals("Fuego")) ||
            (this.tipo.equals("Eléctrico") && rival.tipo.equals("Agua"))) {
            total += 20;
        } else if ((this.tipo.equals("Fuego") && rival.tipo.equals("Agua")) ||
                   (this.tipo.equals("Planta") && rival.tipo.equals("Fuego")) ||
                   (this.tipo.equals("Agua") && rival.tipo.equals("Planta")) ||
                   (this.tipo.equals("Agua") && rival.tipo.equals("Eléctrico"))) {
            total -= 10;
        }

        if (habilidadActiva) {
            if (habilidad.getEfecto().equals("ataque") || habilidad.getEfecto().equals("daño")) {
                total += habilidad.getValor();
            }
        }

        return total;
    }

    public void activarHabilidad() {
        if (habilidad.seActiva()) {
            habilidadActiva = true;
            rondasRestantesConHabilidad = 2;
        }
    }

    public void recibirDanio(int cantidad) {
        if (cantidad > 40) {
            habilidadActiva = false;
            rondasRestantesConHabilidad = 0;
        }
    }

    public void actualizarEstado() {
        if (rondasRestantesConHabilidad > 0) {
            rondasRestantesConHabilidad--;
        }
        if (rondasRestantesConHabilidad == 0) {
            habilidadActiva = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }
}