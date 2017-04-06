package com.example.zita.lab3.ui.message;

import android.os.Bundle;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.R;
import com.example.zita.lab3.ui.BaseActivity;

import javax.inject.Inject;

public class MessageActivity extends BaseActivity implements MessageScreen {
    @Inject
    MessagePresenter messagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        messagePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        messagePresenter.detachScreen();
    }
    @Override
    public void showSuccessMessage() {
        // TODO implement me
    }

    public void openPhotoPicker() {
        // TODO implement me
    }
}
