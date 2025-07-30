package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class CardGame {
    private String name;
    private ArrayList<Card> deckOfCards;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    private void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckOfCards.add(new Card(suit.getSymbol(), rank.getDisplay(), rank.getValue()));
            }
        }
    }

    public void getDeck() {
        System.out.printf("The deck for " + name + " game \n");
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard() {
        return deckOfCards.getFirst();
    }

    public void sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparingInt(Card::getValue));
    }

    public void sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}
