package com.pharmacy.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Osei Owusu Ansah
 * Represents a purchase history record in the pharmacy management system.
 */
public class PurchaseHistory implements Serializable {
    private LocalDateTime purchaseDate;
    private List<Drug> purchasedDrugs;
    private double totalAmount;

    /**
     * Constructs a new PurchaseHistory object with the given purchase date.
     *
     * @param purchaseDate the date and time of the purchase
     */
    public PurchaseHistory(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
        this.purchasedDrugs = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    /**
     * Returns the date and time of the purchase.
     *
     * @return the purchase date
     */
    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Returns the list of drugs purchased.
     *
     * @return the list of purchased drugs
     */
    public List<Drug> getPurchasedDrugs() {
        return purchasedDrugs;
    }

    /**
     * Adds a drug to the list of purchased drugs and updates the total amount.
     *
     * @param drug the drug to be added
     */
    public void addPurchasedDrug(Drug drug) {
        purchasedDrugs.add(drug);
        totalAmount += drug.getPrice();
    }

    /**
     * Removes a drug from the list of purchased drugs and updates the total amount.
     *
     * @param drug the drug to be removed
     */
    public void removePurchasedDrug(Drug drug) {
        if (purchasedDrugs.remove(drug)) {
            totalAmount -= drug.getPrice();
        }
    }

    /**
     * Returns the total amount of the purchase.
     *
     * @return the total amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    public void displayPurchaseDetails() {
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Purchased Drugs:");
        for (Drug drug : purchasedDrugs) {
            System.out.println(
                    " - " + drug.getName() + " (Code: " + drug.getCode() + ", Price: $" + drug.getPrice() + ")");
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}