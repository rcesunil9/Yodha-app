package com.yodha.gadvasu.ApiResponsedata.Todayproduct;

import com.google.gson.annotations.SerializedName;

public class TodayproductResponse{

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