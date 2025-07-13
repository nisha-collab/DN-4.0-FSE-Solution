package Week1.Algorithm_Data_Structures.EcommerceSearchFunction.code;

public class Product {
     int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productName + " [" + category + "]";
    }
}
