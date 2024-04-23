package lib;

public class EmployeeDetails {
    private final String employeeId;
    private final String firstName;
    private final String lastName;
    private final String idNumber;
    private final String address;
  
    public EmployeeDetails(String employeeId, String firstName, String lastName, String idNumber, String address) {
      this.employeeId = employeeId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.idNumber = idNumber;
      this.address = address;
    }
  
    // Getters for each attribute (optional)
    public String getEmployeeId() {
      return employeeId;
    }
  
    public String getFirstName() {
      return firstName;
    }
  
    public String getLastName() {
      return lastName;
    }
  
    public String getIdNumber() {
      return idNumber;
    }
  
    public String getAddress() {
      return address;
    }
  }