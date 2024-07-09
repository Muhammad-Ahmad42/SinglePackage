package com.example.singlepackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Bundles extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapterOfFragments viewPagerAdapterOfFragments;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundles);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();

        setupBottomNavigationView();

        // Handle tab selection
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Rs10Shop()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_TopOffers()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_AllInOne()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Data()).commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Voice()).commit();
                        break;
                    case 5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_StayHome()).commit();
                        break;
                    case 6:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Social()).commit();
                        break;
                    case 7:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_SMS()).commit();
                        break;
                    case 8:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_RegionalOffers()).commit();
                        break;
                    case 9:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Favourites()).commit();
                        break;
                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new Frag_Rs10Shop()).commit();
                        break;
                }
                tabLayout.getTabAt(position).select();
                super.onPageSelected(position);
            }
        });
    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.Homes1) {
                    startActivity(new Intent(Bundles.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Usages1) {
                    startActivity(new Intent(Bundles.this, Usage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Bundles1) {
                    // Do nothing as we're already in Bundles activity
                    return true;
                } else if (itemId == R.id.ZPlays1) {
                    startActivity(new Intent(Bundles.this, zPlay.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Mores1) {
                    startActivity(new Intent(Bundles.this, More.class));
                    overridePendingTransition(0, 0); // Optional: No transition animation
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.Bundles1);
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        tabLayout = findViewById(R.id.bundleTabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPagerAdapterOfFragments = new ViewPagerAdapterOfFragments(this);
        viewPager2.setAdapter(viewPagerAdapterOfFragments);
        frameLayout = findViewById(R.id.frameLayout1);
    }
}
