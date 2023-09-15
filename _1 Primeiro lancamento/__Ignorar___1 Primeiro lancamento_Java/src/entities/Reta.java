package entities;

public class Reta {
    private Ponto a;
    private Ponto b;

    public Reta(Ponto a, Ponto b) {
        this.a = a;
        this.b = b;
    }

    public Ponto getA() {
        return a;
    }

    public Ponto getB() {
        return b;
    }

    public double comprimento() {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
