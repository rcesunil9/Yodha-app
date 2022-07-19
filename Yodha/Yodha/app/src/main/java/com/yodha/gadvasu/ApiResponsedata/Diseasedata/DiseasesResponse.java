package com.yodha.gadvasu.ApiResponsedata.Diseasedata;

import com.google.gson.annotations.SerializedName;

public class DiseasesResponse{

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