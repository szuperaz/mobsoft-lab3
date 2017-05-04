package com.example.zita.lab3;


import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.ui.message.MessagePresenter;
import com.example.zita.lab3.ui.message.MessageScreen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static com.example.zita.lab3.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MessagesTest {
    private MessagePresenter messagePresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        messagePresenter = new MessagePresenter();
    }

    @Test
    public void testPostMessage() {
        MessageScreen messageScreen = mock(MessageScreen.class);
        messagePresenter.attachScreen(messageScreen);
        messagePresenter.sendMessage(new Message(1L, "Test", null, "zizi@zizi.com"));

        verify(messageScreen, times(1)).showSuccessMessage();
    }
}
