package com.yodha.gadvasu.ApiResponsedata.Animallistdetails;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("dateofpurchase")
	private String dateofpurchase;

	@SerializedName("purchased_from")
	private String purchasedFrom;

	@SerializedName("sex")
	private int sex;

	@SerializedName("source_of_purchase")
	private int sourceOfPurchase;

	@SerializedName("geo_tagging")
	private String geoTagging;

	@SerializedName("active")
	private int active;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("owner_mobile")
	private String ownerMobile;

	@SerializedName("type")
	private int type;

	@SerializedName("breed")
	private String breed;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("species")
	private int species;

	@SerializedName("dam_num")
	private String damNum;

	@SerializedName("dob")
	private String dob;

	@SerializedName("sire_no")
	private String sireNo;

	@SerializedName("animal_id")
	private String animalId;

	@SerializedName("id")
	private int id;

	public String getDateofpurchase(){
		return dateofpurchase;
	}

	public String getPurchasedFrom(){
		return purchasedFrom;
	}

	public int getSex(){
		return sex;
	}

	public int getSourceOfPurchase(){
		return sourceOfPurchase;
	}

	public String getGeoTagging(){
		return geoTagging;
	}

	public int getActive(){
		return active;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getOwnerMobile(){
		return ownerMobile;
	}

	public int getType(){
		return type;
	}

	public String getBreed(){
		return breed;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getUserId(){
		return userId;
	}

	public int getSpecies(){
		return species;
	}

	public String getDamNum(){
		return damNum;
	}

	public String getDob(){
		return dob;
	}

	public String getSireNo(){
		return sireNo;
	}

	public String getAnimalId(){
		return animalId;
	}

	public int getId(){
		return id;
	}
}