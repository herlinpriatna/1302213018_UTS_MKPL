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
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	// Detail Keluarga
	private Spouse spouse; // membagi menjadi class informasi spouse
	private List<Child> children; // membagi menjadi class informasi child

	// Mengubah method Employee
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
	LocalDate joinedDate, boolean isForeigner, Gender gender, int monthlySalary,
	int otherMonthlyIncome, int annualDeductible) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinedDate = joinedDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		this.monthlySalary = monthlySalary;
		this.otherMonthlyIncome = otherMonthlyIncome;
		this.annualDeductible = annualDeductible;
	}

	// Menambahkan method construction dengan optional spouse dan children
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
	LocalDate joinedDate, boolean isForeigner, Gender gender, int monthlySalary,
	int otherMonthlyIncome, int annualDeductible, Optional<Spouse> spouse,
	List<Child> children) {
		this(employeeId, firstName, lastName, idNumber, address, joinedDate, isForeigner, gender,
		monthlySalary, otherMonthlyIncome, annualDeductible);
		this.spouse = spouse.orElse(null); // Set spouse ke null apabila tidak memiliki
		this.children = children;
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	  }
	
	  public void addChild(Child child) {
		this.children.add(child);
	  }
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
