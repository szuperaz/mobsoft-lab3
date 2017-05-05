package com.example.zita.lab3.interactor.events;

import com.example.zita.lab3.model.Plant;

public class GetPlantEvent {
    private Throwable throwable;
    private Plant plant;

    public GetPlantEvent(Throwable throwable, Plant plant) {
        this.throwable = throwable;
        this.plant = plant;
    }

    public GetPlantEvent() {

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
