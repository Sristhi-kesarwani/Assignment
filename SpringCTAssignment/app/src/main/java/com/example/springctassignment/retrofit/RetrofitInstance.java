package com.example.springctassignment.retrofit;

import com.example.springctassignment.services.LoginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance instance;

    LoginApi loginInterface;

    String api = "https://reqres.in/api/";

    RetrofitInstance () {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();

        loginInterface = retrofit.create(LoginApi.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null){
            instance = new RetrofitInstance();
        }

        return instance;
    }
}
