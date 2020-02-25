package com.shinplest.airbnbclone.src.search.interfaces;

import com.shinplest.airbnbclone.src.search.models.SimpleHouseInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRetrofitInterface {
    @GET("/houses")
    Call<SimpleHouseInfoResponse> getSimpleHouseInfo(@Query("search") String search,
                                                     @Query("guest") int guest,
                                                     @Query("houseType") String houseType,
                                                     @Query("bed") int bed,
                                                     @Query("room") int room,
                                                     @Query("bathroom") int bathroom,
                                                     @Query("facilities") String facilities,
                                                     @Query("buildingType") String buildingType,
                                                     @Query("rule") String rule,
                                                     @Query("location") String location,
                                                     @Query("language") String language);
}
