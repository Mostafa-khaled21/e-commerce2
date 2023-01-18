package com.example.project.UI.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.project.R;
import com.example.project.UI.ViewModel.userViewModel;
import com.example.project.UI.data.RemoteData.Users;

public class signin extends AppCompatActivity {
Button signIn;
TextView signup,forget;
    int position1;
    EditText email,pass;
Boolean x=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signIn= findViewById(R.id.button_sign_in);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        signup= findViewById(R.id.textView10);
        forget= findViewById(R.id.textView9);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this,forgetpassword.class));
            }
        });
        userViewModel userViewModel=new ViewModelProvider(this).get(userViewModel.class);
        userViewModel.getUsers().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {
                signIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        for (int i=0;i<30;i++){
                            if (email.getText().toString().equalsIgnoreCase(users.getUsers().get(i).getEmail())&&
                                    pass.getText().toString().equalsIgnoreCase(users.getUsers().get(i).getPassword())){
                                Log.d("answer","if");

                                Intent intent=new Intent(signin.this,home2.class);
                                position1 =i;
                                Intent ii=new Intent(signin.this,profile.class);
                                ii.putExtra("positionn",position1);

                                startActivity(intent);
                                Log.d("answer","if done");
                                x=false;

                                break;
                            }

                        }
                        if (x) {
                            Toast.makeText(signin.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signin.this,signup.class);
                startActivity(intent);
            }
        });
    }
}