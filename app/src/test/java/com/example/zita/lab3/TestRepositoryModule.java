package com.example.zita.lab3;

import com.example.zita.lab3.repository.MemoryRepository;
import com.example.zita.lab3.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
