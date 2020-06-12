import java.util.List;

public class Necklace {

    static float totalCost;
    static int totalKarat;
    static List<Stone> necklace;

    Necklace(float totalCost, int totalKarat){
        Necklace.totalCost =totalCost;
        Necklace.totalKarat =totalKarat;
    }
    static void findTotalCost (){
        for(Stone s: necklace) {
            totalCost += s.getStonePrice();
        }
        System.out.println("\nNecklace cost is " + totalCost + " $");
    }

    static void findTotalKarat (){
        for (Stone s: necklace) {
            totalKarat += s.getKarat();
        }
        System.out.println("\nNecklace total weight is " + totalKarat + " karats");
    }
}
