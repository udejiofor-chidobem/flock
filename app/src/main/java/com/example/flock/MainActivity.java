package com.example.flock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.journal);

    }
    Journal journal = new Journal();
    Record record = new Record();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.container, record).commit();
                return true;
        }
        return false;
    }
}