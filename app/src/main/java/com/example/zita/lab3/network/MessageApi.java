package com.example.zita.lab3.network;

import com.example.zita.lab3.model.Message;

import retrofit2.Call;
import retrofit2.http.*;

public interface MessageApi {

    /**
     * Sends a message
     * Users can send messages to the horticulture
     * @param messageWithEmail The message the usesr sending alon with an email address to reply to.
     * @return Call<Void>
     */

    @POST("messages")
    Call<Void> messagesPost(
            @Body Message messageWithEmail
    );


}
