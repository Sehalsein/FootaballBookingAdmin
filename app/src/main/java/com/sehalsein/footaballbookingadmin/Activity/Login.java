package com.sehalsein.footaballbookingadmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sehalsein.footaballbookingadmin.R;

public class Login extends AppCompatActivity {

    //Firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //Layout
    private EditText mEmailId;
    private EditText mPassword;

    //Variable
    private String emailId;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        mEmailId = (EditText) findViewById(R.id.edittext_email_id);
        mPassword = (EditText) findViewById(R.id.edittext_password);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("Check ", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("Check ", "onAuthStateChanged:signed_out");
                }
            }
        };

    }

    public void register(View view) {
        Toast.makeText(Login.this, "REGISTER", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Login.this, Registration.class));
    }

    public void login(View view) {
        Log.d("Login ", "Click");
        if (validate()) {
            emailId = mEmailId.getText().toString();
            password = mPassword.getText().toString();

            mAuth.signInWithEmailAndPassword(emailId, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("Sign IN", "signInWithEmail:onComplete:" + task.isSuccessful());

                            if (!task.isSuccessful()) {
                                Log.w("Sign In", "signInWithEmail", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Login.this, AdminHome.class));
                            }

                        }
                    });
        }


    }

    private boolean validate() {
        boolean emailId, password;
        if (isEmpty(mEmailId)) {
            emailId = false;
        } else {
            emailId = true;
        }
        if (isEmpty(mPassword)) {
            password = false;
        } else {
            password = true;
        }
        if (emailId && password) {
            //Toast.makeText(Registration.this, "COMPLETE", Toast.LENGTH_SHORT).show();
            Log.d("Validation ", " Complete");
            return true;
        } else {
            //Toast.makeText(Registration.this, "INCOMPLETE", Toast.LENGTH_SHORT).show();
            Log.d("Validation ", " Incomplete");
            return false;
        }
    }

    private boolean isEmpty(EditText myeditText) {
        boolean empty = myeditText.getText().toString().trim().length() == 0;
        if (empty) {
            myeditText.setError("Enter Field");
        }
        return empty;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
