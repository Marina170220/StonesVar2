
public class Main {

    public static void main(String[] args) {
        Selection selector = new Selection();
        FillStoneCollections fillCollection = new FillStoneCollections();

        selector.selectedStones(selector.chooseStoneType(fillCollection.fillSemipreciousStonesCollection(), fillCollection.fillAllStonesCollection(), fillCollection.fillPreciousStonesCollection()));
    }
}
