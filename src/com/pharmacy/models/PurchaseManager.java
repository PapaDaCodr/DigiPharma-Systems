package com.pharmacy.models;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PurchaseManager {
    private List<PurchaseHistory> purchaseHistories;

    public PurchaseManager() {
        this.purchaseHistories = new ArrayList<>();
    }

    public void addPurchase(PurchaseHistory purchaseHistory) {
        purchaseHistories.add(purchaseHistory);
    }

    public List<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }

    public List<PurchaseHistory> getPurchaseHistoriesByDrug(Drug drug) {
        List<PurchaseHistory> result = new ArrayList<>();
        for (PurchaseHistory history : purchaseHistories) {
            if (history.getPurchasedDrugs().contains(drug)) {
                result.add(history);
            }
        }
        return result;
    }

    public List<PurchaseHistory> sortPurchaseHistoriesByDate() {
        List<PurchaseHistory> sortedList = new ArrayList<>(purchaseHistories);
        sortedList.sort(Comparator.comparing(PurchaseHistory::getPurchaseDate));
        return sortedList;
    }

    public List<PurchaseHistory> sortPurchaseHistoriesByAmount() {
        List<PurchaseHistory> sortedList = new ArrayList<>(purchaseHistories);
        sortedList.sort(Comparator.comparingDouble(PurchaseHistory::getTotalAmount));
        return sortedList;
    }
}
