package com.demo.actions;

import java.sql.SQLException;

import com.demo.dao.Userdao;
import com.demo.pojo.UserReg;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// UserReg user;

	String fname;
	String lname;
	String uname;
	String password;
	String email;
	String dob;

	public String getFname() {
		return fname;
	}

	@RequiredStringValidator(message = "Fname is Required")
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	@RequiredStringValidator(message = "Lname is Required")
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	@RequiredStringValidator(message = "Uname is Required")
	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	@StringLengthFieldValidator(minLength = "8", message = "Minimum 8 characters required!")
	@RegexFieldValidator(regex = "([a-zA-Z]*[0-9!@#$%]+[a-zA-Z]+[0-9!@#$%]*)|([0-9!@#$%]*[a-zA-Z]+[0-9!@#$%]+[a-zA-Z]*)", message = "Invalid password!")
	@RequiredStringValidator(message = "Password is Required")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(message = "Email is Required")
	@EmailValidator(message = "EmailID Is not valid")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	@RegexFieldValidator(regex = "((([0-2][0-9]|[3][0-1])(/)([0][0-9]|[1][0-2])(/)([0-1][0-9][0-9][0-9]|[2][0][0-1][0-5]))|(([0-2][0-9]|[3][0-1])(/)([0][1])(/)([2][0][1][6])))", message = ("Invalid date of brith!"))
	@RequiredStringValidator(message = "DOB is Required")
	public void setDob(String dob) {
		this.dob = dob;
	}

	public String execute() throws ClassNotFoundException, SQLException {
		UserReg u = new UserReg(fname, lname, uname, password, email, dob);
		Userdao daoUser = new Userdao();

		boolean ans = daoUser.isUserExist(uname);
		if (ans) {
			addActionMessage("User Already Exist");
			return "error";
		} else {

			boolean a = daoUser.addrecord(u);
			if (a) {
				addActionMessage("User Successfully added");
				u = null;
				this.uname = null;
				this.dob = null;
				this.email = null;
				this.password = null;
				this.lname = null;
				this.fname = null;
			}

		}
		return "success";
	}

	// boolean ans =

}
