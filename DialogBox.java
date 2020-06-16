import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface DialogBox {

    Collection<Stone> chooseStoneType();
    //void showStonesList(String stoneType);
    Map<Stone, Integer> selectedStones(ArrayList <Stone> c);
}
