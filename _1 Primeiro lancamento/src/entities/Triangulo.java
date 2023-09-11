package entities;

public class Triangulo{
    private Ponto a, b, c;
    private Reta ab, bc, ca;

    public Triangulo(Ponto a, Ponto b, Ponto c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if(a.getX() == b.getX() && a.getY() == b.getY() || a.getX() == c.getX() && a.getY() == c.getY() || b.getX() == c.getX() && b.getY() == c.getY())
            throw new IllegalArgumentException("Os pontos não formam um triangulo");

        ab = new Reta(a, b);
        bc = new Reta(b, c);
        ca = new Reta(c, a);
    }

    public double area(){
        double p = (ab.comprimento()+bc.comprimento()+ca.comprimento())/2;
        return Math.sqrt(p*(p-ab.comprimento())*(p-bc.comprimento())*(p-ca.comprimento()));
    }

    @Override
    public String toString() {
        return String.format("Triangulo: %s, %s, %s", a, b, c);
    }
}
