package entities;

public class Paralelepipedo{
    private Ponto a, b, c, d;
    private Reta ab, bc;

    public Paralelepipedo(Ponto a, Ponto b, Ponto c, Ponto d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        ab = new Reta(a, b);
        bc = new Reta(b, c);
    }
    public double area(){
        return ab.comprimento()*bc.comprimento();
    }

    @Override
    public String toString() {
        return String.format("Paralelepipedo: %s, %s, %s, %s", a, b, c, d);
    }
}
