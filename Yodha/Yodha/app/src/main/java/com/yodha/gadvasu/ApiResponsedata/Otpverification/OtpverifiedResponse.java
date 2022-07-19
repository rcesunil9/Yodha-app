package com.yodha.gadvasu.ApiResponsedata.Otpverification;

import com.google.gson.annotations.SerializedName;

public class OtpverifiedResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private boolean status;

	public String getMsg(){
		return msg;
	}

	public Data getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}
}