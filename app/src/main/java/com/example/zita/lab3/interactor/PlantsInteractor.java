package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.repository.Repository;

import java.util.List;

import javax.inject.Inject;

public class PlantsInteractor {

    @Inject
    private Repository repository;

    public PlantsInteractor () {
        MobSoftApplication.injector.inject(this);
    }

    public List<Plant> getPlants () {
        return repository.getPlants();
    }

    public void addPlantToFavourites(Long plantId) {
        repository.addPlantToFavourites(plantId);
    }

    public void deletePlantFromFavourites(Long plantId) {
        repository.deletePlantFromFavourites(plantId);
    }
}
