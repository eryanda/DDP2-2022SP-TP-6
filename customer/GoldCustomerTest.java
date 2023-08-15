package customer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import order.Cart;
import order.OrderItem;
import product.Product;

public class GoldCustomerTest {
    private GoldCustomer goldCustomer;

    @BeforeEach
    public void setUp() {
        goldCustomer = new GoldCustomer("TestGoldCustomer");
    }

    @Test
    public void testCheckoutWithDiscount() {
        // Create a sample cart with total price of 100
        Cart cart = new Cart();
        OrderItem orderItem = new OrderItem(new Product("Sample Product", 100, 1), 1);
        cart.addOrderItem(orderItem);
        goldCustomer.setCart(cart);

        goldCustomer.checkout();

        // Calculate the discounted price (85% of 100)
        double expectedTotalPrice = 85.0;

        // Get the order from orderHistory
        Order order = (Order) goldCustomer.getOrderHistory().get(0);

        assertEquals(expectedTotalPrice, ((Cart) order).getTotalPrice());
        assertEquals(GoldCustomer.DISCOUNT_RATE, ((order.Order) order).getDiscountRate());
    }

    @Test
    public void testCheckoutWithEmptyCart() {
        goldCustomer.checkout();

        assertFalse(goldCustomer.getOrderHistory().isEmpty());
    }
}
