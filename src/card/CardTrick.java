/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        Random rand = new Random();

        // Fill magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // 1 to 13
            c.setSuit(suits[rand.nextInt(suits.length)]); // Random suit
            magicHand[i] = c;

            // Print card as: Suit Value
            System.out.println(c.getSuit() + " " + c.getValue());
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a card value (1–13): ");
        int userValue = input.nextInt();

        System.out.print("Enter a suit (0–3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = input.nextInt();
        String userSuit = suits[suitIndex];

        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userValue && c.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("You found your card in the magic hand! 🎉");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}

