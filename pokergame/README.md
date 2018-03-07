# Introduction

PokerGame is a game in which two players is randomly deal two poker cards and the winner is the player who has the largest card.

# Class Design

Poker

- class Card: one card is one instance

    - cardValue
    - cardColor

- cards list: stored all poker cards
- shuffle(): shuffle cards

Player

- id
- name
- maxCard
- cards: each play can randomly fetch two cards.

# Run Program

Type in command line

```bash
cd out/production/pokergame/
java PokerGame
```

# Output sample

```
Create Poker Cards...
Completed.
Poker card list is: [SPADE 2, SPADE 3, SPADE 4, SPADE 5, SPADE 6, SPADE 7, SPADE 8, SPADE 9, SPADE 10, SPADE J, SPADE Q, SPADE K, SPADE A, HEART 2, HEART 3, HEART 4, HEART 5, HEART 6, HEART 7, HEART 8, HEART 9, HEART 10, HEART J, HEART Q, HEART K, HEART A, CLUB 2, CLUB 3, CLUB 4, CLUB 5, CLUB 6, CLUB 7, CLUB 8, CLUB 9, CLUB 10, CLUB J, CLUB Q, CLUB K, CLUB A, DIAMOND 2, DIAMOND 3, DIAMOND 4, DIAMOND 5, DIAMOND 6, DIAMOND 7, DIAMOND 8, DIAMOND 9, DIAMOND 10, DIAMOND J, DIAMOND Q, DIAMOND K, DIAMOND A]
Shuffle Poker Cards...
Done.

Create players...
Please input the ID number and Name of the first player:
Please input ID number:
1
Please input Name:
Tom
Please input the ID number and Name of the second player:
Please input ID number:
2
Please input Name:
Jack

Welcome player: Tom
Welcome player: Jack
Dealing cards...
Player: Tom get a poker card
Player: Jack get a poker card
Player: Tom get a poker card
Player: Jack get a poker card
Complete Dealing!

Game Start!
The largest poker card of Tom is HEART Q
The largest poker card of Jack is SPADE 9
Tom win!

Game over.
The pokers card of players:
Tom : [HEART 10, HEART Q]
Jack : [SPADE 9, HEART 4]
```

