# Snap Game

A simple game of snap created purely with Java. The game can be played with both 1 or 2 players. To play, press enter to draw cards and type "snap" if the number on the current card is the same as the previous card.

## Prerequisites

-Java
-Intellij IDEA (Community or Ultimate version)

## 📌 Features

- Full deck of 52 cards using enums for suits and ranks
- Object-oriented design with separate classes for Card, Player, CardGame, and Snap
- Interface created to enable 2 player playable
- SNAP mechanic with a 2-second timed reflex challenge
- Deck can be shuffled and sorted
- Easy to extend for other card games

## Set-up and Run

1. Run `git clone git@github.com:ailuroken/card-game.git` in your terminal
2. Open project card-game in Intellij
3. Run Main.java (file path: card-game\src\main\java\org\example\Main.java) file to initialise the game.

- for single player: comment out lines 15 to 25 using "//"
- for two player: comment out lines 11 and 12 using "//"

## ✍️ Example Output

`Player 1 please enter your name`
`Player1`
`Player 2 please enter your name`
`Player2`
`Welcome to 2 Player Snap!`
`When it's your turn and 2 cards match numbers, type 'snap' within 2 seconds to win`
`Press enter to draw a card`

`Player1 drew card: 10 of ♦`

`Player2 drew card: 3 of ♠`

`Player1 drew card: K of ♣`

`...`

`Player2 drew card: 8 of ♠`

`Player1 drew card: 8 of ♥`
`snap`
`"Snap! Player1 wins!"`

## 📁 Future Improvements

- Add replay option
- Add testing for robustness

### Contact

Yuyao Ai aiyuyao2000@gmail.com
