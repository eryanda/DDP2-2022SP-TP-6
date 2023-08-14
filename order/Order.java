package order;

import java.time.LocalDate;

public class Order {
    private Cart cart;
    private double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    public Order(Cart cart, double discountRate) {
        this.cart = cart;
        this.discountRate = discountRate;
        this.orderDate = LocalDate.now();
        this.totalPrice = calculateTotalPrice();
    }

    public double getFinalPrice() {
        return totalPrice - (totalPrice * discountRate);
    }

    public void decreaseStockAllItem() {
        for (OrderItem orderItem : cart.getOrderList()) {
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }
    }

    private double calculateTotalPrice() {
        double total = cart.getTotalPrice();
        return total;
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
