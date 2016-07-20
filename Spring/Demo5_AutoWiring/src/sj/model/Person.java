package sj.model;

public class Person {
 
	private String name;
	private String address;
	private int age;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [address=" + address + ", age=" + age + ", name=" + name
				+ "]";
	}
 
	

}
