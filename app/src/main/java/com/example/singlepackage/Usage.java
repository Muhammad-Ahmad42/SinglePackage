package com.example.singlepackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Usage extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage);

        initViews();
        setupBottomNavigationView();
    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.Homes1) {
                    startActivity(new Intent(Usage.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Usages1) {
                    return true;
                } else if (itemId == R.id.Bundles1) {
                    startActivity(new Intent(Usage.this, Bundles.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.ZPlays1) {
                    startActivity(new Intent(Usage.this, zPlay.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Mores1) {
                    startActivity(new Intent(Usage.this, More.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.Usages1);
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }
}
