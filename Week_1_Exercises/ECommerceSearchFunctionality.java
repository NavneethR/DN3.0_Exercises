package Week_1_Exercises;

import java.util.*;

class Product {
    int productId;
    String productName, category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = new String(productName);
        this.category = new String(category);
    }
}

public class ECommerceSearchFunctionality {

    // intialing for some just 1000 elements.
    static Product[] inventory = new Product[1000];

    /*
     * Add some elements to the inventory array before using Linear Search.
     */

    // implementing using the linear search
    static Product linearSearch(Product[] inventory, int targetProductId) {
        for (Product product : inventory) {
            int productId = product.productId;
            if (productId == targetProductId) {
                return product;
            }
        }
        System.out.println("The Product does not exsists.");
        return null;
    }

    // implementing using the Binary Search
    static Product binarySearch(Product[] inventory, int targetProductId) {
        int left = 0;
        int right = inventory.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = inventory[mid];

            if (midProduct.productId == targetProductId) {
                return midProduct;
            } else if (midProduct.productId < targetProductId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /* Use your linear search algorithm here to find elements */
        Arrays.sort(inventory);
        /* Use your binary search algorithm here to find the element */
    }
}

/*
 * Analysis:
 * 
 * time complexity of linear Search: O(N)
 * time complexity of binary Search: O(log(N))
 * note: binary search needs the array to be sorted to work that means we have
 * to sort the array first, in this case the time complexity is O(N+log(N)).
 * 
 * Binary Search is more efficient in this case (i.e for 1000 or so elements) if
 * the inventory expands we can insert the productId in the sorted place and use
 * binary Search (for comaparison: for 1000 elements, linear search compares for
 * 1000 times while the binary search only compares for 10 times).
 * 
 */