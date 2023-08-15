package customer;

import product.Product;

/**
 * Interface yang menggambarkan kemampuan untuk berbelanja.
 */
public interface CanShop {

    /**
     * Menambahkan produk dengan kuantitas tertentu ke dalam keranjang belanja.
     * @param product Produk yang akan ditambahkan.
     * @param quantity Kuantitas produk yang akan ditambahkan.
     */
    public void addToCart(Product product, int quantity);

    /**
     * Melakukan proses checkout atau pembayaran untuk produk yang ada di keranjang.
     */
    public void Checkout();
}
