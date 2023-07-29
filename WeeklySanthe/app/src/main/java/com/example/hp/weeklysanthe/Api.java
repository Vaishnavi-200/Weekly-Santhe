package com.example.hp.weeklysanthe;

/**
 * Created by HP on 20-03-2023.
 */
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface Api  {
//
    String BASE_URL = "https://viable-goggles.000webhostapp.com/API4/";



    @GET("https://courant-conversion.000webhostapp.com/API2/get_Cstationname.php")
    Call<List<ChargeArray>> getChargeName(@Query("f1") String str_cities);


    @GET("https://courant-conversion.000webhostapp.com/API2/get_Cstation_details.php")
    Call<List<ChargeArray>> getChargeDetails(@Query("f1") String string_charge);








    @POST("F_Signup.php")
    Call<IsExist> Farmersign_page(
            @Query("f1") String fullname,
            @Query("f2") String mobile,
            @Query("f3") String email,
            @Query("f4") String aadharno,
            @Query("f5") String city,
            @Query("f6") String password
    );

    @POST("M_Signup.php")
    Call<IsExist> Merchantsign_page(
            @Query("f1") String Mfullname,
            @Query("f2") String Mmobile,
            @Query("f3") String Memail,
            @Query("f4") String Maadharno,
            @Query("f5") String Mcity,
            @Query("f6") String Mpassword
    );

    @POST("Insert_Veg.php")
    Call<IsExist> Vegetables_page (
            @Query("f1") String v1,         //sent to api//
            @Query("f2") String v2,
            @Query("f3") String v3,
            @Query("f4") String v4,
            @Query("f5") String v5,
            @Query("f6") String v6
    );

    @GET("https://viable-goggles.000webhostapp.com/API4/get_veg_name.php")
    Call<List<VegetableArray>> getVegName(@Query("f1") String str_veg);

    @GET("https://viable-goggles.000webhostapp.com/API4/get_veg_details.php")
    Call<List<VegetableArray>> getVegDetails(@Query("f1") String string_veg);


    @GET("https://courant-conversion.000webhostapp.com/API2/get_Cstationname.php")
    Call<List<FruitArray>> getFruName(@Query("f1") String string);

    @GET("https://courant-conversion.000webhostapp.com/API2/get_station_details.php")
    Call<List<FruitArray>> getFruDetails(@Query("f1") String string);

    @GET("https://courant-conversion.000webhostapp.com/API2/get_Cstationname.php")
    Call<List<GroceryArray>> getGroName(@Query("f1") String string);


    @GET("https://courant-conversion.000webhostapp.com/API2/get_station_details.php")
    Call<List<GroceryArray>> getGroDetails(@Query("f1") String string);







//    @POST("Insert_Veg.php")
//    Call<IsExist> Vegetables_page (
//            @Query("f1") String vn1,         //sent to api//
//            @Query("f2") String vp2,
//            @Query("f3") String vd3,
//            @Query("f4") String vc4,
//            @Query("f5") String vl5,
//            @Query("f6") String vv6
//    );
    @POST("Insert_Fruit.php")
    Call<IsExist> Fruits_page (
            @Query("f1") String fn1,         //sent to api//
            @Query("f2") String fp2,
            @Query("f3") String fd3,
            @Query("f4") String fc4,
            @Query("f5") String fl5,
            @Query("f6") String ff6
    );
    @POST("Insert_Grocery.php")
    Call<IsExist> Groceries_page (
            @Query("f1") String g1,         //sent to api//
            @Query("f2") String g2,
            @Query("f3") String g3,
            @Query("f4") String g4,
            @Query("f5") String g5,
            @Query("f6") String g6
    );
    @GET("https://cagiest-cheeks.000webhostapp.com/API4/Veg_Display.php")
    Call<List<VegArray_page>> vegnamelist(@Query("f1") String vn1,@Query("f4") String vc4);

    @GET("https://cagiest-cheeks.000webhostapp.com/API4/Fruits_Display.php")
    Call<List<FruitArray_page>> fruittnamelist(@Query("f1") String dept,@Query("f2") String sem);

    @GET("https://cagiest-cheeks.000webhostapp.com/API4/Grocery_Display.php")
    Call<List<GroceryArray_page>> grocerynamelist(@Query("f1") String dept,@Query("f2") String sem);
}


