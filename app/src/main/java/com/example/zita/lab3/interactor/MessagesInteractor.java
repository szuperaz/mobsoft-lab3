package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.repository.Repository;

import javax.inject.Inject;

public class MessagesInteractor {
    @Inject
    private Repository repository;

    public MessagesInteractor () {
        MobSoftApplication.injector.inject(this);
    }

    public void saveMessage (Message message) {
        repository.saveMessage(message);
    }
}
