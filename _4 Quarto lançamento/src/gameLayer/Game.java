package gameLayer;

import cardLayer.Card;
import cardLayer.Deck;

import java.util.List;

public class Game {
    private Deck deck;
    private Dealer dealer;
    private List<Player> Players;

    public Game(Dealer dealer, List<Player> players) {
        this.Players = players;
        this.dealer = dealer;
        deck = new Deck();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            dealer.takeCard(deck.drawCard());
            for (Player player : Players) {
                player.takeCard(deck.drawCard());
            }
        }
        dealer.getHand().getCards().get(1).setFaceUp(false);
    }

    public void startGame() {
        dealInitialCards();
    }

    public void playerHit(Player player) {
            Card card = deck.drawCard();
            player.takeCard(card);
            System.out.println(player.getName() + " hits");
            System.out.println(player.getName() + " draws " + card.toString());
            System.out.println(player.getName() + " new hand value: " + player.getHand().getHandValue());
            System.out.println();
            if(player.getHand().getHandValue() > 21){
                player.playing = false;
                System.out.println(player.getName() + " busted!");
            }
    }

    public void playerStand(Player player) {
        System.out.println(player.getName() + " stands");
        player.playing = false;
    }

    public void evaluateGame() {
        System.out.println("Dealer reveals hand:");
        dealer.reveal();
        System.out.print(dealer.getHand().toString());
        System.out.println("Dealer hand value: " + dealer.getHand().getHandValue());
        System.out.println();
        int dealerHandValue = dealer.getHand().getHandValue();
        while(dealerHandValue < 17){
            System.out.println("Dealer hits");
            Card card = deck.drawCard();
            dealer.takeCard(card);
            System.out.println("Dealer draws " + card.toString());
            System.out.println("Dealer new hand value: " + dealer.getHand().getHandValue());
            System.out.println();
            dealerHandValue = dealer.getHand().getHandValue();
        }

        for(Player player : Players){
            int playerHandValue = player.getHand().getHandValue();
            if(playerHandValue > 21) {
                System.out.println(player.getName() + " busted!");
            }
            else if(playerHandValue < dealerHandValue && dealerHandValue <= 21){
                System.out.println(player.getName() + " lost!");
            }
            else if(playerHandValue > dealerHandValue || dealerHandValue > 21){
                System.out.println(player.getName() + " won!");
            }
            else{
                System.out.println(player.getName() + " tied!");
            }
        }
    }
}
