package com.example.project.UI.Retrofit;

import com.example.project.UI.data.RemoteData.ProductModel;
import com.example.project.UI.data.RemoteData.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    String BASE_URL="https://dummyjson.com/";

    @GET("products")
    Call<ProductModel> getProducts();
    @GET("users")
    Call<Users> getusers();
}
