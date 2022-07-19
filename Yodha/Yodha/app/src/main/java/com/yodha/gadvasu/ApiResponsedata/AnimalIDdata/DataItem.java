package com.yodha.gadvasu.ApiResponsedata.AnimalIDdata;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("animal_id")
	private String animalId;

	@SerializedName("type")
	private int type;

	public String getAnimalId(){
		return animalId;
	}

	public int getType(){
		return type;
	}
}