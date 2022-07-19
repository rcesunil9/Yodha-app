package com.yodha.gadvasu.ApiResponsedata.Expenduturedata;

import com.google.gson.annotations.SerializedName;

public class ExpendetureResponse{

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