package order;

import java.time.LocalDate;

/**
 * Representasi dari pesanan yang dibuat oleh pelanggan.
 */
public class Order {
    private Cart cart;
    private double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    /**
     * Membuat objek Order baru.
     * @param cart Keranjang yang berisi produk untuk pesanan.
     * @param discountRate Tingkat diskon yang diterapkan pada pesanan.
     * @param orderDate Tanggal pesanan dibuat.
     * @param totalPrice Total harga pesanan sebelum diskon.
     */
    public Order(Cart cart, double discountRate, LocalDate orderDate, double totalPrice) {
        this.cart = cart;
        this.discountRate = discountRate;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    /**
     * Menghitung harga akhir dari pesanan setelah diskon.
     * @return Harga akhir pesanan setelah diskon.
     */
    public double getFinalPrice() {
        return totalPrice * (100 - discountRate) / 100;
    }

    /**
     * Mengurangi stok semua item dalam pesanan dari inventaris.
     */
    public void decreaseStockAllItem() {
        // Implementasi pengurangan stok dari inventaris
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
