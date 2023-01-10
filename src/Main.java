import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, List<Hand>> pokerHands = FileParser.getHands("poker");
        List<Hand> playerHands = pokerHands.get("secondPlayerHands");

        for (Hand h:playerHands) {
            List<Card> playerCards=h.getCardHand();
            System.out.println("\n"+playerCards);
            Hand.getHandRank(playerCards);
        }
    }
}