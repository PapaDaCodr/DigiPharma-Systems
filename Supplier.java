public class Supplier {
    private String name;
    private String location;
    private String contactDetails;

    public Supplier(String name, String location, String contactDetails) {
        this.name = name;
        this.location = location;
        this.contactDetails = contactDetails;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
