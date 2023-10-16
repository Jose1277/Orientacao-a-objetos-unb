package cardLayer;

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
            return "Ace of " + this.suit;
        }
        if(this.value == 11){
            return "Jack of " + this.suit;
        }
        if(this.value == 12){
            return "Queen of " + this.suit;
        }
        if(this.value == 13){
            return "King of " + this.suit;
        }
        return this.value + " of " + this.suit;
    }
}
