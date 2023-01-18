package com.example.project.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.UI.Adapter.cartadapter;
import com.example.project.UI.Adapter.f_c_adapter;
import com.example.project.UI.data.LocalData.contacDBHandler;
import com.example.project.UI.data.LocalData.contactDBHandler1;

import java.util.ArrayList;

public class mycart extends AppCompatActivity {
    Button checkbutton;
    ImageButton back;
    RecyclerView rec;
    cartadapter adapter;
    ArrayList<String> name,price;
    contactDBHandler1 DBhandler1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycart);
         checkbutton = (Button)findViewById(R.id.checkoutbutton);
        rec=findViewById(R.id.cart_rec);
        Log.d("anss","fav0");
        DBhandler1 =new contactDBHandler1(this);
        Log.d("anss","fav01");

        name =new ArrayList<>();
        price =new ArrayList<>();
        displaydata();

        Log.d("anss","fav1");
        adapter = new cartadapter(mycart.this,name,price);
        rec.setAdapter(adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(staggeredGridLayoutManager);
        Log.d("anss","fav2");
         back = findViewById(R.id.imageButton5);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(mycart.this,home2.class));
             }
         });

        checkbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(mycart.this, checkout.class));
            }
        });
    }

    void displaydata(){
        Cursor cursor=DBhandler1.getContact();
        if (cursor.getCount() ==0){
            Toast.makeText(this, "NO data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                price.add(cursor.getString(1));
            }
        }



    }



}