package order;

import product.Product;

/**
 * Representasi dari item dalam pesanan yang berisi informasi produk dan kuantitasnya.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    /**
     * Membuat objek OrderItem baru dengan produk dan kuantitas yang diberikan.
     * @param product Produk yang akan dipesan.
     * @param quantity Kuantitas produk yang akan dipesan.
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    };

    /**
     * Menghitung harga final dari item pesanan setelah diterapkan diskon produk.
     * @return Harga final dari item pesanan.
     */
    public double getFinalPrice() {
        double discount = this.product.checkDiscount(this.quantity);
        double price = (double) this.product.getPrice() * this.quantity;

        return (price * (100 - discount) / 100);
    }

    /**
     * Mengambil produk dari item pesanan.
     * @return Produk dari item pesanan.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Mengambil kuantitas dari item pesanan.
     * @return Kuantitas dari item pesanan.
     */
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return String.format("%s  %d kg  %f", this.product.getName(), this.quantity, this.getFinalPrice());
    }
}
