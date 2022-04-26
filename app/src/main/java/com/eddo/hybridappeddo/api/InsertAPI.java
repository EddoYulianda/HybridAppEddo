package com.eddo.hybridappeddo.api;
import com.eddo.hybridappeddo.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertAPI {
    @FormUrlEncoded
    @POST("insertuser.php")
    Call<UserModel> insertdata(
            @Field("username")String username,
            @Field("password")String password,
            @Field("email")String email,
            @Field("phone")String phone
    );
}
