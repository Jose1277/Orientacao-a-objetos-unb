package application;

import gameLayer.Dealer;
import gameLayer.Player;

public class UI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void alternateClearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void printDealer(Dealer dealer) {
        System.out.println("Dealer's hand: ");
        System.out.print(dealer.getHand().toString());
        System.out.println("Dealer's hand value: ");
        System.out.println(dealer.getHand().getHandValue());
        System.out.println();
    }

    public static void printPlayer(Player player) {
        System.out.println(player.getName() + "'s hand: ");
        System.out.println(player.getHand().toString());
        System.out.println(player.getName() + "'s hand value: ");
        System.out.println(player.getHand().getHandValue());
        System.out.println();
    }
}
