package com.bank.model;

import java.sql.Date;

public class User {
	private String username, password, firstName, lastName,gender, panNo, email, address, city, state, country;
	
	private Date dob;
	private long aadharNo, phoneNo;
	private int pincode;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public User() {
		super();
	}
	
	
	public User(String username, String password, String firstName, String lastName, String gender, String panNo,
			String email, String address, String city, String state, String country, Date dob, long aadharNo,
			long phoneNo, int pincode) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.panNo = panNo;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dob = dob;
		this.aadharNo = aadharNo;
		this.phoneNo = phoneNo;
		this.pincode = pincode;
	}
	
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
