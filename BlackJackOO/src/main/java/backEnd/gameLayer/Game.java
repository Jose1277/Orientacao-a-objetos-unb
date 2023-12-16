package backEnd.gameLayer;

import backEnd.terminalUI.TerminalUI;
import backEnd.cardLayer.Card;
import backEnd.cardLayer.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Deck deck;
    public Dealer dealer;
    private List<Player> Players;

    public Game(Dealer dealer, List<Player> players) {
        this.Players = players;
        this.dealer = dealer;
        deck = new Deck();
    }

    public void dealInitialCards() {
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
        TerminalUI.printHit(player, card);
        if(player.getHand().getHandValue() > 21){
            player.playing = false;
            System.out.println(player.getName() + " estourou!\n");
        }
    }

    public void playerStand(Player player) {
        System.out.println(player.getName() + " parou!\n");
        player.playing = false;
    }

    public void evaluateGame() {
        dealer.reveal();
        TerminalUI.dealerReveal(dealer);
        int dealerHandValue = dealer.getHand().getHandValue();
        while(dealerHandValue < 17){
            Card card = deck.drawCard();
            dealer.takeCard(card);
            TerminalUI.dealerHit(dealer, card);
            dealerHandValue = dealer.getHand().getHandValue();
        }

        for(Player player : Players){
            int playerHandValue = player.getHand().getHandValue();
            if(playerHandValue > 21) {
                System.out.println(player.getName() + " estourou!");
            }
            else if(playerHandValue < dealerHandValue && dealerHandValue <= 21){
                System.out.println(player.getName() + " perdeu!");
            }
            else if(playerHandValue > dealerHandValue || dealerHandValue > 21){
                player.deposit(player.getBet() * 2);
                System.out.println(player.getName() + " venceu!");
            }
            else{
                System.out.println(player.getName() + " empatou!");
                player.deposit(player.getBet());
            }

            DBOperator dbOperator = new DBOperator();
            dbOperator.atualizarSaldoJogador(player.getName(), player.getBalance());

        }
    }

    public static void start(){
        DBOperator dbOperator = new DBOperator();
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        Dealer dealer = new Dealer();

        TerminalUI.printBoasVindas();

        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numPlayers; i++){
            TerminalUI.printCreatePlayers(i);
            String name = scanner.nextLine();
            double saldo = dbOperator.buscarSaldo(name);
            Player player = new Player(name, saldo);
            players.add(player);
        }
        Game game = new Game(dealer, players);
        game.startGame();

        TerminalUI.alternateClearScreen();


        for(Player p: players){
            System.out.println();
            System.out.println(p.getName() + " seu saldo é de: " + p.getBalance());
            System.out.println(p.getName() + " faça a sua aposta: ");
            Double bet = scanner.nextDouble();
            scanner.nextLine();
            p.setBet(bet);
        }

        TerminalUI.printDealer(dealer);
        for(Player p : players){
            System.out.println("Vez de " + p.getName());
            while(p.isPlaying()){
                TerminalUI.printPlayer(p);
                TerminalUI.printAction();
                String option;
                option = scanner.nextLine();
                option = option.toLowerCase();
                switch (option) {
                    case "comprar":
                        System.out.println();
                        game.playerHit(p);
                        break;

                    case "parar":
                        System.out.println();
                        game.playerStand(p);
                        System.out.println("Fim do round de " + p.getName() + " Valor da mão: " + p.getHand().getHandValue());
                        System.out.println();
                        break;

                    case "desistir":
                        System.out.println();
                        p.playing = false;
                        System.out.println(p.getName() + " desistiu!");
                        break;
                }
            }
        }
        game.evaluateGame();
    }
}