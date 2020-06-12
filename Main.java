import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Necklace.necklace = new ArrayList<Stone>();
            Scanner scanner = new Scanner(new File("src\\PreciousStones.txt"));
            while (scanner.hasNext()) {
                Necklace.necklace.add(new PreciousStone(scanner.next(), scanner.nextByte(), scanner.nextFloat(), scanner.next()));
            }
            scanner.close();

            Scanner scanner1 = new Scanner(new File("src\\SemiPreciousStones.txt"));
            while (scanner1.hasNext()) {
                Necklace.necklace.add(new SemipreciousStone(scanner1.next(), scanner1.nextByte(), scanner1.nextFloat(), scanner1.next()));
            }
            scanner1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Necklace.necklace.removeIf(s -> s.getKarat() < 2 | s.getKarat() > 8);
        Collections.sort(Necklace.necklace);
        System.out.println();
        System.out.println(Necklace.necklace);

        System.out.print("Transparent stones in necklace: ");

        for (Stone s : Necklace.necklace) {
            if (s.transparency.contains("parent")) {
                System.out.print(s.getName() + ", ");
            }
        }

        Necklace.findTotalCost();
        Necklace.findTotalKarat();
    }
}

