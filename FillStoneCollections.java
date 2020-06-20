import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FillStoneCollections {

    ArrayList<Stone> fillPreciousStonesCollection() {
        ArrayList<Stone> preciousStoneCollection = new ArrayList<>();
        Scanner scanner;
        {
            try {
                scanner = new Scanner(new File("src\\PreciousStones.txt"));
                while (scanner.hasNext()) {
                    preciousStoneCollection.add(new Stone(scanner.next(), scanner.nextByte(), scanner.nextFloat(), scanner.next()));
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return preciousStoneCollection;
    }

    ArrayList<Stone> fillSemipreciousStonesCollection() {
        ArrayList<Stone> semipreciousStoneCollection = new ArrayList<>();
        Scanner scanner;
        {
            try {
                scanner = new Scanner(new File("src\\SemiPreciousStones.txt"));
                while (scanner.hasNext()) {
                    semipreciousStoneCollection.add(new Stone(scanner.next(), scanner.nextByte(), scanner.nextFloat(), scanner.next()));
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return semipreciousStoneCollection;
        }
    }

    ArrayList<Stone> fillAllStonesCollection() {
        ArrayList<Stone> collectionStone = new ArrayList<>();
        collectionStone.addAll(fillSemipreciousStonesCollection());
        collectionStone.addAll(fillPreciousStonesCollection());
        Collections.sort(collectionStone);
        return collectionStone;
    }
}
