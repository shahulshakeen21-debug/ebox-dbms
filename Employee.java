 public class Employee {
	private Integer empId;
	private String name;
	private String email;
	private String contactNumber;
	private Double salary;
	
	public Employee() { }
	
	public Employee(Integer empId, String name, String email, String contactNumber, Double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
