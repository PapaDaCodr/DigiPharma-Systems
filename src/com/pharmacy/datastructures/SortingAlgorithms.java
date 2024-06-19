package com.pharmacy.datastructures;

import com.pharmacy.models.Drug;

import java.util.Comparator;

/**
 * This class contains sorting algorithms for the Drug class.
 *
 * @author Osei Owusu Ansah
 */
public class SortingAlgorithms {

    /**
     * Sorts an array of Drug objects using the quicksort algorithm.
     *
     * @param drugs the array of Drug objects to be sorted
     * @param comparator the Comparator used to compare the Drug objects
     */
    public static void quicksort(Drug[] drugs, Comparator<Drug> comparator) {
        quicksort(drugs, 0, drugs.length - 1, comparator);
    }

    /**
     * Recursive helper method for the quicksort algorithm.
     *
     * @param drugs the array of Drug objects to be sorted
     * @param low the starting index of the subarray to be sorted
     * @param high the ending index of the subarray to be sorted
     * @param comparator the Comparator used to compare the Drug objects
     */
    private static void quicksort(Drug[] drugs, int low, int high, Comparator<Drug> comparator) {
        if (low < high) {
            int pivotIndex = partition(drugs, low, high, comparator);
            quicksort(drugs, low, pivotIndex - 1, comparator);
            quicksort(drugs, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Partitions the array of Drug objects around a pivot.
     *
     * @param drugs the array of Drug objects to be sorted
     * @param low the starting index of the subarray to be sorted
     * @param high the ending index of the subarray to be sorted
     * @param comparator the Comparator used to compare the Drug objects
     * @return the index of the pivot after partitioning
     */
    private static int partition(Drug[] drugs, int low, int high, Comparator<Drug> comparator) {
        Drug pivot = drugs[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(drugs[j], pivot) < 0) {
                i++;
                swap(drugs, i, j);
            }
        }
        swap(drugs, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array of Drug objects.
     *
     * @param drugs the array of Drug objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private static void swap(Drug[] drugs, int i, int j) {
        Drug temp = drugs[i];
        drugs[i] = drugs[j];
        drugs[j] = temp;
    }
}