/**
 * Represents the Drug(s) the pharmacy has to offer.
 *
 * @author Emmanuel Kwarteng
 * @group Synapse
 */

public class Supplier {
    private String supplierID;
    private String name;
    private String location;
    private String contactDetail;
    private String drugID;

    public Supplier(String supplierID, String name, String location,String drugID, String contactDetail){
        this.supplierID = supplierID;
        this.name = name;
        this.location = location;
        this.contactDetail = contactDetail;
        this.drugID = drugID;
    }

    public Supplier(String supplierID, String name, String location, String drugID){
        this.supplierID = supplierID;
        this.name = name;
        this.location = location;
        this.drugID = drugID;
    }

    public String getSupplierID(){
        return supplierID;
    }

    public void setSupplierID(String supplierID){
        this.supplierID = supplierID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactDetails() {
        return contactDetail;
    }

    public void setContactDetails(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(Drug drugID) {
        this.drugID = String.valueOf(drugID);
    }
}
