public class Card {
    String cardRank;
    String cardSuite;

    public Card(String cardRank, String cardSuite) {
        this.cardRank = cardRank;
        this.cardSuite = cardSuite;
    }

    public String getCardRank() {
        return cardRank;
    }

    public void setCardRank(String cardRank) {
        this.cardRank = cardRank;
    }

    public String getCardSuite() {
        return cardSuite;
    }

    public void setCardSuite(String cardSuite) {
        this.cardSuite = cardSuite;
    }
}
