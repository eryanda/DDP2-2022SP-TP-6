package product.natural;

import product.Product;

/**
 * Representasi dari produk sayuran.
 */
public class Veggie extends Product {
    
    public boolean isOrganic;

    /**
     * Membuat objek Veggie baru dengan nama, harga, stok, dan status organik yang diberikan.
     * @param name Nama sayuran.
     * @param price Harga sayuran.
     * @param stok Stok sayuran.
     * @param isOrganic Status organik sayuran.
     */
    public Veggie(String name, int price, int stok, boolean isOrganic) {
        super(name, price, stok);
        this.isOrganic = isOrganic;
    }

    /**
     * Memeriksa diskon yang berlaku berdasarkan kuantitas pembelian.
     * @param quantity Kuantitas pembelian.
     * @return Persentase diskon yang berlaku.
     */
    public int checkDiscount(int quantity) {
        if (this.isOrganic) {
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
