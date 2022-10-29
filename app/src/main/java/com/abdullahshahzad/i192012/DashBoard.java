package com.abdullahshahzad.i192012;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class DashBoard extends Activity {
    ImageView log_out;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        log_out=findViewById(R.id.log_out);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(DashBoard.this, SignIn.class);
                        startActivity(myIntent);
                    }
                }, 500);
            }
        });
    }
}