package com.yodha.gadvasu.ApiResponsedata.Deletedata;

import com.google.gson.annotations.SerializedName;

public class DeletedataResponse{

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