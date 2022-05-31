package com.zensar.OSA.bean;

import java.util.Objects;

public class CustomerRequest {
	private int customerReqId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	
	public int getCustomerReqId() {
		return customerReqId;
	}
	public void setCustomerReqId(int customerReqId) {
		this.customerReqId = customerReqId;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerRequest [customerReqId=" + customerReqId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequest(int customerReqId, String firstName, String lastName, String mobileNumber, String email) {
		super();
		this.customerReqId = customerReqId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public CustomerRequest(String firstName, String lastName, String mobileNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerReqId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRequest other = (CustomerRequest) obj;
		return Objects.equals(customerReqId, other.customerReqId);
	}

	
}
