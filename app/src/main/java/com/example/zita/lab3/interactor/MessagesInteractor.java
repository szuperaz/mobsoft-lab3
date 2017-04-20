package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.events.SaveMessageEvent;
import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.repository.Repository;
import com.google.common.eventbus.EventBus;

import javax.inject.Inject;

public class MessagesInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus eventBus;

    public MessagesInteractor () {
        MobSoftApplication.injector.inject(this);
    }

    public void saveMessage (Message message) {
        SaveMessageEvent event = new SaveMessageEvent();
        event.setMessage(message);
        try {
            repository.saveMessage(message);
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }
}
