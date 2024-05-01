package com.drr.mypetsstore.service.impl;

import com.drr.mypetsstore.dto.UserDTO;
import com.drr.mypetsstore.service.WelcomeService;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;

public class WelcomeServiceImpl implements WelcomeService {

    private final Retrofit retrofit;

    public WelcomeServiceImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Call<Map<String, String>> login(UserDTO userDTO) {
        WelcomeService service = retrofit.create(WelcomeService.class);
        return service.login(userDTO);
    }

}
