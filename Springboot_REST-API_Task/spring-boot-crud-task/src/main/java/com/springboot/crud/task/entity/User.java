package com.springboot.crud.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//-----------Lombok---------------
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "USER_TABLE")

public class User {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Id // Taking Id as Primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // For Auto generation of ID
	private int id;

	@NotBlank(message = "Name should not be null")  // Validations
	private String name;
	
	@NotBlank(message = "Surname should not be null")
	private String surName;
	
	@NotBlank(message = "DOB should not be null")
	private String dob;
	
	@NotBlank(message = "Joining Date should not be null")
	private String joiningDate;
	
	@NotBlank(message = "State should not be null")
	private String state;
	
	@NotBlank(message = "Pincode should not be null")
	private String pincode;

}
