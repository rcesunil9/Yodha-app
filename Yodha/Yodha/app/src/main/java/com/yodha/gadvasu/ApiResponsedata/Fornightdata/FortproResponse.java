package com.yodha.gadvasu.ApiResponsedata.Fornightdata;

import com.google.gson.annotations.SerializedName;

public class FortproResponse{

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