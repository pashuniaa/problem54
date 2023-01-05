import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
    List<Card> cardHand=new ArrayList<>();

    public Hand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    public List<Card> getCardHand() {
        return cardHand;
    }

    public static Map<String, List<Card>> getGroupedCards(List<Card> playerHandCards){
        //We will use the key to check which players hand is stronger, if they both have the same rank
        return playerHandCards.stream().collect(Collectors.groupingBy(Card::getCardRank));
    }

    //WE SHOULD ALSO CREATE THE SORTED ARRAY TO GET THE HIGHEST RANK CARD
    //IN CASE BOTH OPPONENTS HAVE THE SAME COMBINATIONS

    public static RANK rank(Map<String, List<Card>> playerCards){
        RANK handRank=RANK.HIGH_CARD;
        //?????????????????????

        return handRank;
    }

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        return cardHand.get(0).toString()+" "+
                cardHand.get(1).toString()+" "+
                cardHand.get(2).toString()+" "+
                cardHand.get(3).toString()+" "+
                cardHand.get(4).toString();
    }
}
