package com.problem1.proxy;

import com.problem1.service.SortingUtilityInterface;
import com.problem1.model.Product;
import com.problem1.service.SortingUtility;

import java.util.List;

public class SortingUtilityProxy implements SortingUtilityInterface {
    private final SortingUtilityInterface sortingUtility = new SortingUtility();

    /**
     * Sorts the given list of products by price based on the specified sorting
     * approach. Then logs the sorted list of products based on the algorithm.
     * 
     * @param items           the list of products to sort
     * @param sortingApproach the approach to use for sorting. 1 = bubble sort, 2 =
     *                        quick sort
     * @return a sorted list of products
     * @throws IllegalArgumentException if the sorting approach is invalid
     */
    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        List<Product> sortedItems = sortingUtility.sort(items, sortingApproach);
        System.out.println("[\n");
        if (sortingApproach == 1) {
            for (Product item : sortedItems) {
                System.out.println("\tID: " + item.getID() + " Name: " + item.getName() + " Price: " + item.getPrice());
            }
        } else if (sortingApproach == 2) {
            for (Product item : sortedItems) {

                System.out.println("\tName: " + item.getName() + " ID: " + item.getID() + " Price: " + item.getPrice());
            }
        }
        System.out.println("]\n");
        return sortedItems;
    }
}
