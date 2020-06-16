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
    public Map<Stone, Integer> selectedStones(ArrayList<Stone> collection) {

        Map<Stone, Integer> selectedStones = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        float totalCost = 0;
        int totalKarat = 0;
        int totalStonesAmount = 0;
        String answer = "";
        Stone selectedStone;

        do {
            System.out.println("Enter a stone");
            String stoneName = scanner.next().trim();
            System.out.println("Enter stones amount");
            Integer stoneAmount = scanner.nextInt();

            for (Stone stone : collection) {
                if (stone.getName().regionMatches(true, 0, stoneName, 0, 3)) {
                    selectedStones.put(stone, stoneAmount);
                    selectedStone = stone;
                    totalStonesAmount += stoneAmount;
                    System.out.println("You've chosen " + selectedStone.getName());
                    totalCost += selectedStone.getStonePrice() * stoneAmount;
                    System.out.println("\nNecklace cost is " + totalCost + " $");
                    totalKarat += selectedStone.getKarat() * stoneAmount;
                    System.out.println("\nNecklace total weight is " + totalKarat + " karats");
                }
            }
            System.out.println("Do you want to add more stones?\nY/N");
            answer = scanner.next().trim().toLowerCase();
        }

        while (answer.contains("y"));
        System.out.println("Your necklace contains " + totalStonesAmount + " stones, including\n" + selectedStones);
        return selectedStones;
    }
}




