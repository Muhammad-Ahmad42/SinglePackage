package com.example.singlepackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageSlider imageSlider;
    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;


    FloatingActionButton ic_floatingActionBtn2;
    RecyclerView recyclerViewOfHotOfferPackage;
   hotPackageAdapter adapter;


    EditText etOfferNameOfHotOffer,etNumberofDataHotPackages,
            etNumberofOffNetMinsHotPackages,
            etNumberofZonsMinsHotPackages,etPackagePriceHotOffers
            ,etOfferDailyOrWeeklyHotPackages;


    ImageView icon_bell,icon_search_bar,icon_refresh,icon_menu_right,ivMakeYourOwnBundle,ivBachatBazar,
    ivRewards,ivDarazHotDeals,ivBriefHistory,ivRs10Shop,ivGoogleMaps,ivIR,ivTaxCertificate,
            ivOnlineBooking,ivSaveBalance,ivYaariLoad,ivCallBlocks,ivBookYourNumber,ivMoreApps;

    TextView UserPhoneNumber,tvCurrentBalance,tvNumbersOfMBs,tvNumbersOfMinutes,
    tvNumberOfSMS,tvOffersActiveInternet,tvOffersActiveMins,tvOffersActiveSMS;

    Button btnRechargeNow,btnPayLoan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();
        showProgressBar();
        ///////////Progress Bar
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setupImageSlider();
                hideProgressBar();
            }
        }, 4000); ///////////////Progress Bar

        setupBottomNavigationView();

        ic_floatingActionBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.input_hotoffer_package, null);

                //
                etOfferNameOfHotOffer=view.findViewById(R.id.etOfferNameOfHotOffer);
                etNumberofDataHotPackages=view.findViewById(R.id.etNumberofDataHotPackages);
                etNumberofOffNetMinsHotPackages=view.findViewById(R.id.etNumberofOffNetMinsHotPackages);
                etNumberofZonsMinsHotPackages=view.findViewById(R.id. etNumberofZonsMinsHotPackages);
                etPackagePriceHotOffers=view.findViewById(R.id.etPackagePriceHotOffers);
                etOfferDailyOrWeeklyHotPackages=view.findViewById(R.id.etOfferDailyOrWeeklyHotPackages);

                AlertDialog.Builder addNewPackage = new AlertDialog.Builder(MainActivity.this);
                addNewPackage.setTitle("Add New Package");
                addNewPackage.setView(view);
                addNewPackage.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String OfferNameOfHotOffer,NumberofDataHotPackages,
                                NumberofOffNetMinsHotPackages,
                                NumberofZonsMinsHotPackages,PackagePriceHotOffers
                                ,OfferDailyOrWeeklyHotPackages;

                        OfferNameOfHotOffer=etOfferNameOfHotOffer.getText().toString().trim();
                        NumberofDataHotPackages=etNumberofDataHotPackages.getText().toString().trim();
                        NumberofOffNetMinsHotPackages=etNumberofOffNetMinsHotPackages.getText().toString().trim();
                        NumberofZonsMinsHotPackages=etNumberofZonsMinsHotPackages.getText().toString().trim();
                        PackagePriceHotOffers=etPackagePriceHotOffers.getText().toString().trim();
                        OfferDailyOrWeeklyHotPackages=etOfferDailyOrWeeklyHotPackages.getText().toString().trim();

                        HashMap<String, Object> object = new HashMap<>();
                        object.put("OfferNameOfHotOffer", OfferNameOfHotOffer);
                        object.put("NumberofDataHotPackages", NumberofDataHotPackages);
                        object.put("NumberofOffNetMinsHotPackages", NumberofOffNetMinsHotPackages);
                        object.put("NumberofZonsMinsHotPackages", NumberofZonsMinsHotPackages);
                        object.put("PackagePriceHotOffers", PackagePriceHotOffers);
                        object.put("OfferDailyOrWeeklyHotPackages", OfferDailyOrWeeklyHotPackages);



                        FirebaseDatabase.getInstance()
                                .getReference().child("SinglePackage").child("Packages")
                                .child("HotPackage")
                                .push().setValue(object)  // Use push().setValue() to avoid overwriting
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity.this, "Data Added Successfully", Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                });
                addNewPackage.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                addNewPackage.create().show();
            }
        });
    }
