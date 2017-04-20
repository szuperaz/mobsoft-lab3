package com.example.zita.lab3.interactor.events;

import com.example.zita.lab3.model.Plant;

import java.util.List;

public class GetPlantsEvent {
    private List<Plant> plants;
    private Throwable throwable;

    public GetPlantsEvent(List<Plant> plants, Throwable throwable) {
        this.plants = plants;
        this.throwable = throwable;
    }

    public GetPlantsEvent() {
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
