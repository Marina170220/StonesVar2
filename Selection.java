import java.util.*;

public class Selection implements DialogBox {

    @Override
    public ArrayList<Stone> chooseStoneType() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose stone type\nPrecious\nSemiprecious\nShow all");
        String stoneType = scanner.next().trim().toLowerCase();

        if (stoneType.contains("semi")) {
            System.out.println(Main.semipreciousStoneCollection);
            return Main.semipreciousStoneCollection;
        } else if (stoneType.contains("all")) {
            System.out.println(Main.collectionStone);
            return Main.collectionStone;
        } else {
            System.out.println(Main.preciousStoneCollection);
            return Main.preciousStoneCollection;
        }
    }

    @Override
    public void selectedStones(ArrayList<Stone> collection) {

        TreeMap<Stone, Integer> selectedStones = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        float totalCost = 0;
        int totalKarat = 0;
        int totalStonesAmount = 0;
        String answer;
        Stone electedStone;
        int counter;

        LinkedList<Stone> necklace = new LinkedList<>();
        do {
            System.out.println("Enter a stone");
            String stoneName = scanner.next().trim();
            System.out.println("Enter stones amount");
            Integer stoneAmount = scanner.nextInt();

            for (Stone stone : collection) {
                if (stone.getName().regionMatches(true, 0, stoneName, 0, 3)) {
                    selectedStones.put(stone, stoneAmount);
                    electedStone = stone;
                    totalStonesAmount += stoneAmount;
                    System.out.println("You've chosen " + electedStone.getName());
                    totalCost += electedStone.getStonePrice() * stoneAmount;
                    System.out.println("\nNecklace cost is " + totalCost + " $");
                    totalKarat += electedStone.getKarat() * stoneAmount;
                    System.out.println("\nNecklace total weight is " + totalKarat + " karats");
                }
            }
            System.out.println("Do you want to add more stones?\nY/N");
            answer = scanner.next().trim().toLowerCase();
        }

        while (answer.contains("y"));
        System.out.println("Your selectedStones contains " + totalStonesAmount + " stones, including\n" + selectedStones);

        counter = 0;
        while (counter <= totalStonesAmount) {
            for (Stone stone : selectedStones.descendingKeySet()) {
                for (int k = 0; k < selectedStones.get(stone) / 2; k++) {
                    necklace.addLast(selectedStones.ceilingKey(stone));
                    counter += selectedStones.get(stone) / 2;
                }
                for (int k = selectedStones.get(stone) / 2; k < selectedStones.get(stone); k++) {
                    necklace.addFirst(selectedStones.ceilingKey(stone));
                    counter += selectedStones.get(stone) / 2;
                }
            }
        }
        System.out.println("Your necklace\n " + necklace.toString());
    }
}






