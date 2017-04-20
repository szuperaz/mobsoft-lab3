package com.example.zita.lab3.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public MessagesInteractor provideMessagesInteractor () {
        return new MessagesInteractor();
    }

    @Provides
    public PlantsInteractor providePlantsInteractor () {
        return new PlantsInteractor();
    }
}
