import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    private List<Purchase> purchaseList;

    public PurchaseHistory() {
        this.purchaseList = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }

    public List<Purchase> getPurchases() {
        return purchaseList;
    }

    // Sorting methods (by date, amount, etc.) can be implemented here
}
