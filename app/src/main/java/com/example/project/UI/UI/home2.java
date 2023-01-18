package com.example.project.UI.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.example.project.R;
import com.example.project.UI.Adapter.productAdapter;
import com.example.project.UI.ViewModel.ProductViewModel;
import com.example.project.UI.data.RemoteData.ProductModel;
import com.example.project.databinding.ActivityHome2Binding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class home2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHome2Binding binding;
    RecyclerView rec1,rec2;
    productAdapter adapter;
    Button account,cartt,not,searchh,fav,pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        rec1 = findViewById(R.id.homerec1);
        rec2 = findViewById(R.id.homerec2);
        cartt = findViewById(R.id.cart);
        not = findViewById(R.id.notify);
        pro = findViewById(R.id.prof);
        account=findViewById(R.id.acc);
        fav=findViewById(R.id.favo);
        searchh=findViewById(R.id.search);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home2.this,profile.class));
            }
        });

        ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                adapter=new productAdapter(home2.this,productModel);
                rec1.setAdapter(adapter);
                rec1.setLayoutManager(new LinearLayoutManager(home2.this,LinearLayoutManager.HORIZONTAL,false));
                rec2.setAdapter(adapter);
                rec2.setLayoutManager(new LinearLayoutManager(home2.this,LinearLayoutManager.HORIZONTAL,false));


            }

        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home2.this,favourits.class));

            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home2.this,notification.class));

            }
        });
        cartt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home2.this,mycart.class));
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home2.this,acc.class);
                startActivity(intent);
            }
        });
        searchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home2.this,search.class);
                startActivity(intent);
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("anss","sel1");

        switch (item.getItemId()) {
            case R.id.profilee:
                Log.d("anss","sel2");

                startActivity(new Intent(this,profile.class));
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}