package entities;

public class Ponto {
    private int x;
    private int y;

    public Ponto() {

    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distancia(Ponto c) {
        return Math.sqrt(Math.pow((double) (this.x - c.getX()), 2) + Math.pow((double) (this.y - c.getY()), 2));
    }
}
