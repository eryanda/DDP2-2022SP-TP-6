package customer;

import java.time.LocalDate;
import java.util.ArrayList;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

/**
 * Representasi seorang pelanggan yang dapat berbelanja produk dan mengelola keranjang serta riwayat pesanannya.
 */
public class Customer implements CanShop {
    protected String name;
    protected Cart cart;
    protected ArrayList<Order> orderHistory;

    /**
     * Membuat objek Customer baru dengan nama yang diberikan.
     * @param name Nama pelanggan.
     */
    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    /**
     * Mengambil nama pelanggan.
     * @return Nama pelanggan.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur nama pelanggan.
     * @param name Nama baru pelanggan.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Menambahkan produk dengan kuantitas tertentu ke dalam keranjang.
     * @param product Produk yang akan ditambahkan.
     * @param quantity Kuantitas produk yang akan ditambahkan.
     */
    public void addToCard(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            OrderItem orderItem = new OrderItem(product, quantity);
            cart.addOrderItem(orderItem);
            System.out.println("Berhasil menambahkan " + product.getName() + " ke keranjang");
        } else {
            System.out.println("Stok produk tidak mencukupi");
        }
    }

    /**
     * Menyelesaikan pembelian, membuat pesanan, dan menambahkannya ke riwayat pesanan.
     */
    public void checkout() {
        if (!cart.getOrderList().isEmpty()) {
            double totalPrice = cart.getTotalPrice();
            LocalDate currentDate = LocalDate.now();
            Order order = new Order(cart, 0, currentDate, totalPrice);
            orderHistory.add(order);
            System.out.println("Berhasil Checkout");
        } else {
            System.out.println("Keranjang Anda Kosong");
        }
    }

    /**
     * Mengambil keranjang pelanggan.
     * @return Keranjang pelanggan.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Mengatur keranjang pelanggan.
     * @param cart Keranjang baru untuk pelanggan.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Mengambil riwayat pesanan pelanggan.
     * @return Riwayat pesanan pelanggan.
     */
    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Mengatur riwayat pesanan pelanggan.
     * @param orderHistory Riwayat pesanan baru untuk pelanggan.
     */
    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    /**
     * Mengambil daftar pesanan dari keranjang pelanggan.
     * @return Daftar pesanan dari keranjang.
     */
    public ArrayList<OrderItem> getOrderList() {
        return cart.getOrderList();
    }

    @Override
    public void Checkout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Checkout'");
    }

    @Override
    public void addToCart(Product product, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCart'");
    }
}
