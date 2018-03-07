import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PokerGame {
    public enum CardColor {
        SPADE(0), HEART(1), CLUB(2), DIAMOND(3);

        private int value;
        CardColor(int value) {
            this.value = value;
        }

        private int getValue(){
            return value;
        }
    }

    private static final String[] cardValueName = new String[16];
    static {
        for (int i = 2; i <= 10; i++) cardValueName[i] = String.valueOf(i);
        cardValueName[11] = "J";
        cardValueName[12] = "Q";
        cardValueName[13] = "K";
        cardValueName[14] = "A";
    }

    class Poker{
        public class Card {
            CardColor cardColor;
            int cardValue;

            Card(CardColor cardColor, int cardValue) {
                this.cardColor = cardColor;
                this.cardValue = cardValue;
            }

            @Override
            public String toString(){
                String cardColor = String.valueOf(this.cardColor);
                String cardValue = String.valueOf(cardValueName[this.cardValue]);
                return cardColor +" "+ cardValue;
            }
        }

        ArrayList<Card> cards = new ArrayList<>();

        Poker() {
            System.out.println("Create Poker Cards...");
            for (CardColor cardColor : CardColor.values()) {
                for (int i = 2; i <= 14; i++) {
                    cards.add(new Card(cardColor, i));
                }
            }
            System.out.println("Completed.");
            System.out.print("Poker card list is: ");
            System.out.println(cards);
        }

        private void shuffle() {
            Collections.shuffle(cards);
        }
    }

    class Player{
        int id;
        String name;
        ArrayList<Poker.Card> cards = new ArrayList<>();
        int maxCardValue;
        Poker.Card maxCard;

        private void getCard(Poker.Card card) {
            this.cards.add(card);
        }

        private String maxCard() throws Exception{
            maxCardValue = 0;
            if (cards.size() == 0) {
                throw new Exception("No cards in player hand.");
            }
            for (Poker.Card card : cards) {
                if (maxCardValue < card.cardValue || (maxCardValue == card.cardValue && maxCard.cardColor.getValue() > card.cardColor.getValue())) {
                    maxCardValue = card.cardValue;
                    maxCard = card;
                }
            }
            return maxCard.toString();
        }
    }


    public static void main(String[] args) throws Exception {
        PokerGame pokerGame = new PokerGame();
        pokerGame.run();
    }

    private void run() throws Exception {
        Poker poker = new Poker();
        Player player1 = new Player(), player2 = new Player();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shuffle Poker Cards...");
        poker.shuffle();
        System.out.println("Done.");

        System.out.println("\nCreate players...");

        // create player 1
        System.out.println("Please input the ID number and Name of the first player:");
        System.out.println("Please input ID number:");
        player1.id = scanner.nextInt();
        System.out.println("Please input Name:");
        player1.name = scanner.next();

        // create player 2
        System.out.println("Please input the ID number and Name of the second player:");
        System.out.println("Please input ID number:");
        player2.id = scanner.nextInt();
        System.out.println("Please input Name:");
        player2.name = scanner.next();

        // start game
        System.out.println("\nWelcome player: "+player1.name);
        System.out.println("Welcome player: "+player2.name);
        System.out.println("Dealing cards...");
        System.out.println("Player: "+player1.name + " get a poker card");
        player1.getCard(poker.cards.get(0));
        System.out.println("Player: "+player2.name + " get a poker card");
        player2.getCard(poker.cards.get(1));
        System.out.println("Player: "+player1.name + " get a poker card");
        player1.getCard(poker.cards.get(2));
        System.out.println("Player: "+player2.name + " get a poker card");
        player2.getCard(poker.cards.get(3));
        System.out.println("Complete Dealing!\n");
        System.out.println("Game Start!");
        System.out.println("The largest poker card of "+player1.name + " is "+player1.maxCard());
        System.out.println("The largest poker card of "+player2.name + " is "+player2.maxCard());
        if (player1.maxCardValue > player2.maxCardValue || (player1.maxCardValue == player2.maxCardValue && player1.maxCard.cardColor.getValue() < player2.maxCard.cardColor.getValue())) {
            System.out.println("" + player1.name+ " win!");
        } else if (player1.maxCardValue < player2.maxCardValue) {
            System.out.println("" + player2.name+ " win!");
        }
        System.out.println("\nGame over.");
        System.out.println("The pokers card of players:");
        System.out.print(player1.name + " : ");
        System.out.println(player1.cards);
        System.out.print(player2.name + " : ");
        System.out.println(player2.cards);
    }
}
