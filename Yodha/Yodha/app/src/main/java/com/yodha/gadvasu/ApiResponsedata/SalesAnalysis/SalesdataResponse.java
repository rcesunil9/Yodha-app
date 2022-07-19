package com.yodha.gadvasu.ApiResponsedata.SalesAnalysis;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SalesdataResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public String getMsg(){
		return msg;
	}

	public List<DataItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}
}