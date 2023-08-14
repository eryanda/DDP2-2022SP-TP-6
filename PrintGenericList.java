import java.util.ArrayList;
import java.util.List;

import order.Order;

public class PrintGenericList<T> {

    public void printToConsole(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

	public void printToConsole(ArrayList<Order> orderHistory) {
	}
}
