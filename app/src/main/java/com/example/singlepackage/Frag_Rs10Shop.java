package com.example.singlepackage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class Frag_Rs10Shop extends Fragment {

    private FloatingActionButton fabAddNewSinglePackage;
    private RecyclerView recyclerViewOfSinglePackage;
    private SinglePackageAdapter adapter;
    private EditText etPopularity_text, etOfferDailyOrWeekly, etOfferName,
            etPackagePrice, etPackageDataInNumbers,
            etPackageUseFulFor, etPackageDataType;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        Toast.makeText(getContext(), "yes", Toast.LENGTH_SHORT).show();

        fabAddNewSinglePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(getContext()).inflate(R.layout.get_package_details_to_putinto_firebase, null);

                etPopularity_text = v.findViewById(R.id.etPopularity_text);
                etOfferDailyOrWeekly = v.findViewById(R.id.etOfferDailyOrWeekly);
                etOfferName = v.findViewById(R.id.etOfferName);
                etPackagePrice = v.findViewById(R.id.etPackagePrice);
                etPackageDataInNumbers = v.findViewById(R.id.etPackageDataInNumbers);
                etPackageUseFulFor = v.findViewById(R.id.etPackageUseFulFor);
                etPackageDataType = v.findViewById(R.id.etPackageDataType);

                AlertDialog.Builder addNewPackage = new AlertDialog.Builder(getContext());
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
                                .push().setValue(object)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getContext(), "Data Added Successfully", Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag__rs10_shop, container, false);
        return view;
    }

    private void init(View view) {
        fabAddNewSinglePackage = view.findViewById(R.id.fabAddNewSinglePackage);
        recyclerViewOfSinglePackage = view.findViewById(R.id.recyclerViewOfSinglePackage);
        recyclerViewOfSinglePackage.setLayoutManager(new LinearLayoutManager(getContext()));

        Query query = FirebaseDatabase.getInstance()
                .getReference().child("Zong").child("Packages")
                .child("SinglePackage");

        FirebaseRecyclerOptions<ModelClassOfSinglePackage> options = new
                FirebaseRecyclerOptions.Builder<ModelClassOfSinglePackage>()
                .setQuery(query, ModelClassOfSinglePackage.class)
                .build();

        adapter = new SinglePackageAdapter(options);
        recyclerViewOfSinglePackage.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewOfSinglePackage.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
