package com.example.zita.lab3.ui.message;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.R;
import com.example.zita.lab3.model.Message;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        messagePresenter.sendMessage(new Message(1L, ((TextView)findViewById(R.id.message)).getText().toString(), null, ((TextView)findViewById(R.id.email)).getText().toString()));
        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void showSuccessMessage() {
        // TODO implement me
    }

    public void openPhotoPicker() {
        // TODO implement me
    }
}
