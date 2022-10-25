package com.abdullahshahzad.i192012;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SignIn extends Activity {
    Button to_signUp;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        to_signUp = findViewById(R.id.to_signUp);

        to_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(SignIn.this, SignUp.class);
                        startActivity(myIntent);
                    }
                }, 0);
            }
        });
    }
}
