package com.desigggggnn.firstone.network;

import com.desigggggnn.firstone.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("All_social_login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_id") String device_id,
            @Field("type") int type,
            @Field("social_key") String social_key);




}
