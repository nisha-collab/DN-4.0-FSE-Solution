package Week1.Algorithm_Data_Structures.EcommerceSearchFunction.code;

import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String target) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(target);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Bag", "Fashion")
        };

        // Sort for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        String target = "Phone";

        int linearIndex = linearSearch(products, target);
        int binaryIndex = binarySearch(products, target);

        System.out.println("Linear Search Result:");
        if (linearIndex != -1)
            System.out.println(products[linearIndex]);
        else
            System.out.println("Product not found.");

        System.out.println("\nBinary Search Result:");
        if (binaryIndex != -1)
            System.out.println(products[binaryIndex]);
        else
            System.out.println("Product not found.");
    }
}
