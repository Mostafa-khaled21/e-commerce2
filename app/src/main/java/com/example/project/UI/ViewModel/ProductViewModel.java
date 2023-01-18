package com.example.project.UI.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project.UI.Retrofit.RetrofitClient;
import com.example.project.UI.data.RemoteData.ProductModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
   private MutableLiveData<ProductModel>prodlist;
   public LiveData<ProductModel> getProduct(){
       if (prodlist ==null){
           prodlist =new MutableLiveData<ProductModel>();

           loadProd();
       }
       return prodlist;
   }

    private void loadProd() {
       Call<ProductModel> call= RetrofitClient.getInstance().getMyAPI().getProducts();
       call.enqueue(new Callback<ProductModel>() {
           @Override
           public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
               if (!response.isSuccessful()){
                   Log.d("answer","res");

               }
               prodlist.setValue(response.body());
           }

           @Override
           public void onFailure(Call<ProductModel> call, Throwable t) {
               Log.d("answer","fail");

           }
       });
    }
}
