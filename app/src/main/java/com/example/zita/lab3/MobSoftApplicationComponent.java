package com.example.zita.lab3;

import com.example.zita.lab3.ui.UIModule;
import com.example.zita.lab3.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}