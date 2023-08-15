package product;

/**
 * Representasi umum dari produk.
 */
public abstract class Product {
    public String name;
    public int price;
    public int stock;

    /**
     * Membuat objek Product baru dengan nama, harga, dan stok yang diberikan.
     * @param name Nama produk.
     * @param price Harga produk.
     * @param stock Stok produk.
     */
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Mengambil harga produk.
     * @return Harga produk.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Mengambil stok produk.
     * @return Stok produk.
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Mengambil nama produk.
     * @return Nama produk.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Mengurangi stok produk.
     * @param quantity Jumlah stok yang akan dikurangi.
     */
    public void decreaseStock(int quantity) {
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return String.format("Produk %s memiliki stok %s", this.name, this.stock);  
    }

    /**
     * Method abstrak untuk memeriksa diskon yang berlaku berdasarkan kuantitas pembelian.
     * @param quantity Kuantitas pembelian.
     * @return Persentase diskon yang berlaku.
     */
    public abstract int checkDiscount(int quantity);

}
