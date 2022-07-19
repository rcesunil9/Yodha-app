package com.yodha.gadvasu.ApiResponsedata.Otpverification;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("profile_completed")
	private int profileCompleted;

	@SerializedName("name")
	private String name;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public int getProfileCompleted(){
		return profileCompleted;
	}

	public String getName(){
		return name;
	}

	public String getMobile(){
		return mobile;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}
}