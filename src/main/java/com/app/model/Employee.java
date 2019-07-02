package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long empid;
	private String empname;
	private String empemail;
	private String mobileno;
	private Double empsal;

	public Employee(String empname, String empemail, String mobileno, Double empsal) {
		super();
		this.empname = empname;
		this.empemail = empemail;
		this.mobileno = mobileno;
		this.empsal = empsal;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + ", mobileno=" + mobileno
				+ ", empsal=" + empsal + "]";
	}

	public Employee(Long empid, String empname, String empemail, String mobileno, Double empsal) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
		this.mobileno = mobileno;
		this.empsal = empsal;
	}

	public Employee() {
		super();
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Double getEmpsal() {
		return empsal;
	}

	public void setEmpsal(Double empsal) {
		this.empsal = empsal;
	}

}
