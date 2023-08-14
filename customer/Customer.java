package customer;

import java.util.ArrayList;
import java.util.List;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

public class Customer implements CanShop {
    //TODO: lengkapi kelas berikut

    protected String name;
    protected Cart cart;
    protected ArrayList<Order> orderHistory;

    public Customer(String name){
        this.name = name;
    }
    
    @Override
    public void addToCart(Product product, int quantity){
        cart.addOrderItem(new OrderItem(product, quantity));
    }

    @Override 
    public void Checkout(){
        Order order = new Order(cart, 0.1); // Assuming discountRate is 0.1 (10%)
        orderHistory.add(order);
        order.decreaseStockAllItem();
        cart = new Cart(); // Reset the cart after checkout
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
