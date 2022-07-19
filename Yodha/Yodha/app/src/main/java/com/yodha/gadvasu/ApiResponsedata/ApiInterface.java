package com.yodha.gadvasu.ApiResponsedata;

import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.AnimalidResponse;
import com.yodha.gadvasu.ApiResponsedata.Animaldetailsdata.AnimalsubmitResponse;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.AnimallistdetdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Completepro.CompleteResponse;
import com.yodha.gadvasu.ApiResponsedata.Deasesdetailsdata.DeasesdetilsdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Deletedata.DeletedataResponse;
import com.yodha.gadvasu.ApiResponsedata.Diseasedata.DiseasesResponse;
import com.yodha.gadvasu.ApiResponsedata.Expenduturedata.ExpendetureResponse;
import com.yodha.gadvasu.ApiResponsedata.Expenduturedeatils.ExpendturedataResponse;
import com.yodha.gadvasu.ApiResponsedata.Fornightdata.FortproResponse;
import com.yodha.gadvasu.ApiResponsedata.Logindata.LoginResponse;
import com.yodha.gadvasu.ApiResponsedata.Otpverification.OtpsendResponse;
import com.yodha.gadvasu.ApiResponsedata.Otpverification.OtpverifiedResponse;
import com.yodha.gadvasu.ApiResponsedata.Productiondetails.ProductdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Reproductiondata.ReproductionResponse;
import com.yodha.gadvasu.ApiResponsedata.Reproductiondetails.ReproductionDetailsResponse;
import com.yodha.gadvasu.ApiResponsedata.SalesAnalysis.SalesdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Todayproduct.TodayproductResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    String BASE_URL = "https://ambulancebooking24.com/yodha/api/";

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> getLogin(@Field("mobile") String mobile);


    @FormUrlEncoded
    @POST("completeProfile.php")
    Call<CompleteResponse> getcompleteprofile(@Field("mobile") String mobile, @Field("name") String name, @Field("email") String email, @Field("gender") String gender, @Field("age") String age, @Field("education") String education, @Field("farmSize") String farmSize,
                                              @Field("farmName") String farmName, @Field("address") String address, @Field("street") String street, @Field("town") String town, @Field("pin") String pin, @Field("state") String state, @Field("district") String district);


    @FormUrlEncoded
    @POST("sendOtp.php")
    Call<OtpsendResponse> getotp(@Field("name") String name, @Field("email") String email, @Field("mobile") String mobile);


    @FormUrlEncoded
    @POST("verityOtp.php")
    Call<OtpverifiedResponse> Verifyotp(@Field("mobile") String name, @Field("otp") String email);


    @FormUrlEncoded
    @POST("animal.php")
    Call<AnimalsubmitResponse> animaldetails(@Field("user_id") String user_id, @Field("animal_id") String animal_id, @Field("species") String species, @Field("breed") String breed, @Field("sex") String sex, @Field("type") String type, @Field("dob") String dob, @Field("sire_no") String sire_no,
                                             @Field("dam_num") String dam_no, @Field("dateofpurchase") String dateofpurchase, @Field("source_of_purchase") String source_of_purchase, @Field("purchased_from") String purchased_from, @Field("owner_mobile") String owner_mobile, @Field("geo_tagging") String geo_tagging);

    @FormUrlEncoded
    @POST("animalIdListing.php")
    Call<AnimalidResponse> getanimallist(@Field("user_id") String userid);



    @FormUrlEncoded
    @POST("daily_producation.php")
    Call<TodayproductResponse> savetodayproduct(@Field("user_id") String user_id, @Field("animal_id") String animal_id, @Field("pdate") String pdate, @Field("milk_yield_morning") String milkyielmorn, @Field("milk_sold_morning") String milksoldmorn, @Field("milk_used_for_calves") String milkusedmorn, @Field("milk_used_for_home") String milkusedhomemorn,
                                                @Field("milk_yield_evening") String milkyieleven, @Field("milk_sold_evening") String milksoldeven, @Field("milk_used_for_calves_evening") String milkcalveseven, @Field("milk_used_for_home_evening") String milkhomeven, @Field("total_milk_sold_today") String milktotaltoday,
                                                @Field("total_milk_sold_today_price") String milktotaltodaysold, @Field("total_today_production") String milktotaltodaysoldprice, @Field("animal_sold") String animalsoldprice, @Field("gunny_bag_sold") String gunnysoldprice, @Field("manure_sold") String manuresoldprice, @Field("gee_product_sold") String geesoldprice,
                                                @Field("other_datasold_write") String othersoldwrt, @Field("other_datasold_price") String othersold);


    @FormUrlEncoded
    @POST("animalExpenditure.php")
    Call<ExpendetureResponse> saveexpenture(@Field("user_id") String user_id,@Field("animal_id") String animal_id, @Field("pdate") String pdate, @Field("animal_purchase") String animal_purchase, @Field("feed_purchase_weight") String feed_purchase_weight, @Field("feed_purchase_amount") String feed_purchase_amount, @Field("mineral_mixed_cost_weight") String mineral_mixed_cost_weight, @Field("mineral_mixed_amount") String mineral_mixed_amount,
                                            @Field("green_footer_weight") String green_footer_weight, @Field("green_footer_amount") String green_footer_amount, @Field("vaccination_cost") String vaccination_cost, @Field("medicine_cost") String medicine_cost, @Field("vet_cost") String vet_cost, @Field("Ai_cost") String Ai_cost, @Field("shelter_cost") String shelter_cost,
                                            @Field("new_equipment_name") String new_equipment_name, @Field("new_equipment_cost") String new_equipment_cost, @Field("labout_expenditure_cost") String labout_expenditure_cost, @Field("electricity_cost") String electricity_cost, @Field("loan_interest") String loan_interest, @Field("construction_cost") String construction_cost,
                                            @Field("insurance_cost") String insurance_cost, @Field("misc_expensive") String misc_expensive);


    @FormUrlEncoded
    @POST("fortnightProducation.php")
    Call<FortproResponse> savefortnight(@Field("user_id") String user_id, @Field("animal_id") String animal_id, @Field("pdate") String pdate, @Field("milk_yield_morning") String milkyielmorn, @Field("milk_sold_morning") String milksoldmorn, @Field("milk_used_for_calves") String milkusedmorn, @Field("milk_used_for_home") String milkusedhomemorn,
                                        @Field("snf_morning") String snf_morning, @Field("fat_morning") String fat_morning, @Field("milk_yield_evening") String milkyieleven, @Field("milk_sold_evening") String milksoldeven, @Field("milk_used_for_calves_evening") String milkcalveseven, @Field("milk_used_for_home_evening") String milkhomeven, @Field("snf_evening") String snf_evening,
                                        @Field("fat_evening") String fat_evening, @Field("total_today_production") String milktotaltoday,@Field("total_milk_sold_today") String milktotaltodaysold, @Field("total_milk_sold_today_price") String milktotaltodaysoldprice, @Field("animal_sold") String animalsoldprice, @Field("gunny_bag_sold") String gunnysoldprice, @Field("manure_sold") String manuresoldprice, @Field("gee_product_sold") String geesoldprice,
                                        @Field("other_datasold_write") String other_datasold_write, @Field("other_datasold_price") String othersold);


    @FormUrlEncoded
    @POST("animalReproducation.php")
    Call<ReproductionResponse> savereproduction(@Field("user_id") String user_id, @Field("animal_id") String animal_id, @Field("first_Al_strawno") String strnum, @Field("first_Al_breed") String breed, @Field("first_Al_date") String aidate, @Field("first_animal_heat") String firstheat, @Field("second_Al_strawno") String second_Al_strawno, @Field("second_Al_breed") String second_Al_breed,
                                                @Field("second_Al_date") String second_Al_date, @Field("second_animal_heat") String second_animal_heat, @Field("third_Al_strawno") String third_Al_strawno, @Field("third_Al_breed") String third_Al_breed, @Field("third_Al_date") String third_Al_date, @Field("third_animal_heat") String third_animal_heat, @Field("fourth_Al_strawno") String fourth_Al_strawno,
                                                @Field("fourth_Al_breed") String fourth_Al_breed, @Field("fourth_Al_date") String fourth_Al_date, @Field("fourth_animal_heat") String fourth_animal_heat, @Field("fifth_Al_strawno") String fifth_Al_strawno, @Field("fifth_Al_breed") String fifth_Al_breed, @Field("fifth_Al_date") String fifth_Al_date,
                                                @Field("fifth_animal_heat") String fifth_animal_heat, @Field("pregnancy_confirmed_on") String pregnancy_confirmed_on, @Field("pregnancy_checked_by") String pregnancy_checked_by, @Field("expected_claving_date") String expected_claving_date, @Field("actual_calving_date") String actual_calving_date);


    @FormUrlEncoded
    @POST("animalDisease.php")
    Call<DiseasesResponse> savediseasedata(@Field("user_id") String user_id, @Field("animal_id") String animal_id, @Field("pdate") String pdate, @Field("disease_detected[0]") String disease_detected0, @Field("disease_detected[1]") String disease_detected1, @Field("disease_detected[2]") String disease_detected2, @Field("disease_comment") String disease_comment, @Field("cured_on_date") String cured_on_date,
                                           @Field("cured_reason") String cured_reason, @Field("relapse_of_disease") String relapse_of_disease, @Field("relapse_of_diseases") String relapse_of_diseases, @Field("vaccination_status") String vaccination_status, @Field("vaccination_date") String vaccination_date, @Field("vaccinated_by") String vaccinated_by);


    @FormUrlEncoded
    @POST("reproductionDetails.php")
    Call<ReproductionDetailsResponse> getReproduction(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("reproductionDetails.php")
    Call<ProductdataResponse> getProduction(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("salesAnalysisDetails.php")
    Call<SalesdataResponse> getSellsdata(@Field("user_id") String user_id);


    @FormUrlEncoded
    @POST("DiseaseDetails.php")
    Call<DeasesdetilsdataResponse> getDesesedat(@Field("user_id") String user_id);


    @FormUrlEncoded
    @POST("animalsDetails.php")
    Call<AnimallistdetdataResponse> getanimallistdata(@Field("user_id") String userid);


    @FormUrlEncoded
    @POST("deleteAnimal.php")
    Call<DeletedataResponse> deleteanimalid(@Field("animal_id") String animal_id);

    @FormUrlEncoded
    @POST("expenditureDetails.php")
    Call<ExpendturedataResponse> getExpenditure(@Field("user_id") String user_id);


}
