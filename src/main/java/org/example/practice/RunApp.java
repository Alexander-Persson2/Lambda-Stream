package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class RunApp {


    public static void applyActionIfConditionMet(List<Product> products, Conditional condition, Action action) {
        for (Product product : products) {
            if (condition.test(product)) {
                action.execute(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 900.00, 1));
        productList.add(new Product("Smartphone", 500.00, 15));
        productList.add(new Product("Tablet", 300.00, 0));
        productList.add(new Product("Smartwatch", 200.00, 8));
        productList.add(new Product("Book", 20.00, 0));

        // Scenario 1: Print out all Products that have stock value of 0
        System.out.println("Products with stock value of 0:");
        applyActionIfConditionMet(
                productList,
                product -> product.getStock() == 0,
                product -> System.out.println(product)
        );
        System.out.println("----------------------------");

        // Scenario 2: Print out the productName of all the Products that start with B
        System.out.println("Products starting with B:");
        applyActionIfConditionMet(
                productList,
                product -> product.getProductName().startsWith("B"),
                product -> System.out.println(product.getProductName())
        );
        System.out.println("----------------------------");

        // Scenario 3: Print out all Products that have price above 100 AND lower than 150
        System.out.println("Products with price above 100 and below 150:");
        applyActionIfConditionMet(
                productList,
                product -> product.getPrice() > 100 && product.getPrice() < 150,
                product -> System.out.println(product)
        );
        System.out.println("----------------------------");

        // Scenario 4: Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        System.out.println("Increasing price by 50% for products with stock between 1 and 9:");
        applyActionIfConditionMet(
                productList,
                product -> product.getStock() < 10 && product.getStock() > 0,
                product -> product.setPrice(product.getPrice() * 1.5)
        );

        // Verify the price increase
        System.out.println("Products after price increase:");
        applyActionIfConditionMet(
                productList,
                product -> product.getStock() < 10 && product.getStock() > 0,
                product -> System.out.println(product)
        );
    }
}

