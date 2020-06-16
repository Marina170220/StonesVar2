import java.util.LinkedList;

public class Necklace {

    float totalCost;
    int totalKarat;
    LinkedList<Stone> necklace;

    Necklace(float totalCost, int totalKarat) {
        this.totalCost = totalCost;
        this.totalKarat = totalKarat;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalKarat() {
        return totalKarat;
    }

    public void setTotalKarat(int totalKarat) {
        this.totalKarat = totalKarat;
    }

}
