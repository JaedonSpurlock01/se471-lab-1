package com.problem1.service;

import com.problem1.model.Product;
import java.util.List;
import java.util.Comparator;

public class SortingUtility implements SortingUtilityInterface {
    /**
     * Sorts the given list of products by price based on the specified sorting
     * approach.
     * 
     * @param items           the list of products to sort
     * @param sortingApproach the approach to use for sorting. 1 = bubble sort, 2 =
     *                        quick sort
     * @return a sorted list of products
     * @throws IllegalArgumentException if the sorting approach is invalid
     */
    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        if (sortingApproach == 1) {
            return bubbleSort(items);
        } else if (sortingApproach == 2) {
            return quickSort(items);
        } else {
            throw new IllegalArgumentException("Invalid sorting approach: " + sortingApproach);
        }
    }

    /**
     * Sorts a list of products using the bubble sort algorithm, comparing
     * the products by their price in ascending order.
     *
     * @param items the list of products to be sorted
     * @return the sorted list of products
     */
    private List<Product> bubbleSort(List<Product> items) {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items.get(j).getPrice() > items.get(j + 1).getPrice()) {
                    Product temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
        return items;
    }

    /**
     * Sorts a list of products using the quick sort algorithm, comparing
     * the products by their price in ascending order.
     *
     * @param items the list of products to be sorted
     * @return the sorted list of products
     */
    private List<Product> quickSort(List<Product> items) {
        // Dual-Pivot Quicksort
        // https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
        items.sort(Comparator.comparing(Product::getPrice));
        return items;
    }
}
