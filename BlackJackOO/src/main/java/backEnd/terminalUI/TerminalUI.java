package backEnd.terminalUI;

import backEnd.cardLayer.Card;
import backEnd.gameLayer.Dealer;
import backEnd.gameLayer.Player;

public class TerminalUI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void alternateClearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void printBoasVindas(){
        System.out.println("Bem vindo ao BlackJack!");
        System.out.println("\tQuantos jogadores?");

    }

    public static void printAction(){
        System.out.println("O que você vai fazer?");
        System.out.println("\tComprar");
        System.out.println("\tParar");
        System.out.println("\tDesistir\n");
    }

    public static void printCreatePlayers(int i){
        System.out.println("Jogador " + (i+1) + ": ");
        System.out.println("Qual o seu nome?");
    }

    public static void printDealer(Dealer dealer) {
        System.out.println("Mão do crupiê: ");
        System.out.print(dealer.getHand().toString());
        System.out.println("Valor da Mão do crupiê: ");
        System.out.println(dealer.getHand().getHandValue());
        System.out.println();
    }

    public static void printPlayer(Player player) {
        System.out.println("\tMão de " + player.getName());
        System.out.println(player.getHand().toString());
        System.out.println("\tValor da mão de "+  player.getName());
        System.out.println("\t"+player.getHand().getHandValue());
        System.out.println();
    }

    public static void printHit(Player player, Card card){
        System.out.println(player.getName() + " comprou uma carta");
        System.out.println(player.getName() + " retirou " + card.toString());
        System.out.println("novo valor da mão de " + player.getName()+": " + player.getHand().getHandValue());
        System.out.println();
    }

    public static void dealerReveal(Dealer dealer){
        System.out.println("Crupiê revela sua carta:");
        System.out.print(dealer.getHand().toString());
        System.out.println("Valor da mão do crupiê: " + dealer.getHand().getHandValue());
        System.out.println();
    }

    public static void dealerHit(Dealer dealer, Card card){
        System.out.println("O crupiê compra");
        System.out.println("O crupiê comprou " + card.toString());
        System.out.println("Novo valor da mão do crupiê: " + dealer.getHand().getHandValue());
        System.out.println();
    }
}