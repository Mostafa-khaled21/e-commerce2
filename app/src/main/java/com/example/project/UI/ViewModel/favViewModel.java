package com.example.project.UI.ViewModel;

import android.telecom.Call;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project.UI.data.LocalData.contact;
import com.example.project.UI.data.RemoteData.ProductModel;

public class favViewModel extends ViewModel {
    private MutableLiveData<contact> favlist;
    public LiveData<contact> getfav(){
        if (favlist == null){
            favlist = new MutableLiveData<contact>();
        }
        Log.d("anss","favview");
        return favlist;
    }


}
