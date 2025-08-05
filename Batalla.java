public class Batalla {
    private Pokemon p1;
    private Pokemon p2;

    public Batalla(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int pelear() {
        int ataque1 = p1.calcularAtaque(p2);
        int ataque2 = p2.calcularAtaque(p1);

        p1.recibirDanio(ataque2);
        p2.recibirDanio(ataque1);

        p1.actualizarEstado();
        p2.actualizarEstado();

        if (ataque1 > ataque2) {
            return 1;
        } else if (ataque2 > ataque1) {
            return 2;
        } else {
            return 0;
        }
    }
}