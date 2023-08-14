package customer;

import product.Product;

public interface CanShop {

    public void addToCart(Product product, int quantity);

    public void Checkout();
}