//   String OfferNameOfHotOffer,NumberofDataHotPackages,
//                        NumberofOffNetMinsHotPackages,
//                        NumberofZonsMinsHotPackages,PackagePriceHotOffers
//                        ,OfferDailyOrWeeklyHotPackages;
    private void setupImageSlider() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.ic_image_change, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_image_change2, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_image_change3, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_image_change5, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_image_change6, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_image_change7, "\n\n\n\n\n\n\n", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);
        hideProgressBar();
    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.Homes1) {
                    return true;
                } else if (itemId == R.id.Usages1) {
                    startActivity(new Intent(MainActivity.this, Usage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Bundles1) {
                    startActivity(new Intent(MainActivity.this, Bundles.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.ZPlays1) {
                    startActivity(new Intent(MainActivity.this, zPlay.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.Mores1) {
                    startActivity(new Intent(MainActivity.this, More.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.Homes1);
    }

    private void showProgressBar() {

        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    private void hideProgressBar() {

        progressBar.setVisibility(ProgressBar.GONE);
    }
    private void initViews() {

        icon_bell = findViewById(R.id.icon_bell);
        icon_search_bar = findViewById(R.id.icon_search_bar);
        icon_refresh = findViewById(R.id.icon_refresh);
        icon_menu_right = findViewById(R.id.icon_menu_right);
        ivMakeYourOwnBundle = findViewById(R.id.ivMakeYourOwnBundle);
        ivBachatBazar = findViewById(R.id.ivBachatBazar);
        ivRewards = findViewById(R.id.ivRewards);
        ivDarazHotDeals = findViewById(R.id.ivDarazHotDeals);
        ivBriefHistory = findViewById(R.id.ivBriefHistory);
        ivRs10Shop = findViewById(R.id.ivRs10Shop);
        ivGoogleMaps = findViewById(R.id.ivGoogleMaps);
        ivIR = findViewById(R.id.ivIR);
        ivTaxCertificate = findViewById(R.id.ivTaxCertificate);
        ivOnlineBooking = findViewById(R.id.ivOnlineBooking);
        ivSaveBalance = findViewById(R.id.ivSaveBalance);
        ivYaariLoad = findViewById(R.id.ivYaariLoad);
        ivCallBlocks = findViewById(R.id.ivCallBlocks);
        ivBookYourNumber = findViewById(R.id.ivBookYourNumber);
        ivMoreApps = findViewById(R.id.ivMoreApps);

        UserPhoneNumber = findViewById(R.id.UserPhoneNumber);
        tvCurrentBalance = findViewById(R.id.tvCurrentBalance);
        tvNumbersOfMBs = findViewById(R.id.tvNumbersOfMBs);
        tvNumbersOfMinutes = findViewById(R.id.tvNumbersOfMinutes);
        tvNumberOfSMS = findViewById(R.id.tvNumberOfSMS);
        tvOffersActiveInternet = findViewById(R.id.tvOffersActiveInternet);
        tvOffersActiveMins = findViewById(R.id.tvOffersActiveMins);
        tvOffersActiveSMS = findViewById(R.id.tvOffersActiveSMS);

        btnRechargeNow = findViewById(R.id.btnRechargeNow);
        btnPayLoan = findViewById(R.id.btnPayLoan);

        imageSlider = findViewById(R.id.image_slider);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        progressBar = findViewById(R.id.progressBar);
        ic_floatingActionBtn2 = findViewById(R.id.ic_floatingActionBtn2);
        recyclerViewOfHotOfferPackage = findViewById(R.id.recyclerViewOfHotOfferPackage);

        if (imageSlider == null || bottomNavigationView == null || progressBar == null || ic_floatingActionBtn2 == null || recyclerViewOfHotOfferPackage == null) {
            throw new NullPointerException("One or more views not found. Ensure your layout file has the correct IDs.");
        }

        recyclerViewOfHotOfferPackage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Query query = FirebaseDatabase.getInstance().getReference()
                .child("SinglePackage").child("Packages").child("HotPackage");
        FirebaseRecyclerOptions<HotPackageModelClass> option = new FirebaseRecyclerOptions.Builder<HotPackageModelClass>()
                .setQuery(query, HotPackageModelClass.class)
                .build();

        adapter = new hotPackageAdapter(option);
        recyclerViewOfHotOfferPackage.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
