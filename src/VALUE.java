public enum VALUE {
    //2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    T(10),
    J(11),
    Q(12),
    K(13),
    A(14);

    int valueNumber;

    VALUE(int valueNumber) {
        this.valueNumber = valueNumber;
    }

}