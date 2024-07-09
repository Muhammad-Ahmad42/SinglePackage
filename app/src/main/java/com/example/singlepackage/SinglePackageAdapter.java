package com.example.singlepackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SinglePackageAdapter extends FirebaseRecyclerAdapter<ModelClassOfSinglePackage, SinglePackageAdapter.singlePackageViewHolder> {

    public SinglePackageAdapter(@NonNull FirebaseRecyclerOptions<ModelClassOfSinglePackage> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull singlePackageViewHolder holder, int position, @NonNull ModelClassOfSinglePackage model) {
        holder.popularity_text.setText(model.getPopularity_text());
        holder.tvOfferDailyOrWeekly.setText(model.getOfferDailyOrWeekly());
        holder.tvOfferTimeName.setText(model.getOfferName());
        holder.tvPackageUseFulFor.setText(model.getPackageUseFulFor());
        holder.tvPackageDataType.setText(model.getPackageDataType());
        holder.tvPackageDataInNumbers.setText(model.getPackageDataInNumbers());
        holder.tvPackagePrice.setText(model.getPackagePrice());
    }

    @NonNull
    @Override
    public singlePackageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_design_package, parent, false);
        return new singlePackageViewHolder(view);
    }

    public class singlePackageViewHolder extends RecyclerView.ViewHolder {
        TextView popularity_text, tvOfferDailyOrWeekly, tvOfferTimeName,
                tvPackagePrice, tvPackageDataInNumbers,
                tvPackageUseFulFor, tvPackageDataType;

        public singlePackageViewHolder(@NonNull View itemView) {
            super(itemView);
            popularity_text = itemView.findViewById(R.id.popularity_text);
            tvOfferDailyOrWeekly = itemView.findViewById(R.id.tvOfferDailyOrWeekly);
            tvOfferTimeName = itemView.findViewById(R.id.tvOfferTimeName);
            tvPackagePrice = itemView.findViewById(R.id.tvPackagePrice);
            tvPackageDataInNumbers = itemView.findViewById(R.id.tvPackageDataInNumbers);
            tvPackageUseFulFor = itemView.findViewById(R.id.tvPackageUseFulFor);
            tvPackageDataType = itemView.findViewById(R.id.tvPackageDataType);
        }
    }
}
