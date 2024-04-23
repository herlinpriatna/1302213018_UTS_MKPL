package lib;

  // Class for child information
  public class Child {
    private String name;
    private String idNumber;

    public Child(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    // Getters and setters for child name and ID number
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
