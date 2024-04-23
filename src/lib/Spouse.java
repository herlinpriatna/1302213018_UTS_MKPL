package lib;

public class Spouse {
    private String name;
    private String idNumber;

    public Spouse(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    // Getters and setters for spouse name and ID number
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
