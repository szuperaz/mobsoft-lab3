package com.example.zita.lab3.repository;

import android.content.Context;

import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.model.Plant;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Plant> getPlants() {
        return SugarRecord.listAll(Plant.class);
    }

    @Override
    public void saveMessage(Message message) {
        SugarRecord.saveInTx(message);
    }

    @Override
    public void addPlantToFavourites(Long plantId) {
        Plant plant = SugarRecord.findById(Plant.class, plantId);
        plant.setFavourite(true);
        SugarRecord.saveInTx(plant);
    }

    @Override
    public void deletePlantFromFavourites(Long plantId) {
        Plant plant = SugarRecord.findById(Plant.class, plantId);
        plant.setFavourite(false);
        SugarRecord.saveInTx(plant);
    }
}
