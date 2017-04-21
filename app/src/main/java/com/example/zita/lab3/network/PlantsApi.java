package com.example.zita.lab3.network;

import com.example.zita.lab3.model.Plant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlantsApi {

    /**
     * Plants
     * Returns all the plants available in the system.
     *
     * @param date Date of last update, ISO formatted date string
     * @return Call<List<Plant>>
     */

    @GET("plants")
    Call<List<Plant>> plantsGet(
            @Query("date") String date
    );
}
