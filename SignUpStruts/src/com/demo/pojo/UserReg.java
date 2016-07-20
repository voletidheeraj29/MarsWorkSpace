package com.demo.pojo;

public class UserReg {

	String fname;
	String lname;
	String uname;
	String password;
	String email;
	String dob;

	public UserReg(String fname2, String lname2, String uname2, String password2, String email2, String dob2) {
		// TODO Auto-generated constructor stubthis.fname = fname;
		this.fname = fname2;
		this.lname = lname2;
		this.uname = uname2;
		this.password = password2;
		this.email = email2;
		this.dob = dob2;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
