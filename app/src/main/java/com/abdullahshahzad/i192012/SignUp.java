package com.abdullahshahzad.i192012;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends Activity {
    FirebaseAuth mAuth;

    EditText name, email, pass;
    Button signup, to_signIn1;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        signup = findViewById(R.id.signup);
        to_signIn1 = findViewById(R.id.to_signIn1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(
                                            SignUp.this,
                                            "Successfully Created User",
                                            Toast.LENGTH_LONG
                                    ).show();
                                    Toast.makeText(
                                            SignUp.this,
                                            mAuth.getCurrentUser().getUid(),
                                            Toast.LENGTH_LONG
                                    ).show();
                                }


                                handler = new Handler(Looper.getMainLooper());
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent myIntent = new Intent(SignUp.this, SignIn.class);
                                        startActivity(myIntent);
                                    }
                                }, 3000);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(
                                        SignUp.this,
                                        "Failed to create User",
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        });
            }
        });

        to_signIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(SignUp.this, SignIn.class);
                        startActivity(myIntent);
                    }
                }, 0);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null)
        {
            Toast.makeText(
                    SignUp.this,
                    user.getUid()+"",
                    Toast.LENGTH_SHORT
            );
        }
    }
}
