import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;

public class Main {
    public static void main(String[] args) {

        //1. gauname mapa su abieju zaideju handais
        Map<String, List<Hand>> pokerHands = FileParser.getHands("poker");
        //2. gauname pasirinkto zaidejo konkretaus HAND kortu lista
        List<Card> secondPlayerHands = pokerHands.get("secondPlayerHands").get(19).getCardHand();
        //3. ta lista paduodame i metoda getGroupedCards, jis mums grazins sumappintas kortas

        List<Card> dummyCards = new ArrayList<>();
        dummyCards.add(new Card("3", "D"));
        dummyCards.add(new Card("3", "D"));
        dummyCards.add(new Card("5", "D"));
        dummyCards.add(new Card("5", "D"));
        dummyCards.add(new Card("5", "D"));

        //Kai paskutine korta A(14) irgi meta kad straight, FIX!!!!!!!!!!!!!!!!!!!!!
//        dummyCards.add(new Card("2", "C"));
//        dummyCards.add(new Card("3", "D"));
//        dummyCards.add(new Card("4", "S"));
//        dummyCards.add(new Card("5", "D"));
//        dummyCards.add(new Card("A", "D"));

        Map<String, List<Card>> groupedCards = Hand.getGroupedCards(dummyCards);
        //Printing
        for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
            System.out.println("Rank = " + entry.getKey() + ", Cards = " + entry.getValue());
        }

        //GET SORTED CARD OBJECTS !!!!!!!!!!!!!!!!!!!!!!!!!!!!
        List<Integer> sortedCardRanks = getSortedHandRanks(groupedCards);
        System.out.println("OUR SORTED CARD RANKS!");
        System.out.println(sortedCardRanks);

        RANK handRank = RANK.HIGH_CARD;
        int HIGH_CARD_RANK;

        //ATTENTION DABAR PADARYTA JOG PAIR, TWO PAIRS, 3oak, 4oak yra galingesni uz FLUSH, turi buti atvirksciai
        //SUSIZIUREK RANK eiliskuma, visos kombinacijos yra viena uz kita galingenses
        if (groupedCards.size() == 5) {
            if (checkStraight(sortedCardRanks)) {
                if (checkFlush(groupedCards)) {
                    if (Collections.min(sortedCardRanks).equals(10)
                            && Collections.max(sortedCardRanks).equals(14)) {
                        handRank = RANK.ROYAL_FLUSH;
                        System.out.println(handRank);
                    } else {
                        handRank = RANK.STRAIGHT_FLUSH;
                        System.out.println(handRank);
                    }
                } else {
                    handRank = RANK.STRAIGHT;
                    System.out.println(handRank);
                }
            } else if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
                System.out.println(handRank);
            }
        } else if (groupedCards.size() == 4) {
            if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
                System.out.println(handRank);
            } else {
                handRank = RANK.PAIR;
                System.out.println(handRank);
            }
        } else if (groupedCards.size() == 3) {
            if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
                System.out.println(handRank);
            } else {
                int twoPairsCounter = 0;
                List<Card> firstTwoCards = new ArrayList<>();

                for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
                    if (entry.getValue().size() == 3) {
                        handRank = RANK.THREE_OF_A_KIND;
                        System.out.println(handRank);
                    } else if (entry.getValue().size() == 2) {
                        if (twoPairsCounter == 0) {
                            firstTwoCards = entry.getValue();
                            twoPairsCounter += 1;
                        }
                        if (entry.getValue() != firstTwoCards && twoPairsCounter == 1) {
                            handRank = RANK.TWO_PAIRS;
                            System.out.println(handRank);
                        }
                    }
                }
            }

        } else if (groupedCards.size() == 2) {
            if (checkFlush(groupedCards)) {
                handRank = RANK.FLUSH;
                System.out.println(handRank);
            } else {
                int counter = 0;
                List<Card> firstCards = new ArrayList<>();

                for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
                    if (entry.getValue().size() == 4) {
                        handRank = RANK.FOUR_OF_A_KIND;
                        System.out.println(handRank);
                    } else if (entry.getValue().size() == 2 || entry.getValue().size() == 3) {
                        if (counter == 0) {
                            counter += 1;
                            firstCards = entry.getValue();
                        }
                        if (entry.getValue() != firstCards && counter == 1) {
                            handRank = RANK.FULL_HOUSE;
                            System.out.println(handRank);
                        }
                    }
                }
            }
        }
        //HIGH CARD
        else {
            HIGH_CARD_RANK = Collections.max(sortedCardRanks);
            handRank = RANK.HIGH_CARD;
        }
    }

    public static boolean checkStraight(List<Integer> sortedCards) {
        //===============================================================
        //            The cards are valued in the order:
        //            2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
        //===============================================================
        // SO WE ASSUME THAT ACE CAN NOT BE AT THE START OF THE STRAIGHT SEQUENCE
        for (int i = 1; i < 4; i++) {
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
            if (c.getCardSuite() != suit) return false;
        }

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
}