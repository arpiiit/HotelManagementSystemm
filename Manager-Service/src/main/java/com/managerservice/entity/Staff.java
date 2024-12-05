package com.managerservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="staff")
public class Staff 
{
	@Transient
    public static final String SEQUENCE_NAME = "staff_sequence";
	@Id
	private int empId;
	@NotNull(message="name is required")
	private String empName;
	@NotNull(message="Mobile number is required")
	private String empPhone;
	@NotNull(message="Email is required")
	private String empEmail;
	@NotNull
	private String empGender;
	@NotNull(message="Department name is required")
	private String empDptName;
	@NotNull(message="salary is required")
	private double empSalary;
	
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	
	public String getEmpDptName() {
		return empDptName;
	}
	public void setEmpDptName(String empDptName) {
		this.empDptName = empDptName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	

}
