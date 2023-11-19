package Data.Entities;
import Data.Entities.Products.Product;
import Data.Entities.Users.Seller;
public class OrderItem {
    private Product product;
    private int quantity;

    private Seller seller;

    public OrderItem(Product product, int quantity, Seller seller){
        this.product = product;
        this.quantity = quantity;
        this.seller=seller;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product: " + product.getTitle() + ", Quantity: " + quantity;
    }
}