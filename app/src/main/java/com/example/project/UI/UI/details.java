package com.example.project.UI.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.UI.ViewModel.ProductViewModel;
import com.example.project.UI.data.LocalData.contactDBHandler1;
import com.example.project.UI.data.RemoteData.ProductModel;

public class details extends AppCompatActivity {
ImageView imageView;
    TextView title,desc,price;
    ImageButton back;
    Button addtocart;
   contactDBHandler1 AMR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView =findViewById(R.id.nike_zoom_w);
        title=findViewById(R.id.nike_air_jo);
        price=findViewById(R.id.textView2);
        desc=findViewById(R.id.textView3);
        back=findViewById(R.id.menuButton);
        addtocart =findViewById(R.id.addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(details.this,mycart.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(details.this,home2.class));
            }
        });

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",1);

        ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                title.setText(productModel.getProducts().get(position).getTitle());

                desc.setText(productModel.getProducts().get(position).getDescription());

                price.setText("$" + String.valueOf(productModel.getProducts().get(position).getPrice()));
                Glide.with(details.this)
                        .load(productModel.getProducts().get(position).getThumbnail())
                        .centerCrop()
                        .into(imageView);
           AMR = new contactDBHandler1(details.this);
           AMR.addContact(title.getText().toString(),
                          price.getText().toString());
            }
        });

    }
}