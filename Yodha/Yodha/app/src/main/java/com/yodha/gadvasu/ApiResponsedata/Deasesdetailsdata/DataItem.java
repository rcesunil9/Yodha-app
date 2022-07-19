package com.yodha.gadvasu.ApiResponsedata.Deasesdetailsdata;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("cured_on_date")
	private String curedOnDate;

	@SerializedName("disease_comment")
	private String diseaseComment;

	@SerializedName("pdate")
	private String pdate;

	@SerializedName("active")
	private int active;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("relapse_of_diseases")
	private String relapseOfDiseases;

	@SerializedName("vaccination_status")
	private int vaccinationStatus;

	@SerializedName("cured_reason")
	private int curedReason;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("relapse_of_disease")
	private String relapseOfDisease;

	@SerializedName("disease_detected")
	private List<String> diseaseDetected;

	@SerializedName("vaccinated_by")
	private int vaccinatedBy;

	@SerializedName("animal_id")
	private String animalId;

	@SerializedName("id")
	private int id;

	@SerializedName("vaccination_date")
	private String vaccinationDate;

	public String getCuredOnDate(){
		return curedOnDate;
	}

	public String getDiseaseComment(){
		return diseaseComment;
	}

	public String getPdate(){
		return pdate;
	}

	public int getActive(){
		return active;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getRelapseOfDiseases(){
		return relapseOfDiseases;
	}

	public int getVaccinationStatus(){
		return vaccinationStatus;
	}

	public int getCuredReason(){
		return curedReason;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getUserId(){
		return userId;
	}

	public String getRelapseOfDisease(){
		return relapseOfDisease;
	}

	public List<String> getDiseaseDetected(){
		return diseaseDetected;
	}

	public int getVaccinatedBy(){
		return vaccinatedBy;
	}

	public String getAnimalId(){
		return animalId;
	}

	public int getId(){
		return id;
	}

	public String getVaccinationDate(){
		return vaccinationDate;
	}
}