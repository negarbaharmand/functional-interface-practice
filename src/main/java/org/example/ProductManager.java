package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public static void manageProducts(List<Product> productList, Conditional conditional, Action action) {
        for (Product product : productList) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 18, 5));
        products.add(new Product("Banana", 28, 16));
        products.add(new Product("Cheese", 20, 11));
        products.add(new Product("Beef", 170.0, 9));
        products.add(new Product("Chicken", 120, 0));
        products.add(new Product("Plastic bag", 35, 0));

        System.out.println("All Products that have stock value of 0: ");
        manageProducts(products, p -> p.getStock() == 0, p -> System.out.println(p.getProductName()));
        System.out.println("------------------------------------");
        System.out.println("All the Products that starts with B:");
        manageProducts(products, p -> p.getProductName().startsWith("B"), p -> System.out.println(p.getProductName()));
        System.out.println("------------------------------------");
        System.out.println("All Products that have price above 100 AND lower than 150: ");
        manageProducts(products, p -> p.getPrice() > 100 && p.getPrice() < 150, p -> System.out.println(p.getProductName() +" Price: "+ p.getPrice()));
        System.out.println("------------------------------------");
        System.out.println("Increased price of all Products that have a stock value of less than 10 AND above 0 by 50%: ");
        manageProducts(products, p -> p.getStock() > 0 && p.getStock() < 10, p -> {
            double newPrice = p.getPrice() * 1.5;
            p.setPrice(newPrice);
            System.out.println("New increased price of " + p.getProductName() + ": " +  p.getPrice());
        });



    }
}
