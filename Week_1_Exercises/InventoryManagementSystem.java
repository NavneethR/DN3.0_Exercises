package Week_1_Exercises;

import java.util.*;

public class InventoryManagementSystem {
    private HashSet<Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashSet<>();
    }

    // handle if product exists
    public void addToInventory(Product product) {
        if (inventory.contains(product)) {
            System.out.println("Product already exists!");
        } else {
            inventory.add(product);
            System.out.println("Product has been added.");
        }
    }

    // handle product updation
    public void updateInventory(int productId, int quantity, float price) {
        Product newProduct = null;
        for (Product product : inventory) {
            int newProductId = product.productId;
            if (newProductId == productId) {
                newProduct = product;
                break;
            }
        }

        // check if product exsists in invetory
        if (newProduct != null) {
            inventory.remove(newProduct);
            newProduct.quantity = quantity;
            newProduct.price = price;
            inventory.add(newProduct);
            System.out.println("Product has been updated");
        } else {
            System.out.println("Product does not exsist or Enter a valid Id!");
        }
    }

    // handle deletion of product
    public void deleteFromInventory(int productId) {
        Product newProduct = null;
        for (Product product : inventory) {
            int newProductId = product.productId;
            if (newProductId == productId) {
                newProduct = product;
                break;
            }
        }

        // check if product exsists
        if (newProduct != null) {
            inventory.remove(newProduct);
            System.out.println("Product has been removed.");
        } else {
            System.out.println("Product does not exsists or Enter a valid Id");
        }
    }

    public static void main(String[] args) {
        // create a new inventory to store products
        InventoryManagementSystem ims = new InventoryManagementSystem();

        /*
         * Change this part according to the inventory you want to add , delete or
         * change
         */

    }
}

class Product {
    int productId, quantity;
    float price;
    String productName;

    Product(int productId, String productName, int quantity, float price) {
        this.productId = productId;
        this.productName = new String(productName);
        this.quantity = quantity;
        this.price = price;
    }

    public void show() {
        System.out.println(productId + " " + productName + " " + quantity + " " + price);
    }
}
