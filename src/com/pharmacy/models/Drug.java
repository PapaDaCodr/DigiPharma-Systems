package com.pharmacy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Drug in a pharmacy management system.
 * It stores information about the drug's name, code, price, and a list of suppliers.
 *
 * @author Osei Owusu Ansah
 */
public class Drug implements Serializable {
    // Fields to store the drug's name, code, price, and a list of suppliers
    private String name;
    private String code;
    private double price;
    private List<Supplier> suppliers;

    /**
     * Constructor to create a new Drug object with the given name, code, and price.
     * It initializes the suppliers list to an empty ArrayList.
     *
     * @param name  the name of the drug
     * @param code  the unique code of the drug
     * @param price the price of the drug
     */
    public Drug(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.suppliers = new ArrayList<>();
    }

    // Getters and setters for the drug's name, code, and price
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the list of suppliers for the drug.
     *
     * @return the list of suppliers
     */
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * Adds a new supplier to the list of suppliers for the drug.
     *
     * @param supplier the supplier to be added
     */
    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    /**
     * Removes a supplier from the list of suppliers for the drug.
     *
     * @param supplier the supplier to be removed
     */
    public void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
    }

    /**
     * Checks if a given supplier is present in the list of suppliers for the drug.
     *
     * @param supplier the supplier to check for
     * @return true if the supplier is present, false otherwise
     */
    public boolean hasSupplier(Supplier supplier) {
        return suppliers.contains(supplier);
    }

    /**
     * Returns the number of suppliers for the drug.
     *
     * @return the count of suppliers
     */
    public int getSupplierCount() {
        return suppliers.size();
    }

    /**
     * Overrides the equals method to compare two Drug objects based on their codes.
     * Two Drug objects are considered equal if their codes are the same.
     *
     * @param other the object to compare with
     * @return true if the codes of the two Drug objects are equal, false otherwise
     */
    /**
     * @author Emmanuel Kwarteng
     * made an edit to correct bug
     * Changes made on this previous code
     *         public boolean equals(Object other) {
     *         if (other instanceof Drug otherDrug) {
     *         return code.equals(otherDrug.getCode());
     *         }
     *         return false;
     *         }
     */
    public boolean equals(Object other) {

        if (other instanceof Drug) {
            Drug other1 = (Drug) other;
            return code.equals(other1.getCode());
        }
        return false;
    }

    /**
     * Overrides the toString method to provide a string representation of the Drug object.
     *
     * @return a string representation of the Drug object
     */
    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}