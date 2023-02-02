package com.kootam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private Long addressId;
	
	@Column(name = "addr_house_name")
	private String houseName;
	
	@Column(name = "addr_street")
	private String street;
	
	@Column(name = "addr_postoffice")
	private String postOffice;
	
	@Column(name = "addr_district")
	private String district;
	
	@Column(name = "addr_state")
	private String state;
	
	@Column(name = "addr_pincode")
	private Long pinCode;

	public Address() {
		super();
	}

	public Address(String houseName, String street, String postOffice, String district, String state, Long pinCode) {
		super();
		this.houseName = houseName;
		this.street = street;
		this.postOffice = postOffice;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
