public class Person {
    private String firstName;
    private String familyName;
    private String phone;
    private String streetAddress;
    private String city;
    private String zipCode;




    public Person(String firstName, String familyName, String phone, String streetAddress, String city, String zipCode) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.phone = phone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String toString() {
        return String.format("Name: %1$s %2$s Phone: %3$s Address: %4$s, %5$s %6$s", firstName, familyName, phone, streetAddress, zipCode, city);

        //return String.format("Name: " + firstName + " " + familyName +", Phone: " + phone + ", Address: " + streetAddress + ", " + zipCode + " " + city);
    }
}
