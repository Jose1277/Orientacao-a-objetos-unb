package cardLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;


    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                cards.add(new Card(true, suit, value));
            }
        }
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        if(cards.isEmpty()){
            initializeDeck();
            shuffle();
        }
        return cards.remove(0);
    }
}
