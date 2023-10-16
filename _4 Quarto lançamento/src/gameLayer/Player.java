package gameLayer;

import cardLayer.Card;
import cardLayer.Hand;

public class Player {
    private Hand hand;
    private String name;

    protected Boolean playing = true;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void takeCard(Card card){
        this.hand.addCard(card);
    }

    public boolean isPlaying() {
        return this.playing;
    }

}
