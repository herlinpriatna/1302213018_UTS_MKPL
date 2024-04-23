package lib;

public class Income {
    private boolean isForeigner;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Income(int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
    }

    // Getters and setters for all attributes
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

	
    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }
}