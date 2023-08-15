import java.util.ArrayList;
import java.util.List;
import order.Order;

/**
 * Kelas utilitas untuk mencetak isi dari daftar generik ke konsol.
 * @param <T> Tipe data dari elemen-elemen dalam daftar.
 */
public class PrintGenericList<T> {

    /**
     * Mencetak elemen-elemen dalam daftar ke konsol.
     * @param list Daftar generik yang akan dicetak.
     */
    public void printToConsole(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    /**
     * Mencetak riwayat pesanan ke konsol.
     * @param orderHistory Daftar pesanan yang akan dicetak.
     */
    public void printToConsole(ArrayList<Order> orderHistory) {
        for (Order order : orderHistory) {
            System.out.println(order.toString());  // Assuming Order class has a proper toString() method
        }
    }
}
