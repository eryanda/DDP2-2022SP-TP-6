package order;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    private List<OrderItem> orderList;

    public Cart() {
        orderList = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    public double getTotalPrice() {
        double total = 0;
        for (OrderItem orderItem : orderList) {
            total += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
        return total;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }
    
    @Override
    public String toString() {
        return "Cart [orderList=" + orderList + "]";
    }
}
