package com.example.singlepackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class More extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_more);

        initViews();
        setupBottomNavigationView();
    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.Homes1) {
                    startActivity(new Intent(More.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Usages1) {
                    startActivity(new Intent(More.this, Usage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Bundles1) {
                    startActivity(new Intent(More.this, Bundles.class));
                    overridePendingTransition(0, 0);
                    return true;
                }else if (itemId == R.id.Mores1) {
                    return true;
                }
                else if (itemId == R.id.ZPlays1) {
                    startActivity(new Intent(More.this, zPlay.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.Mores1);
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }
}
