package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Employee {
	private enum Gender{
		PRIA,
		WANITA
	}

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	// Menggunakan LocalDate untuk menghandle data join
	private LocalDate joinedDate;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	// Menggunakan tipe enum untuk gender
	private Gender gender; 
	
	// Informasi Gaji
	private Income income;
	
	// Detail Keluarga
	private Spouse spouse; // membagi menjadi class informasi spouse
	private List<Child> children; // membagi menjadi class informasi child

	// Mengubah method Employee
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
	LocalDate joinedDate, boolean isForeigner, Gender gender, Income income) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinedDate = joinedDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		this.income = income;
	}

	// Menambahkan method construction dengan optional spouse dan children
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
	LocalDate joinedDate, boolean isForeigner, Gender gender, Income income, Optional<Spouse> spouse,
	List<Child> children) {
		this(employeeId, firstName, lastName, idNumber, address, joinedDate, isForeigner, gender,
		income);
		this.spouse = spouse.orElse(null); // Set spouse ke null apabila tidak memiliki
		this.children = children;
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	public void setMonthlySalary(int grade) {
		int baseSalary;
		switch (grade) {
		  case 1:
			baseSalary = 3000000;
			break;
		  case 2:
			baseSalary = 5000000;
			break;
		  case 3:
			baseSalary = 7000000;
			break;
		  default:
			throw new IllegalArgumentException("Invalid employee grade: " + grade);
		}
	  
		this.income.setMonthlySalary(isForeigner ? (int) (baseSalary * 1.5) : baseSalary);
	  }
	
	  public void addChild(Child child) {
		this.children.add(child);
	  }
	
	  public int getAnnualIncomeTax() {
		LocalDate date = LocalDate.now();
		int currentYear = date.getYear();
		int currentMonth = date.getMonthValue();
	  
		// Assuming 'joinedDate' attribute is present in the Employee class
		if (joinedDate.getYear() == currentYear) {
		  monthWorkingInYear = currentMonth - joinedDate.getMonthValue();
		} else {
		  monthWorkingInYear = 12;
		}
		
		boolean hasSpouse = this.spouse != null;
		int numberOfChildren = this.children != null ? this.children.size() : 0;
		
		return TaxFunction.calculateTax(income.getMonthlySalary(), income.getOtherMonthlyIncome(), monthWorkingInYear, income.getAnnualDeductible(), hasSpouse, numberOfChildren);
	  }
	
}
