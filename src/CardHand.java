import java.util.ArrayList;
import java.util.List;

public class CardHand {
    List<Card> cardHand=new ArrayList<>();
    //Can we get ENUMs element's index?
    //or we could use array with ascending elements

    public CardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    public List<Card> getCardHand() {
        return cardHand;
    }

    //HERE WE WILL WRITE METHODS TO FIND OUT
    //WHAT COMBINATION OF CARDS THE HAND HAS

    //WE SHOULD ALSO CREATE THE SORTED ARRAY TO GET THE HIGHEST RANK CARD
    //IN CASE BOTH OPPONENTS HAVE THE SAME COMBINATIONS

    //Kaip mes realiam gyvenime matom kokia kombinacija turim?
    //1. Mes zinome jog kortu galia priklauso nuo ju indekso (1-14)
    //2. mes galime suzinoti kiek kartu pasikartoja kiekvienos kortos indeksas(rank)
    //3. mes galime suzinoti kiek kartu pasikartoja kortos spalva (suite)
    //4. galima sukurti kiekvienai spalvai ir kiekvienam rank po kintamaji counter, arba array[14] counter, kur kiekvienas indeksas saugos
    // kortos pasikartojima
    //5. galiausiai is viso masyvo isrinksime indeksa sauganti 3 pasikartojimus, arba 2 pasikartojimus, arba 2 poras po 2 pasikartojimus ir tt
    //6.

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    //clubs (♣), diamonds (♦), hearts (♥) and spades (♠).
    //            High Card: Highest value card.
    //    One Pair: Two cards of the same value.
    //    Two Pairs: Two different pairs.
    //    Three of a Kind: Three cards of the same value.
    //    Straight: All cards are consecutive values.
    //    Flush: All cards of the same suit.
    //    Full House: Three of a kind and a pair.
    //    Four of a Kind: Four cards of the same value.
    //    Straight Flush: All cards are consecutive values of same suit.
    //    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

    //create a method to check what combination is at current hand


    @Override
    public String toString() {
        return "CardHand{" +
                "cardHand=" + cardHand +
                '}';
    }
}
