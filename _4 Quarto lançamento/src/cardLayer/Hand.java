package cardLayer;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public int getHandValue(){
        int value = 0;
        int aces = 0;
        for (Card card : cards) {
            if(card.faceUp){
                if (card.getValue() >= 10) {
                    value += 10;
                } else if (card.getValue() == 1) {
                    aces++;
                } else {
                    value += card.getValue();
                }
            }
        }

        while (aces > 0 && value + 10 <= 21) {
            value += 11;
            aces--;
        }

        return value;
    }

    public String toString() {
        String result = "";
        for (Card card : this.cards) {
            if(card.faceUp)
                result += card + "\n";
            else
                result += "Face Down\n";
        }
        return result;
    }
}

