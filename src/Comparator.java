import java.util.*;

public class Comparator {
    long firstPlayerTotalScore=0;
    long secondPlayerTotalScore=0;
    //How many hands does Player 1 win?

    private TreeMap<RANK, List<Integer>> getSortedHandAndRank(List<Card> playerHand) {
        System.out.println("\n" + playerHand);

        Map<RANK, List<Integer>> handMap = Hand.getSortedHandByRank(playerHand);
        RANK rank = RANK.HIGH_CARD;
        List<Integer> cards = new ArrayList<>();

        for (Map.Entry<RANK, List<Integer>> entry : handMap.entrySet()) {
            rank = entry.getKey();
            cards.addAll(entry.getValue());
        }

        System.out.println("SORTED CARDS: " + cards);
        System.out.println("HAND'S RANK: " + rank);

        TreeMap<RANK, List<Integer>> result=new TreeMap<>();
        result.put(rank, cards);

        return result;
    }

    public void calculateWins() {
        int firstPlayerWins = 0;
        int secondPlayerWins = 0;

        Map<String, List<Hand>> pokerHands = FileParser.getHands("poker");
        List<Hand> firstPlayerHands = pokerHands.get("firstPlayerHands");
        List<Hand> secondPlayerHands = pokerHands.get("secondPlayerHands");

        for (int i = 0; i < firstPlayerHands.size(); i++) {
            TreeMap<RANK, List<Integer>> firstPlayerHandRank=getSortedHandAndRank(firstPlayerHands.get(i).getCardHand());
            TreeMap<RANK, List<Integer>> secondPlayerHandRank=getSortedHandAndRank(secondPlayerHands.get(i).getCardHand());

            if(firstPlayerHandRank.firstKey().getRank() > secondPlayerHandRank.firstKey().getRank()){
                firstPlayerWins+=1;
            }
            else if(firstPlayerHandRank.firstKey().getRank() == secondPlayerHandRank.firstKey().getRank()){
                List<Integer> firstPlayerCards=firstPlayerHandRank.firstEntry().getValue();
                List<Integer> secondPlayerCards=secondPlayerHandRank.firstEntry().getValue();

                for (int j = firstPlayerCards.size()-1; j > 0; j--) {
                    if(firstPlayerCards.get(j) > secondPlayerCards.get(j)){
                        firstPlayerWins+=1;
                        break;
                    }
                    else if(firstPlayerCards.get(j) < secondPlayerCards.get(j)){
                        secondPlayerWins+=1;
                        break;
                    }
                }
            }
            else{
                secondPlayerWins+=1;
            }

            if(firstPlayerWins > secondPlayerWins){
                setFirstPlayerTotalScore(getFirstPlayerTotalScore()+1);
                System.out.println("\nFirst Player WINS!!!");
            }
            else if(firstPlayerWins < secondPlayerWins){
                setSecondPlayerTotalScore(getSecondPlayerTotalScore()+1);
                System.out.println("\nSecond Player WINS!!!");
            }
            else System.out.println("DRAW");

            firstPlayerWins=0;
            secondPlayerWins=0;
        }
        System.out.println("\n");
    }

    public long getFirstPlayerTotalScore() {
        return firstPlayerTotalScore;
    }

    public void setFirstPlayerTotalScore(long firstPlayerTotalScore) {
        this.firstPlayerTotalScore = firstPlayerTotalScore;
    }

    public long getSecondPlayerTotalScore() {
        return secondPlayerTotalScore;
    }

    public void setSecondPlayerTotalScore(long secondPlayerTotalScore) {
        this.secondPlayerTotalScore = secondPlayerTotalScore;
    }
}
