package com.model;

import java.util.Date;

public class Employee {
	private int empid;
	private String empname;
	private Date date_of_joining;
	private int dept_id;
	private String dept_name;
	private int cat_id;
	private String cat_name;
	private double salary;
	private boolean isvalid;

	public Employee() {

	}

	public Employee(String empname, Date date_of_joining, int dept_id, int cat_id, double salary, boolean isvalid) {
		super();
		this.empname = empname;
		this.date_of_joining = date_of_joining;
		this.dept_id = dept_id;
		this.cat_id = cat_id;
		this.salary = salary;
		this.isvalid = isvalid;
	}

	public Employee(int empid, String empname, Date date_of_joining, int dept_id, int cat_id, double salary,
			boolean isvalid) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.date_of_joining = date_of_joining;
		this.dept_id = dept_id;
		this.cat_id = cat_id;
		this.salary = salary;
		this.isvalid = isvalid;
	}

	public Employee(int empid, String empname, Date date_of_joining, String dept_name, String cat_name, double salary,
			boolean isvalid) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.date_of_joining = date_of_joining;
		this.dept_name = dept_name;
		this.cat_name = cat_name;
		this.salary = salary;
		this.isvalid = isvalid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isIsvalid() {
		return isvalid;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

}
