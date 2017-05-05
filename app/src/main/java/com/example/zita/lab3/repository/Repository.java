package com.example.zita.lab3.repository;

import android.content.Context;

import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.model.Plant;

import java.util.List;

public interface Repository {

    void open(Context context);

    void close();

    List<Plant> getPlants();

    Plant getPlant(Long plantId);

    Plant toggleFavouriteStatus(Long plantId);

}
