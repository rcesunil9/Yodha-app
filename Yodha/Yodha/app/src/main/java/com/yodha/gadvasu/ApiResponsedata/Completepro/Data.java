package com.yodha.gadvasu.ApiResponsedata.Completepro;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("farmName")
	private String farmName;

	@SerializedName("education")
	private String education;

	@SerializedName("address")
	private String address;

	@SerializedName("gender")
	private String gender;

	@SerializedName("town")
	private String town;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("farmSize")
	private String farmSize;

	@SerializedName("pin")
	private String pin;

	@SerializedName("street")
	private String street;

	@SerializedName("district")
	private String district;

	@SerializedName("name")
	private String name;

	@SerializedName("state")
	private String state;

	@SerializedName("email")
	private String email;

	@SerializedName("age")
	private String age;

	public String getFarmName(){
		return farmName;
	}

	public String getEducation(){
		return education;
	}

	public String getAddress(){
		return address;
	}

	public String getGender(){
		return gender;
	}

	public String getTown(){
		return town;
	}

	public String getMobile(){
		return mobile;
	}

	public String getFarmSize(){
		return farmSize;
	}

	public String getPin(){
		return pin;
	}

	public String getStreet(){
		return street;
	}

	public String getDistrict(){
		return district;
	}

	public String getName(){
		return name;
	}

	public String getState(){
		return state;
	}

	public String getEmail(){
		return email;
	}

	public String getAge(){
		return age;
	}
}