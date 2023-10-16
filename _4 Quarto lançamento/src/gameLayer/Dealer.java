package gameLayer;

import cardLayer.Card;
import cardLayer.Hand;

public class Dealer {
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public Hand getHand() {
        return this.hand;
    }

    protected void takeCard(Card card){
        this.hand.addCard(card);
    }

    protected void reveal(){
            Card secondCard = hand.getCards().get(1);
            secondCard.setFaceUp(true);
        }
    }
