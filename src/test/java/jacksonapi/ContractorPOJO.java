package jacksonapi;

public class ContractorPOJO {

    //private variables or data members of pojo class
    private  String firstName;
    private String lastName;
    private  String contractFrom;
    private  String contractTo;
    private  String contactNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContractFrom() {
        return contractFrom;
    }

    public void setContractFrom(String contractFrom) {
        this.contractFrom = contractFrom;
    }

    public String getContractTo() {
        return contractTo;
    }

    public void setContractTo(String contractTo) {
        this.contractTo = contractTo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
