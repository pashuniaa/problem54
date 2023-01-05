public enum RANK {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    //    High Card: Highest value card.
    //    One Pair: Two cards of the same value.
    //    Two Pairs: Two different pairs.
    //    Three of a Kind: Three cards of the same value.
    //    Straight: All cards are consecutive values.
    //    Flush: All cards of the same suit.
    //    Full House: Three of a kind and a pair.
    //    Four of a Kind: Four cards of the same value.
    //    Straight Flush: All cards are consecutive values of same suit.
    //    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

    private final int rank;

    RANK(int rank) {
        this.rank = rank;
    }
}
