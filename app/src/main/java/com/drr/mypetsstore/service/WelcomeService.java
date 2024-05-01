package com.drr.mypetsstore.service;

import com.drr.mypetsstore.dto.UserDTO;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WelcomeService {

    @POST("login")
    Call<Map<String, String>> login(@Body UserDTO userDTO);

}
