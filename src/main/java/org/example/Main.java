package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    //Single player
    Snap game = new Snap("snap");
    game.play();

    //Two player
    Scanner s = new Scanner(System.in);
    System.out.println("Player 1 please enter your name");
    String player1 = s.nextLine();
    System.out.println("Player 2 please enter your name");
    String player2 = s.nextLine();

        Snap game = new Snap("snap");

    Player p1 = new Player(player1);
    Player p2 = new Player(player2);
    game.twoPLayerPlay(p1, p2);
        }
    }
