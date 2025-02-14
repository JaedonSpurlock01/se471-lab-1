package com.problem1;

import com.problem1.model.Product;
import com.problem1.proxy.SortingUtilityProxy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create products
        List<Product> products = new ArrayList<>();
        products.add(new Product("shirts", 29.99));
        products.add(new Product("pants", 39.99));
        products.add(new Product("socks", 8.99));
        products.add(new Product("shoes", 59.99));

        SortingUtilityProxy proxy = new SortingUtilityProxy();

        // LOGGING COLORS FOR BETTER READABILITY
        String RESET = "\u001B[0m";
        String BOLD = "\u001B[1m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";

        // Scenario 1: Sorting with Bubble Sort (Approach 1)
        System.out.println("\n" + BLUE + "--- Scenario 2: Sorting with Bubble Sort (Approach 1) ---" + RESET);
        System.out.println(BOLD + RED + "Original product list before Bubble Sort: " + RESET);
        System.out.println("[ ");
        for (Product product : products) {
            System.out.print("\tID: " + product.getID() + " Name: " + product.getName() + " Price: "
                    + product.getPrice() + "\n");
        }
        System.out.println("]");

        System.out.println(BOLD + GREEN + "Sorted product list after Bubble Sort: " + RESET);
        proxy.sort(products, 1);

        // Scenario 2: Sorting with Quick Sort (Approach 2)
        System.out.println("\n" + BLUE + "--- Scenario 1: Sorting with Quick Sort (Approach 2) ---" + RESET);
        System.out.println(BOLD + RED + "Original product list before Quick Sort " + RESET);
        System.out.println("[");
        for (Product product : products) {
            System.out.print("\tName: " + product.getName() + " ID: " + product.getID() + " Price: "
                    + product.getPrice() + "\n");
        }
        System.out.println("]");

        System.out.println(BOLD + GREEN + "Sorted product list after Quick Sort: " + RESET);
        proxy.sort(products, 2);
    }
}