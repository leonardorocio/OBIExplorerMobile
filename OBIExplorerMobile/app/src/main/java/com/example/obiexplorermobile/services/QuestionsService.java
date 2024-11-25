package com.example.obiexplorermobile.services;


import com.example.obiexplorermobile.dto.Questao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class QuestionsService  {

    private final String API_URL = "http://10.0.2.2:8080/api/questions";

    private final OkHttpClient httpClient = createClient();

    private OkHttpClient createClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
    }

    public QuestionsService() {
    }

    public List<Questao> getQuestions(
            String titulo, String enunciado, String ano, String nivel, String modalidade,
            String fase, String categoria, String subcategoria, String topico, String dificuldade
    ) {
        List<Questao> lista = Collections.emptyList();
        Type type = new TypeToken<List<Questao>>() {}.getType();

        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(this.API_URL)).newBuilder();
        String placeholderString = "0";
        urlBuilder.addQueryParameter("valorTitulo", titulo);
        urlBuilder.addQueryParameter("valorEnunciado", enunciado);
        if (!ano.equals(placeholderString)) urlBuilder.addQueryParameter("selectedAnoProva", ano);
        if (!modalidade.contains(placeholderString)) urlBuilder.addQueryParameter("selectedModalidade", modalidade);
        if (!nivel.contains(placeholderString)) urlBuilder.addQueryParameter("selectedNivel", nivel);
        if (!dificuldade.contains(placeholderString)) urlBuilder.addQueryParameter("selectedDificuldade", dificuldade);
        if (!fase.contains(placeholderString)) urlBuilder.addQueryParameter("selectedFase", fase);
        if (!categoria.contains(placeholderString)) urlBuilder.addQueryParameter("selectedCategories", categoria);
        if (!subcategoria.contains(placeholderString)) urlBuilder.addQueryParameter("selectedSubCategories", subcategoria);
        if (!topico.contains(placeholderString)) urlBuilder.addQueryParameter("selectedTopics", topico);

        String urlWithParams = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(urlWithParams)
                .build();

        try (Response response = this.httpClient.newCall(request).execute()) {
            if (response.body() != null) {
                lista = new Gson().fromJson(response.body().string(), type);
            }
            return lista;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}