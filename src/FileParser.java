import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileParser {
    public static Map<String, List<Hand>> getHands(String fileName) {

        Map<String, List<Hand>> map = new HashMap();
        List<Hand> firstPlayerHands = new ArrayList<>();
        List<Hand> secondPlayerHands = new ArrayList<>();

        try {
            File myObj = new File("src/" + fileName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String row = myReader.nextLine();
                String[] splitRowItems = row.split("\\s");

                ArrayList<Card> firstHand = new ArrayList<>();
                ArrayList<Card> secondHand = new ArrayList<>();

                for (int i = 0; i < splitRowItems.length; i++) {
                    if (i < 5) {
                        firstHand.add(new Card(String.valueOf(splitRowItems[i].charAt(0)), String.valueOf(splitRowItems[i].charAt(1))));
                        continue;
                    }
                    secondHand.add(new Card(String.valueOf(splitRowItems[i].charAt(0)), String.valueOf(splitRowItems[i].charAt(1))));
                }

                firstPlayerHands.add(new Hand(firstHand));
                secondPlayerHands.add(new Hand(secondHand));
            }
            map.put("firstPlayerHands", firstPlayerHands);
            map.put("secondPlayerHands", secondPlayerHands);

            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return map;
    }
}
