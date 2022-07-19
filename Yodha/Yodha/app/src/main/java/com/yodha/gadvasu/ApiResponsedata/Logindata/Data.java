package com.yodha.gadvasu.ApiResponsedata.Logindata;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("farmName")
	private String farmName;

	@SerializedName("education")
	private String education;

	@SerializedName("address")
	private String address;

	@SerializedName("gender")
	private int gender;

	@SerializedName("town")
	private String town;

	@SerializedName("profile_completed")
	private int profileCompleted;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("active")
	private int active;

	@SerializedName("farmSize")
	private int farmSize;

	@SerializedName("pin")
	private int pin;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("street")
	private int street;

	@SerializedName("district")
	private String district;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private String state;

	@SerializedName("email")
	private String email;

	@SerializedName("age")
	private int age;

	public String getFarmName(){
		return farmName;
	}

	public String getEducation(){
		return education;
	}

	public String getAddress(){
		return address;
	}

	public int getGender(){
		return gender;
	}

	public String getTown(){
		return town;
	}

	public int getProfileCompleted(){
		return profileCompleted;
	}

	public String getMobile(){
		return mobile;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getActive(){
		return active;
	}

	public int getFarmSize(){
		return farmSize;
	}

	public int getPin(){
		return pin;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getStreet(){
		return street;
	}

	public String getDistrict(){
		return district;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getState(){
		return state;
	}

	public String getEmail(){
		return email;
	}

	public int getAge(){
		return age;
	}
}