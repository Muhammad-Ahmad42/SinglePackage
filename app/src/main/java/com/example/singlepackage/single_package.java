package com.example.singlepackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class single_package extends AppCompatActivity {

    FloatingActionButton fabAddNewSinglePackage;
    RecyclerView recyclerViewOfSinglePackage;

    SinglePackageAdapter adapter;
    EditText etPopularity_text, etOfferDailyOrWeekly, etOfferName,
            etPackagePrice, etPackageDataInNumbers,
            etPackageUseFulFor, etPackageDataType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.single_package);
        init();

//        FirebaseDatabase.getInstance().getReference()
//                .child("Packages").child("SinglePackage")
//                        .addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                String popularity_text, OfferDailyOrWeekly,
//                                        OfferName, PackageUseFulFor, PackageDataType,
//                                PackagePrice, PackageDataInNumbers;
//                                for (DataSnapshot sShot:snapshot.getChildren()){
//                                    popularity_text=sShot.child("popularity_text").getValue(String.class);
//                                    OfferDailyOrWeekly=sShot.child("OfferDailyOrWeekly").getValue(String.class);
//                                    OfferName=sShot.child("OfferName").getValue(String.class);
//                                    PackageUseFulFor=sShot.child("PackageUseFulFor").getValue(String.class);
//                                    PackageDataType=sShot.child("PackageDataType").getValue(String.class);
//                                    PackagePrice=sShot.child("PackagePrice").getValue(String.class);
//                                    PackageDataInNumbers=sShot.child("PackageDataInNumbers").getValue(String.class);
//
//                                }
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });

        fabAddNewSinglePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(single_package.this)
                        .inflate(R.layout.get_package_details_to_putinto_firebase, null);

                etPopularity_text = v.findViewById(R.id.etPopularity_text);
                etOfferDailyOrWeekly = v.findViewById(R.id.etOfferDailyOrWeekly);
                etOfferName = v.findViewById(R.id.etOfferName);
                etPackagePrice = v.findViewById(R.id.etPackagePrice);
                etPackageDataInNumbers = v.findViewById(R.id.etPackageDataInNumbers);
                etPackageUseFulFor = v.findViewById(R.id.etPackageUseFulFor);
                etPackageDataType = v.findViewById(R.id.etPackageDataType);

                AlertDialog.Builder addNewPackage = new AlertDialog.Builder(single_package.this);
                addNewPackage.setTitle("Add New Package");
                addNewPackage.setView(v);
                addNewPackage.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String popularityText = etPopularity_text.getText().toString().trim();
                        String offerDailyOrWeekly = etOfferDailyOrWeekly.getText().toString().trim();
                        String offerName = etOfferName.getText().toString().trim();
                        String packagePrice = etPackagePrice.getText().toString();
                        String packageDataInNumbers = etPackageDataInNumbers.getText().toString();
                        String packageUseFulFor = etPackageUseFulFor.getText().toString().trim();
                        String packageDataType = etPackageDataType.getText().toString().trim();

                        HashMap<String, Object> object = new HashMap<>();
                        object.put("popularity_text", popularityText);
                        object.put("OfferDailyOrWeekly", offerDailyOrWeekly);
                        object.put("OfferName", offerName);
                        object.put("PackageUseFulFor", packageUseFulFor);
                        object.put("PackageDataType", packageDataType);
                        object.put("PackagePrice", packagePrice);
                        object.put("PackageDataInNumbers", packageDataInNumbers);

                        FirebaseDatabase.getInstance()
                                .getReference().child("Zong").child("Packages")
                                .child("SinglePackage")
                                .push().setValue(object)  // Use push().setValue() to avoid overwriting
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(single_package.this, "Data Added Successfully", Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(single_package.this, e.getMessage(), Toast.LENGTH_LONG).show();
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

    private void init() {
        fabAddNewSinglePackage = findViewById(R.id.fabAddNewSinglePackage);
        recyclerViewOfSinglePackage = findViewById(R.id.recyclerViewOfSinglePackage);
        recyclerViewOfSinglePackage.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference().child("Packages").child("SinglePackage");

        FirebaseRecyclerOptions<ModelClassOfSinglePackage> options = new
                FirebaseRecyclerOptions.Builder<ModelClassOfSinglePackage>()
                .setQuery(query, ModelClassOfSinglePackage.class)
                .build();

        adapter = new SinglePackageAdapter(options);

        recyclerViewOfSinglePackage.setAdapter(adapter);
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