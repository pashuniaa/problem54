public class Main {
    public static void main(String[] args) {
        Comparator c=new Comparator();
        c.calculateWins();
        System.out.println("First Player Wins Score: "+c.getFirstPlayerTotalScore());
        System.out.println("Second Player Wins Score: "+c.getSecondPlayerTotalScore());
    }
}