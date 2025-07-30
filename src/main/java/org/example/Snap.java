package org.example;
import java.util.Scanner;
import java.util.concurrent.*;

public class Snap extends CardGame implements CanBeTwoPlayer {
    public Snap(String name) {
        super(name);
        shuffleDeck();
    }

    public void play() {
        System.out.println("Welcome to Snap!");
        System.out.println("When 2 cards match numbers, player wins");
        System.out.println("Press enter to draw a card");

        Scanner s = new Scanner(System.in);
        Card previousCard = null;

        while (!getDeckOfCards().isEmpty()) {
            s.nextLine();
            Card cardDealt = dealCard();
            getDeckOfCards().removeFirst();
            System.out.println("Card: " + cardDealt);

            if (previousCard != null && cardDealt.getDisplay().equals(previousCard.getDisplay())) {
                System.out.println("SNAP! You win!");
                return;
            }
            previousCard = cardDealt;
        }
        System.out.println("Deck empty! Game over!");
    }

    @Override
    public void twoPLayerPlay(Player player1, Player player2) {
        System.out.println("Welcome to 2 Player Snap!");
        System.out.println("When it's your turn and 2 cards match numbers, type 'snap' within 2 seconds to win");
        System.out.println("Press enter to draw a card");

        Scanner s = new Scanner(System.in);
        Card previousCard = null;
        boolean player1Turn = true;

        while (!getDeckOfCards().isEmpty()) {
            Player currentPlayer = player1Turn ? player1 : player2;
            Player otherPlayer = player1Turn ? player2 : player1;

            s.nextLine();

            Card cardDealt = dealCard();
            getDeckOfCards().removeFirst();
            System.out.println(currentPlayer.getName() + " drew card: " + cardDealt);

            if (previousCard != null && cardDealt.getDisplay().equals(previousCard.getDisplay())) {

                ExecutorService executor = Executors.newSingleThreadExecutor();
                Future<String> future = executor.submit(s::nextLine);

                try {
                    String input = future.get(2, TimeUnit.SECONDS);
                    if (input.trim().equalsIgnoreCase("snap")) {
                        System.out.println("Snap! " + currentPlayer.getName() + " wins!");
                    } else {
                        System.out.println("Snap was not called out! " + otherPlayer.getName() + " wins!");
                    }
                    executor.shutdownNow();
                    return;
                } catch (TimeoutException e) {
                    System.out.println("Too slow! " + otherPlayer.getName() + " wins!");
                    executor.shutdownNow();
                    return;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    executor.shutdownNow();
                    return;
                }
            }

            previousCard = cardDealt;
            player1Turn = !player1Turn;
        }

        System.out.println("No SNAP occurred. It's a draw!");
    }
}
