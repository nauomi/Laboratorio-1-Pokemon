public class HabilidadEspecial {
    private String nombre;
    private String efecto; // "ataque", "defensa", "daño"
    private int valor;
    private int probabilidad; // 0 a 100

    public HabilidadEspecial(String nombre, String efecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean seActiva() {
        int numero = (int)(Math.random() * 100);
        return numero < probabilidad;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
}