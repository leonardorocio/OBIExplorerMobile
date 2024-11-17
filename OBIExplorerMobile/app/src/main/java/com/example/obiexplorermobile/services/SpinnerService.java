package com.example.obiexplorermobile.services;

import android.os.Handler;
import android.os.Looper;

import com.example.obiexplorermobile.dto.Questao;
import com.example.obiexplorermobile.dto.SpinnerCallback;
import com.example.obiexplorermobile.dto.SpinnerItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class SpinnerService {

    private final String API_URL = "http://10.0.2.2:8080/api";

    private final OkHttpClient httpClient = createClient();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private OkHttpClient createClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    public void fetchList(String endpoint, SpinnerCallback callback) {
        executorService.execute(() -> {
            try {
                List<SpinnerItem> list = getSpinnerItemList(endpoint);
                handler.post(() -> callback.onSuccess(list));
            } catch (Exception e) {
                handler.post(() -> callback.onFailure(e));
            }
        });
    }

    public List<SpinnerItem> getSpinnerItemList(String endpoint, String param) {
        List<SpinnerItem> spinnerItemList = Collections.emptyList();
        Type type = new TypeToken<List<SpinnerItem>>() {}.getType();
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(this.API_URL + endpoint)).newBuilder();

        String urlWithParams = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(urlWithParams)
                .build();

        try (Response response = this.httpClient.newCall(request).execute()) {
            if (response.body() != null) {
                spinnerItemList = new Gson().fromJson(response.body().string(), type);
            }
            return spinnerItemList;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<SpinnerItem> getSpinnerItemList(String endpoint) {
        return this.getSpinnerItemList(endpoint, "");
    }
}
