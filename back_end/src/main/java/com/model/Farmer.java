package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Farmer {

	@Id
	@GeneratedValue
	private int farmerId;

	private String farmerFirstName;
	private String farmerLastName;

	@Column(unique = true, nullable = false)
	private String mobile;
	private String emailId;
	private String address;
	private String password;

	@OneToMany(mappedBy = "farmer", fetch=FetchType.LAZY)
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Crop> cropsList;

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerFirstName() {
		return farmerFirstName;
	}

	public void setFarmerFirstName(String farmerFirstName) {
		this.farmerFirstName = farmerFirstName;
	}

	public String getFarmerLastName() {
		return farmerLastName;
	}

	public void setFarmerLastName(String farmerLastName) {
		this.farmerLastName = farmerLastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Crop> getCropsList() {
		return cropsList;
	}

	public void setCropsList(List<Crop> cropsList) {
		this.cropsList = cropsList;
	}

}
