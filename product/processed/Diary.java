package product.processed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import product.Product;

/**
 * Representasi dari produk susu (diary) yang dapat diproses.
 */
public class Diary extends Product {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    public LocalDate expiredDate;

    /**
     * Membuat objek Diary baru dengan nama, harga, stok, dan tanggal kedaluwarsa yang diberikan.
     * @param name Nama produk diary.
     * @param price Harga produk diary.
     * @param stock Stok produk diary.
     * @param date Tanggal kedaluwarsa produk diary (dalam format "dd MM yyyy").
     */
    public Diary(String name, int price, int stock, String date) {
        super(name, price, stock);
        this.expiredDate = LocalDate.parse(date, formatter);
    }

    /**
     * Memeriksa diskon yang berlaku berdasarkan kuantitas pembelian.
     * @param quantity Kuantitas pembelian.
     * @return Persentase diskon yang berlaku.
     */
    @Override
    public int checkDiscount(int quantity) {
        long differentDate = ChronoUnit.DAYS.between(LocalDate.now(), this.expiredDate);
        if (differentDate < 30) {
            return 20;
        } else {
            return 0;
        }
    }
}
