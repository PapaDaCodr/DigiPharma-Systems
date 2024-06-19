package com.pharmacy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OSei Owusu Ansah
 *
 * Represents a customer in the pharmacy management system.
 */
public class Customer implements Serializable {
    private int id;
    private String name;
    private int age;
    private String contact;
    private List<PurchaseHistory> purchaseHistory;

    /**
     * Constructs a new Customer object with the given id, name, age, and contact.
     *
     * @param id      the unique identifier of the customer
     * @param name    the name of the customer
     * @param age     the age of the customer
     * @param contact the contact information of the customer
     */
    public Customer(int id, String name, int age, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.purchaseHistory = new ArrayList<>();
    }

    /**
     * Returns the unique identifier of the customer.
     *
     * @return the customer's id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the customer.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the customer.
     *
     * @return the customer's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the contact information of the customer.
     *
     * @return the customer's contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Returns the list of purchase history for the customer.
     *
     * @return the list of purchase history
     */
    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Adds a new purchase to the customer's purchase history.
     *
     * @param purchase the purchase to be added
     */
    public void addPurchase(PurchaseHistory purchase) {
        purchaseHistory.add(purchase);
    }

    /**
     * Removes a purchase from the customer's purchase history.
     *
     * @param purchase the purchase to be removed
     */
    public void removePurchase(PurchaseHistory purchase) {
        purchaseHistory.remove(purchase);
    }

    /**
     * Calculates and returns the total amount spent by the customer.
     *
     * @return the total amount spent by the customer
     */
    public double getTotalSpent() {
        double totalSpent = 0.0;
        for (PurchaseHistory purchase : purchaseHistory) {
            totalSpent += purchase.getTotalAmount();
        }
        return totalSpent;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                '}';
    }
}