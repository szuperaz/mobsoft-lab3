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
    public void toggleFavouriteStatus(Long plantId) {
        Plant plant = SugarRecord.findById(Plant.class, plantId);
        plant.setFavourite(!plant.isFavourite());
        SugarRecord.saveInTx(plant);
    }
}
