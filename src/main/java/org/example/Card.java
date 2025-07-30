package org.example;

public class Card {
    private String suit;
    private String display;
    private int value;

    public Card(String suit, String display, int value) {
        this.suit = suit;
        this.display = display;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getDisplay() {
        return display;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return display + " of " + suit;
    }
}