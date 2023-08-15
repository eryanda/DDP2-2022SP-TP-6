package customer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerTest {
    private Customer customer;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John");
        product1 = new Product("Product 1", 100, 10);
        product2 = new Product("Product 2", 50, 2);
    }

    @Test
    public void testAddToCartSufficientStock() {
        customer.addToCard(product1, 5);
        Cart cart = customer.getCart();
        ArrayList<OrderItem> orderList = cart.getOrderList();
        assertEquals(1, orderList.size());
        assertEquals(product1, orderList.get(0).getProduct());
        assertEquals(5, orderList.get(0).getQuantity());
    }

    @Test
    public void testAddToCartInsufficientStock() {
        customer.addToCard(product2, 60);
        Cart cart = customer.getCart();
        ArrayList<OrderItem> orderList = cart.getOrderList();
        assertEquals(0, orderList.size());
    }

    @Test
    public void testCheckout() {
        customer.addToCard(product1, 3);
        customer.addToCard(product2, 2);
        customer.checkout();
        ArrayList<Order> orderHistory = customer.getOrderHistory();
        assertEquals(1, orderHistory.size());
    }

    @Test
    public void testEmptyCartCheckout() {
        customer.checkout();
        ArrayList<Order> orderHistory = customer.getOrderHistory();
        assertEquals(0, orderHistory.size());
    }
}
