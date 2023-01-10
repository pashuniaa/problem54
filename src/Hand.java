import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
    List<Card> cardHand = new ArrayList<>();

    public Hand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    public List<Card> getCardHand() {
        return cardHand;
    }

    public static Map<String, List<Card>> getGroupedCards(List<Card> playerHandCards) {
        return playerHandCards.stream().collect(Collectors.groupingBy(Card::getCardRank));
    }

    public static RANK getHandRank(List<Card> playerHandCards) {
        RANK handRank = RANK.HIGH_CARD;
        Map<String, List<Card>> groupedCards=getGroupedCards(playerHandCards);

        List<Integer> sortedCardRanks = getSortedHandRanks(groupedCards);
        System.out.println("SORTED CARD RANK!");
        System.out.println(sortedCardRanks);

        int HIGH_CARD_RANK = Collections.max(sortedCardRanks);

        //CHECK FOR ROYAL FLUSH ==> STRAIGHT FLUSH ==> FLUSH ==> STRAIGHT
        if (groupedCards.size() == 5) {
            if (checkStraight(sortedCardRanks) && checkFlush(groupedCards)) {
                handRank = RANK.STRAIGHT_FLUSH;
                if (Collections.min(sortedCardRanks) == 10 && Collections.max(sortedCardRanks) == 14) {
                    handRank = RANK.ROYAL_FLUSH;
                }
            } else if (checkFlush(groupedCards)) handRank = RANK.FLUSH;
            else if (checkStraight(sortedCardRanks)) handRank = RANK.STRAIGHT;
        }
        //CHECK FOR FLUSH ==> FLUSH ==> PAIR
        else if (groupedCards.size() == 4) {
            if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
            } else {
                handRank = RANK.PAIR;
            }
        }
        //CHECK FOR FLUSH ==> THREE OF A KIND ==> TWO PAIRS
        else if (groupedCards.size() == 3) {
            if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
            } else {
                int twoPairsCounter = 0;
                List<Card> firstTwoCards = new ArrayList<>();

                for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
                    if (entry.getValue().size() == 3) {
                        handRank = RANK.THREE_OF_A_KIND;
                    } else if (entry.getValue().size() == 2) {
                        if (twoPairsCounter == 0) {
                            firstTwoCards = entry.getValue();
                            twoPairsCounter += 1;
                        }
                        if (entry.getValue() != firstTwoCards && twoPairsCounter == 1) {
                            handRank = RANK.TWO_PAIRS;
                        }
                    }
                }
            }

        }
        //CHECK FOR FOUR OF A KIND ==> FULL HOUSE ==> FLUSH
        else if (groupedCards.size() == 2) {
            int counter = 0;
            List<Card> firstCards = new ArrayList<>();

            for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
                if (entry.getValue().size() == 4) {
                    handRank = RANK.FOUR_OF_A_KIND;
                } else if (entry.getValue().size() == 2 || entry.getValue().size() == 3) {
                    if (counter == 0) {
                        counter += 1;
                        firstCards = entry.getValue();
                    }
                    if (entry.getValue() != firstCards && counter == 1) {
                        handRank = RANK.FULL_HOUSE;
                    }
                } else if (checkFlush(groupedCards)) handRank = RANK.FLUSH;
            }

        }
        //HIGH CARD
        else {
            System.out.println("High card's value is " + HIGH_CARD_RANK);
            handRank = RANK.HIGH_CARD;
        }

        System.out.println("HAND'S RANK: " + handRank);

        return handRank;
    }

    public static boolean checkStraight(List<Integer> sortedCards) {
        for (int i = 1; i < sortedCards.size(); i++) {
            if (sortedCards.get(i) != sortedCards.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFlush(Map<String, List<Card>> groupedCards) {
        List<Card> getAllCards = new ArrayList<>();
        for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
            getAllCards.addAll(entry.getValue());
        }

        String suit = getAllCards.get(0).getCardSuite();
        for (Card c : getAllCards) {
            if (!c.getCardSuite().equals(suit)){
                System.out.println("Current card's suit: "+c.getCardSuite()+" is not equal to suit "+suit);
                return false;
            }
        }

        System.out.println("HAND's SUIT: "+suit);
        return true;
    }

    public static List<Integer> getSortedHandRanks(Map<String, List<Card>> groupedCards) {

        List<Card> getAllCards = new ArrayList<>();
        for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
            getAllCards.addAll(entry.getValue());
        }

        List<Integer> ranksToInt = new ArrayList<>();

        for (Card c : getAllCards) {
            if (c.getCardRank().equals("T")) ranksToInt.add(10);
            else if (c.getCardRank().equals("J")) ranksToInt.add(11);
            else if (c.getCardRank().equals("Q")) ranksToInt.add(12);
            else if (c.getCardRank().equals("K")) ranksToInt.add(13);
            else if (c.getCardRank().equals("A")) ranksToInt.add(14);
            else ranksToInt.add(Integer.parseInt(c.getCardRank()));
        }
        Collections.sort(ranksToInt);
        return ranksToInt;
    }

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        return cardHand.get(0).toString() + " " +
                cardHand.get(1).toString() + " " +
                cardHand.get(2).toString() + " " +
                cardHand.get(3).toString() + " " +
                cardHand.get(4).toString();
    }
}
