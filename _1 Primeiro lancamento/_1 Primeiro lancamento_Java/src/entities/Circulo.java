package entities;

public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;

    }

    public Ponto getCentro() {
        return centro;
    }

    public double getRaio() {
        return raio;
    }

    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public String toString() {
        return String.format("Circulo: %s, raio: %.2f", centro, raio);
    }
}
