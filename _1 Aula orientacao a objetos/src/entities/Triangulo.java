package entities;

public class Triangulo extends Ponto{
    private Ponto a, b, c;
    public Triangulo() {
        super();
    }

    public Triangulo(Ponto a, Ponto b, Ponto c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area(){
        double ab = a.distancia(b);
        double bc = b.distancia(c);
        double ca = c.distancia(a);
        double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }


}
