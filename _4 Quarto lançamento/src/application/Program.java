package application;

import gameLayer.Dealer;
import gameLayer.Game;
import gameLayer.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        System.out.println("Welcome to Blackjack!");
        Dealer dealer = new Dealer();
        System.out.println("How many players?");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numPlayers; i++){
            System.out.println("Player " + (i+1) + ": ");
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }
        Game game = new Game(dealer, players);
        game.startGame();

        UI.alternateClearScreen();

        UI.printDealer(dealer);
        for(Player p : players){
            System.out.println(p.getName() + "'s turn!");
            while(p.isPlaying()){
                UI.printPlayer(p);
                String option;
                System.out.println("What do you want to do?");
                System.out.println("\tHit");
                System.out.println("\tStand");
                option = scanner.nextLine();
                option = option.toLowerCase();
                switch (option) {
                    case "hit":
                        game.playerHit(p);
                        break;

                    case "stand":
                        game.playerStand(p);
                        System.out.println(p.getName() + " end of round! hand value: " + p.getHand().getHandValue());
                        System.out.println();
                        break;
                }
            }
        }
        game.evaluateGame();
    }
}
