package order;

import java.util.ArrayList;

/**
 * Representasi dari keranjang belanja yang berisi daftar produk yang akan dibeli.
 */
public class Cart {
    private ArrayList<OrderItem> orderList;

    /**
     * Membuat objek Cart baru.
     */
    public Cart() {
        this.orderList = new ArrayList<>();
    }

    /**
     * Menghitung total harga dari semua produk dalam keranjang.
     * @return Total harga dari semua produk dalam keranjang.
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getFinalPrice();
        }
        return totalPrice;
    }

    /**
     * Menambahkan produk ke dalam keranjang.
     * @param orderItem Produk yang akan ditambahkan.
     */
    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    /**
     * Mengambil daftar produk dalam keranjang.
     * @return Daftar produk dalam keranjang.
     */
    public ArrayList<OrderItem> getOrderList() {
        return orderList;
    }
}
