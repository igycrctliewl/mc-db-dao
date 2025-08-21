package mc.minecraft.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column( name = "ID" )
	private int eid;

	@Column( name = "EMPLOYEE_NAME" )
	private String employeeName;

	private double salary;
	private String deg;

	public Employee(int eid, String ename, double salary, String deg) {
		super();
		this.eid = eid;
		this.employeeName = ename;
		this.salary = salary;
		this.deg = deg;
	}

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String ename) {
		this.employeeName = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + employeeName + ", salary=" + salary + ", deg=" + deg + "]";
	}
}