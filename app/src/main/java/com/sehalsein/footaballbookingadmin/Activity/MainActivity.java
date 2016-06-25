package com.sehalsein.footaballbookingadmin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sehalsein.footaballbookingadmin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this, Login.class));
    }
    public void home(View view) {
        startActivity(new Intent(MainActivity.this, AdminHome.class));
    }
    public void register(View view) {
        startActivity(new Intent(MainActivity.this, Registration.class));
    }
}
