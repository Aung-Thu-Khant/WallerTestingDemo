package com.xaryarak.walletdemo.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.xaryarak.walletdemo.HomePage;
import com.xaryarak.walletdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout usernametl = findViewById(R.id.usernametl);
        TextInputLayout passtl = findViewById(R.id.passtl);
        FloatingActionButton loginbtn = findViewById(R.id.loginbtn);
        TextView textView2 = findViewById(R.id.textView2);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, HomePage.class));

//                if(usernametl.getEditText().getText().toString().isEmpty()){
//                    usernametl.setError("Invalid Username");
//                }else if(passtl.getEditText().getText().toString().isEmpty() ){
//                    passtl.setError("Invaild Password");
//                }else{
//                    Log.d("Data",usernametl.getEditText().getText().toString());
//                    Log.d("Data",passtl.getEditText().getText().toString());
//                    textView2.setText(usernametl.getEditText().getText().toString());
//                }

            }
        });

    }
}