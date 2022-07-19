package com.yodha.gadvasu.ApiResponsedata.SalesAnalysis;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("manure_sold")
	private String manureSold;

	@SerializedName("other_datasold_write")
	private String otherDatasoldWrite;

	@SerializedName("total_milk_sold_today_price")
	private String totalMilkSoldTodayPrice;

	@SerializedName("gee_product_sold")
	private String geeProductSold;

	@SerializedName("pdate")
	private String pdate;

	@SerializedName("animal_sold")
	private String animalSold;

	@SerializedName("gunny_bag_sold")
	private String gunnyBagSold;

	@SerializedName("total_milk_sold_today")
	private String totalMilkSoldToday;

	@SerializedName("other_datasold_price")
	private String otherDatasoldPrice;

	public String getManureSold(){
		return manureSold;
	}

	public String getOtherDatasoldWrite(){
		return otherDatasoldWrite;
	}

	public String getTotalMilkSoldTodayPrice(){
		return totalMilkSoldTodayPrice;
	}

	public String getGeeProductSold(){
		return geeProductSold;
	}

	public String getPdate(){
		return pdate;
	}

	public String getAnimalSold(){
		return animalSold;
	}

	public String getGunnyBagSold(){
		return gunnyBagSold;
	}

	public String getTotalMilkSoldToday(){
		return totalMilkSoldToday;
	}

	public String getOtherDatasoldPrice(){
		return otherDatasoldPrice;
	}
}