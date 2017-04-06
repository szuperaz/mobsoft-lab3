package com.example.zita.lab3;

import com.example.zita.lab3.ui.UIModule;
import com.example.zita.lab3.ui.details.DetailsActivity;
import com.example.zita.lab3.ui.message.MessageActivity;
import com.example.zita.lab3.ui.overview.OverviewActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {

    void inject(OverviewActivity overviewActivity);
    void inject(MessageActivity messageActivity);
    void inject(DetailsActivity detailsActivity);

}