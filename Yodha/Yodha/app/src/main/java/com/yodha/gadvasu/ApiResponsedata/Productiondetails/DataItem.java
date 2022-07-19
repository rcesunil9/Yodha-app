package com.yodha.gadvasu.ApiResponsedata.Productiondetails;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("milk_yield_morning")
	private String milkYieldMorning;

	@SerializedName("milk_yield_evening")
	private String milkYieldEvening;

	@SerializedName("milk_used_for_calves_evening")
	private String milkUsedForCalvesEvening;

	@SerializedName("milk_used_for_home")
	private String milkUsedForHome;

	@SerializedName("pdate")
	private String pdate;

	@SerializedName("total_today_production")
	private String totalTodayProduction;

	@SerializedName("animal_id")
	private String animalId;

	@SerializedName("milk_used_for_calves")
	private String milkUsedForCalves;

	@SerializedName("milk_used_for_home_evening")
	private String milkUsedForHomeEvening;

	@SerializedName("milk_sold_evening")
	private String milkSoldEvening;

	@SerializedName("milk_sold_morning")
	private String milkSoldMorning;

	@SerializedName("breed")
	private String breed;

	public String getMilkYieldMorning(){
		return milkYieldMorning;
	}

	public String getMilkYieldEvening(){
		return milkYieldEvening;
	}

	public String getMilkUsedForCalvesEvening(){
		return milkUsedForCalvesEvening;
	}

	public String getMilkUsedForHome(){
		return milkUsedForHome;
	}

	public String getPdate(){
		return pdate;
	}

	public String getTotalTodayProduction(){
		return totalTodayProduction;
	}

	public String getAnimalId(){
		return animalId;
	}

	public String getMilkUsedForCalves(){
		return milkUsedForCalves;
	}

	public String getMilkUsedForHomeEvening(){
		return milkUsedForHomeEvening;
	}

	public String getMilkSoldEvening(){
		return milkSoldEvening;
	}

	public String getMilkSoldMorning(){
		return milkSoldMorning;
	}

	public String getBreed(){
		return breed;
	}
}