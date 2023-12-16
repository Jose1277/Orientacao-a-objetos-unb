package backEnd.cardLayer;

public class Card {
    private Suit suit;
    private Integer value;

    protected Boolean faceUp;

    protected Card(boolean faceUp, Suit suit, int value) {
        this.faceUp = faceUp;
        this.suit = suit;
        this.value = value;
    }
    public void setFaceUp(boolean faceUp){
        this.faceUp = faceUp;
    }

    protected int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        if(this.value == 1){
            return "Ás de " + this.suit;
        }
        if(this.value == 11){
            return "Valete de " + this.suit;
        }
        if(this.value == 12){
            return "Dama de " + this.suit;
        }
        if(this.value == 13){
            return "Rei de " + this.suit;
        }
        return this.value + " de " + this.suit;
    }
}