package com.example.zita.lab3.mock;

import android.net.Uri;

import com.example.zita.lab3.network.GsonHelper;
import com.example.zita.lab3.network.NetworkConfig;
import com.example.zita.lab3.repository.MemoryRepository;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.zita.lab3.mock.MockHelper.makeResponse;

public class PlantsMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "plants") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getPlants());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
