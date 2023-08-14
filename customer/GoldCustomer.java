package customer;

import order.Cart;
import order.Order;

public class GoldCustomer extends Customer {

    //TODO: lengkapi kelas berikut
    public GoldCustomer(String name){
        super(name);
    }  

    public void Checkout(){
        Order order = new Order(cart, 0.85); // Discount rate untuk GoldCustomer adalah 0.85 (85%)
        orderHistory.add(order);
        order.decreaseStockAllItem();
        cart = new Cart();
    }
}
