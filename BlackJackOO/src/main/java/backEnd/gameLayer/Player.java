package backEnd.gameLayer;

import backEnd.cardLayer.Card;
import backEnd.cardLayer.Hand;
import java.util.Scanner;

public class Player {
    private Hand hand;
    private String name;

    private Double balance;

    private Double bet = 0.0;

    public Boolean playing = true;

    public Player(String name, Double balance) {
        this.name = name;
        hand = new Hand();
        this.balance = balance;
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

    public void setBet(double betValue) {
        if (betValue <= balance) {
            this.bet = betValue;
            withdraw(betValue);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para a aposta.");
        }
    }

    public Double getBet() {
        return this.bet;
    }

    public void withdraw(Double amount) {
        if(amount <= this.balance)
            this.balance -= amount;
        else
            System.out.println("Saldo insuficiente");
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setPlaying(boolean b) {
        this.playing = b;
    }
}