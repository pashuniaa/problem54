public enum SUIT {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String initial;

    SUIT(String initial) {
        this.initial=initial;
    }

    @Override
    public String toString() {
        return "SUIT{" +
                "initial='" + initial + '\'' +
                '}';
    }
}
