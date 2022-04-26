package com.eddo.hybridappeddo.api;

import com.eddo.hybridappeddo.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectAPI {
    @GET("selectuser.php")
    Call<List<UserModel>> callModel();
}
