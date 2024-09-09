package jacksonapi;

import java.util.List;

public class EmployeeNestedPOJO {

    // private variables or data members of pojo class
    private String companyName;
    private String companyEmailId;
    private String companyNumber;
    private String companyAddress;
    private List<String> supportedSalaryBanks;

    List<EmployeePOJO> employeePojo;
    List<ContractorPOJO> contractorPojo;
    CompanyPfPOJO companyPfPOJO;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmailId() {
        return companyEmailId;
    }

    public void setCompanyEmailId(String companyEmailId) {
        this.companyEmailId = companyEmailId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<String> getSupportedSalaryBanks() {
        return supportedSalaryBanks;
    }

    public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
        this.supportedSalaryBanks = supportedSalaryBanks;
    }

    public List<EmployeePOJO> getEmployeePojo() {
        return employeePojo;
    }

    public void setEmployeePojo(List<EmployeePOJO> employeePojo) {
        this.employeePojo = employeePojo;
    }

    public List<ContractorPOJO> getContractorPojo() {
        return contractorPojo;
    }

    public void setContractorPojo(List<ContractorPOJO> contractorPojo) {
        this.contractorPojo = contractorPojo;
    }

    public CompanyPfPOJO getCompanyPfPOJO() {
        return companyPfPOJO;
    }

    public void setCompanyPfPOJO(CompanyPfPOJO companyPfPOJO) {
        this.companyPfPOJO = companyPfPOJO;
    }
}
