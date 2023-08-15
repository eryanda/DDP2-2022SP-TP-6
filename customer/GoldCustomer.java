package customer;

import order.Order;
import java.time.LocalDate;

/**
 * Representasi seorang pelanggan berstatus "Gold" yang memiliki diskon khusus saat checkout.
 */
public class GoldCustomer extends Customer {
    static final double DISCOUNT_RATE = 0.85;

    /**
     * Membuat objek GoldCustomer baru dengan nama yang diberikan.
     * @param name Nama pelanggan Gold.
     */
    public GoldCustomer(String name) {
        super(name);
    }

    /**
     * Melakukan proses checkout dengan menerapkan diskon khusus untuk pelanggan Gold.
     */
    @Override
    public void checkout() {
        double totalDiscountedPrice = cart.getTotalPrice() * DISCOUNT_RATE;
        Order newOrder = new Order(cart, DISCOUNT_RATE, LocalDate.now(), totalDiscountedPrice);
        orderHistory.add(newOrder);
    }
}
