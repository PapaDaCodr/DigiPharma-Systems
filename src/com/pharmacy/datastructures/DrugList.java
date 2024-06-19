package com.pharmacy.datastructures;

import com.pharmacy.models.Drug;

import java.util.LinkedList;

/**
 * @author Osei Owusu Ansah
 * A linked list implementation for storing and managing Drug objects using the Java Collections API.
 */
public class DrugList {
    private LinkedList<Drug> drugList;

    /**
     * Constructs an empty DrugList.
     */
    public DrugList() {
        this.drugList = new LinkedList<>();
    }

    /**
     * Adds a new Drug to the list.
     *
     * @param drug the Drug object to be added
     */
    public void add(Drug drug) {
        drugList.add(drug);
    }

    /**
     * Removes a Drug from the list.
     *
     * @param drug the Drug object to be removed
     * @return true if the Drug was successfully removed, false otherwise
     */
    public boolean remove(Drug drug) {
        return drugList.remove(drug);
    }

    /**
     * Gets the Drug object at the specified index.
     *
     * @param index the index of the Drug object to retrieve
     * @return the Drug object at the specified index, or null if the index is invalid
     */
    public Drug get(int index) {
        if (index < 0 || index >= drugList.size()) {
            return null;
        }
        return drugList.get(index);
    }

    /**
     * Returns the index of the first occurrence of the specified Drug in the list.
     *
     * @param drug the Drug object to search for
     * @return the index of the Drug object, or -1 if not found
     */
    public int indexOf(Drug drug) {
        return drugList.indexOf(drug);
    }

    /**
     * Returns the size of the list.
     *
     * @return the number of Drug objects in the list
     */
    public int size() {
        return drugList.size();
    }
}