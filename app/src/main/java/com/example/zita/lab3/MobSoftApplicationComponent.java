package com.example.zita.lab3;

import com.example.zita.lab3.interactor.InteractorModule;
import com.example.zita.lab3.interactor.MessagesInteractor;
import com.example.zita.lab3.interactor.PlantsInteractor;
import com.example.zita.lab3.repository.RepositoryModule;
import com.example.zita.lab3.ui.UIModule;
import com.example.zita.lab3.ui.details.DetailsActivity;
import com.example.zita.lab3.ui.message.MessageActivity;
import com.example.zita.lab3.ui.overview.OverviewActivity;
import com.example.zita.lab3.ui.overview.OverviewPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {

    void inject(OverviewActivity overviewActivity);
    void inject(MessageActivity messageActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(MessagesInteractor messagesInteractor);
    void inject(PlantsInteractor plantsInteractor);
    void inject(MobSoftApplication mobSoftApplication);

}