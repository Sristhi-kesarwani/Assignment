package com.example.springctassignment.services;

import com.example.springctassignment.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("/login")
    Call<LoginModel> createPost(@Body LoginModel loginModel);
}
