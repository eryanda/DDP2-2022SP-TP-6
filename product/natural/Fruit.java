package product.natural;

import product.Product;

/**
 * Representasi dari produk buah.
 */
public class Fruit extends Product {
    public boolean isLocal;

    /**
     * Membuat objek Fruit baru dengan nama, harga, stok, dan status lokal yang diberikan.
     * @param name Nama buah.
     * @param price Harga buah.
     * @param stok Stok buah.
     * @param isLocal Status lokal buah.
     */
    public Fruit(String name, int price, int stok, boolean isLocal) {
        super(name, price, stok);
        this.isLocal = isLocal;
    }

    /**
     * Memeriksa diskon yang berlaku berdasarkan kuantitas pembelian.
     * @param quantity Kuantitas pembelian.
     * @return Persentase diskon yang berlaku.
     */
    public int checkDiscount(int quantity) {
        if (this.isLocal) {
            if (quantity >= 5)
                return 30;
            else if (quantity >= 3)
                return 20;
        } else {
            if (quantity >= 5)
                return 20;
            else if (quantity >= 3)
                return 15;
        }
        return 0;
    }
}
