import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //clubs (♣), diamonds (♦), hearts (♥) and spades (♠).

        //There is a file poker.txt which contains 1000 rows of 2 players card hands
        //There are 10 cards in a row, 5 cards of the 1st player and another 5 of the 2nd player

        //1. we have to read first 5 cards and assign them to the first player, do the same for another 5 cards
        //and assign them to the 2nd player
        //We have to create a method for every win case (2 of a kind, 3, straight, flush, full house, etc.)
        //it may be a single method, which checks the cards with the switch statement
        //2. After the hands are assigned to the players, and we find out what combination each player has,
        //we compare those combinations. If both players occur to have the same combination, wins the one with the highest card
        //3. Now we add +1 point to the winner, and after EOF we print out who won more games

        //Map<ArrayList<String>, ArrayList<String>> cardHands = new HashMap<>();



        //Sort player's hand, to figure out what combination does he have

        //clubs (♣), diamonds (♦), hearts (♥) and spades (♠).

        //NEW IDEA
        //create a method to check the frequency of a card's rank
        //then there will be a method for one pair, two pairs, three of a kind, and all of them will call our frequency method, which will tell them whether
        //we have got our combination or not

        //High Card: Highest value card.
        //SOLUTION: If no other combination is present OR both players have the same hands, we sort each player's hand by its card rank

        //    One Pair: Two cards of the same value.
        //SOLUTION: We create an array of card string's first letters, then sort our array so that the repeating values would follow one another,
        //          then we cycle through our sorted array , on the very first iteration we add +1 to our int counter, if another value is the same as the current one,
        //          we set our boolean onePair= true; if it's not, we set our counter to 0

        //    Two Pairs: Two different pairs.
        //SOLUTION:

        //    Three of a Kind: Three cards of the same value.
        //SOLUTION:

        //    Straight: All cards are consecutive values.
        //SOLUTION:

        //    Flush: All cards of the same suit.
        //SOLUTION:

        //    Full House: Three of a kind and a pair.
        //SOLUTION:

        //    Four of a Kind: Four cards of the same value.
        //SOLUTION:

        //    Straight Flush: All cards are consecutive values of same suit.
        //SOLUTION:

        //    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
        //SOLUTION:


        //8C TS KC 9H 4S      7D 2S 5D 3S AC


    }
}