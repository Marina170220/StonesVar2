import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Stone> collectionStone;
    static ArrayList<Stone> preciousStoneCollection;
    static ArrayList<Stone> semipreciousStoneCollection;

    public static void main(String[] args) {
        collectionStone = new ArrayList<>();
        preciousStoneCollection = new ArrayList<>();
        semipreciousStoneCollection = new ArrayList<>();
        Selection selector = new Selection();

        try {
            Scanner scanner = new Scanner(new File("src\\PreciousStones.txt"));
            while (scanner.hasNext()) {
                preciousStoneCollection.add(new Stone(scanner.next(), scanner.nextByte(), scanner.nextFloat(), scanner.next()));
            }
            scanner.close();

            Scanner scanner1 = new Scanner(new File("src\\SemiPreciousStones.txt"));
            while (scanner1.hasNext()) {
                semipreciousStoneCollection.add(new Stone(scanner1.next(), scanner1.nextByte(), scanner1.nextFloat(), scanner1.next()));
            }
            scanner1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        collectionStone.addAll(preciousStoneCollection);
        collectionStone.addAll(semipreciousStoneCollection);
        Collections.sort(collectionStone);
        System.out.println(collectionStone);

        selector.selectedStones(selector.chooseStoneType());
    }
}
