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

    public String quadrante(){
        if(centro.getX() == 0 && centro.getY() == 0){
            return "O circulo tem centro na origem e está em todos os quadrantes";
        }
        if(centro.getX() - raio >= 0 && centro.getY() - raio >= 0){
            return "O circulo está no primeiro quadrante";
        }
        if(centro.getX() + raio < 0 && centro.getY() + raio < 0) {
            return "O circulo está no terceiro quadrante";
        }
        else{
            return "O circulo está em mais de um quadrante";
        }
    }

    @Override
    public String toString() {
        return String.format("Circulo: %s, raio: %.2f", centro, raio);
    }
}
