package com.emp;

import com.util.MyDate;

public class Employee 
{
	private String firstname="dude";
	private String lastname="dude";
	private MyDate birthdate=null;

	public Employee()
	{
		System.out.println("inside default constructor of Employee()");
	}

    
	public void setFirstname(String name)
	{
		firstname = name;
	}

	public void setLastname(String name)
	{
		lastname = name;
	}

    public void setBirthdate(MyDate bday)
	{
		birthdate = bday;
	}


    public boolean equals(Object obj)
	{
		Employee emp = (Employee)obj;
		if( this.firstname.equals(emp.firstname) &&  this.lastname.equals(emp.lastname) &&
		    this.birthdate.equals(emp.birthdate)	
		)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    
	public String toString()
	{
		return "FullName :: "+ this.firstname + this.lastname + "\n" + "BirthDate :: " + this.birthdate.toString();
	}

	
}