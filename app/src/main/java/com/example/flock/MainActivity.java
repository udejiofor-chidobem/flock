package com.example.flock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intersystems.jdbc.IRISDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.journal);

        String dbURL = "jdbc:IRIS://83372d1a-a3d12a76-d6e2cfe457-aadc9b2654b35456.elb.us-east-2.amazonaws.com:1972/USER";
        String user = "SQLAdmin";
        String pass = "G5nmYNAT2syVtLL!";

        IRISDataSource ds = new IRISDataSource();
        try {
            ds.setURL(dbURL);
            ds.setUser(user);
            ds.setPassword(pass);
            Connection dbconnection = ds.getConnection();
            Log.i("Success","Connected to InternSystemsIris via JDBC.");
        } catch (SQLException e) {
            Log.e("Failed",e.getMessage());
        }
    }
    Journal journal = new Journal();
//    Record record = new Record();
    Search search = new Search();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, search).commit();
                return true;

            case R.id.journal:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, journal).commit();
                return true;

            case R.id.record:
                Intent recordSwitch = new Intent(MainActivity.this, Record.class);
                startActivity(recordSwitch);
                return true;
        }
        return false;
    }
}