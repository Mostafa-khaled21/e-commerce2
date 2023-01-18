package com.example.project.UI.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.project.R;

public class checkout extends AppCompatActivity {
Button checkkout,dis;
ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        checkkout=findViewById(R.id.paymentbutton);
        back=findViewById(R.id.imageButton18);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(checkout.this,home2.class));
            }
        });
        checkkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(checkout.this).create();
                View view1= getLayoutInflater().inflate(R.layout.dialog_check,null);
                dis=view1.findViewById(R.id.dialog);
                dis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.setView(view1);

                dialog.show();





            }
        });
    }
}