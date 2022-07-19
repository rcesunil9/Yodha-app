package com.yodha.gadvasu.ApiResponsedata.Animaldetailsdata;

import com.google.gson.annotations.SerializedName;

public class AnimalsubmitResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status")
	private boolean status;

	public String getMsg(){
		return msg;
	}

	public boolean isStatus(){
		return status;
	}
}