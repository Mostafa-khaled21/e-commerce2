package com.example.project.UI.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.UI.Adapter.productAdapter;
import com.example.project.UI.ViewModel.ProductViewModel;
import com.example.project.UI.data.RemoteData.ProductModel;

public class home extends AppCompatActivity {
    RecyclerView rec1,rec2;
    productAdapter adapter;
    Button account,cartt,not,searchh,fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rec1 = findViewById(R.id.homerec1);
        rec2 = findViewById(R.id.homerec2);
        cartt = findViewById(R.id.cart);
        not = findViewById(R.id.notify);
        account=findViewById(R.id.acc);
        fav=findViewById(R.id.favo);
       searchh=findViewById(R.id.search);
        ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                adapter=new productAdapter(home.this,productModel);
                rec1.setAdapter(adapter);
                rec1.setLayoutManager(new LinearLayoutManager(home.this,LinearLayoutManager.HORIZONTAL,false));
                rec2.setAdapter(adapter);
                rec2.setLayoutManager(new LinearLayoutManager(home.this,LinearLayoutManager.HORIZONTAL,false));


            }

        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,favourits.class));

            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,notification.class));

            }
        });
        cartt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,mycart.class));
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home.this,acc.class);
                startActivity(intent);
            }
        });
        searchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home.this,search.class);
                startActivity(intent);
            }
        });

    }
}