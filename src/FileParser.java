import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

    //Nuskaitome faila
    //pagal kiekviena reiksmiu pora sukuriam CARD objekta
    //kai sukuriam 5 CARD objektus, sukuriam HAND objekta
    //idedam paeiliui kiekviena CARD objekta i HAND objekto ArrayLista


    //CIA TURI BUTI HASHMAPAS saugantis po abieju zaideju arraylista
    //DAR GERIAU- naudojam du arraylistus po viena kiekvienam playeriui
    //ta arraylista gales pagettint calculate klase

    List<ArrayList<String>> firstPlayerHands=new ArrayList<>();
    List<ArrayList<String>> secondPlayerHands=new ArrayList<>();

    public static void getHands(String fileName){
        try {
            File myObj = new File("src/poker.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String row = myReader.nextLine();
                //Isskaidyti gauta stringa i 10 poru pagal tarpus
                String[] splitRowItems = row.split("\\s");
                //Gauname 10 splitintu reiksmiu
                //pirmas 5 reiksmes irasyti i viena Lista, kitas 5 i kita
                ArrayList<String> firstHand=new ArrayList<>();
                ArrayList<String> secondHand=new ArrayList<>();

                for (int i = 0; i < splitRowItems.length; i++) {

                    if(i<5){
                        firstHand.add(splitRowItems[i]);
                        continue;
                    }
                    secondHand.add(splitRowItems[i]);
                }

                firstPlayerHands.add(firstHand);
                secondPlayerHands.add(secondHand);
            }
            System.out.println("Extracted "+firstPlayerHands.size()+" player hand pairs\n");
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
