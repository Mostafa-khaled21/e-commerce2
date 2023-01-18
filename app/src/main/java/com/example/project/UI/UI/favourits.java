package com.example.project.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.UI.Adapter.f_c_adapter;
import com.example.project.UI.ViewModel.favViewModel;
import com.example.project.UI.data.LocalData.contacDBHandler;
import com.example.project.UI.data.LocalData.contact;

import java.util.ArrayList;

public class favourits extends AppCompatActivity {
ImageButton back;
RecyclerView rec;
f_c_adapter adapter;
ArrayList<String> name,price;
     contacDBHandler DBhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourits);
        back=findViewById(R.id.imageButton2);
        rec=findViewById(R.id.rec_fav);
        Log.d("anss","fav0");
DBhandler =new contacDBHandler(this);
        Log.d("anss","fav01");

name =new ArrayList<>();
price =new ArrayList<>();
        displaydata();

        Log.d("anss","fav1");
        adapter = new f_c_adapter(favourits.this,name,price);
        rec.setAdapter(adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(staggeredGridLayoutManager);
        Log.d("anss","fav2");

//            favViewModel favModel=new ViewModelProvider(this).get(favViewModel.class);
//            favModel.getfav().observe(this, new Observer<com.example.project.UI.data.LocalData.contact>() {
//                @Override
//                public void onChanged(com.example.project.UI.data.LocalData.contact contact) {
//                    Log.d("anss","fav1");
//
//                    adapter = new f_c_adapter(favourits.this,contact);
//                    rec.setAdapter(adapter);
//                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
//                    rec.setLayoutManager(staggeredGridLayoutManager);
//                    Log.d("anss","fav2");
//
//                }
//            });
//            adapter = new f_c_adapter(this,contact);
//            rec.setAdapter(adapter);
//            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
//            rec.setLayoutManager(staggeredGridLayoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(favourits.this,home2.class));
            }
        });

    }
      void displaydata(){
        Cursor cursor=DBhandler.getContact();
        if (cursor .getCount() ==0){
            Toast.makeText(this, "NO data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
            name.add(cursor.getString(0));
            price.add(cursor.getString(1));
        }
        }



        }

}