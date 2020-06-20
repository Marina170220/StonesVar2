import java.util.*;

public interface DialogBox {

    Collection<Stone> chooseStoneType(ArrayList<Stone> list1, ArrayList<Stone> list2, ArrayList<Stone> list3);

    void selectedStones(ArrayList<Stone> c);
}
