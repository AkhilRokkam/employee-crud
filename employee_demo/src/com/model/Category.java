package com.model;

public class Category {
	private int cat_id;
	private String cat_name;
	private int dept_id;

	public Category(int cat_id, String cat_name, int dept_id) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.dept_id = dept_id;
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

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

}
