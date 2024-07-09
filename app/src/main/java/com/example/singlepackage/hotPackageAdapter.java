package com.example.singlepackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class hotPackageAdapter extends FirebaseRecyclerAdapter<HotPackageModelClass,hotPackageAdapter.hotPackageViewHolder> {


    public hotPackageAdapter(@NonNull FirebaseRecyclerOptions<HotPackageModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull hotPackageViewHolder holder, int position, @NonNull HotPackageModelClass model) {
        holder.OfferNameOfHotOffer.setText(model.getOfferNameOfHotOffer());
        holder.NumberofDataHotPackages.setText(model.getNumberofDataHotPackages());
        holder.NumberofOffNetMinsHotPackages.setText(model.getNumberofOffNetMinsHotPackages());
        holder.NumberofZonsMinsHotPackages.setText(model.getNumberofZonsMinsHotPackages());
        holder.PackagePriceHotOffers.setText(model.getPackagePriceHotOffers());
        holder.OfferDailyOrWeeklyHotPackages.setText(model.getOfferDailyOrWeeklyHotPackages());

    }

    @NonNull
    @Override
    public hotPackageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_design_hot_offer,parent,false);
        return new hotPackageViewHolder(view);

    }

    public class hotPackageViewHolder extends RecyclerView.ViewHolder{
        TextView OfferNameOfHotOffer,NumberofDataHotPackages,
                NumberofOffNetMinsHotPackages,
                NumberofZonsMinsHotPackages,PackagePriceHotOffers
                ,OfferDailyOrWeeklyHotPackages;
        public hotPackageViewHolder(@NonNull View itemView) {
            super(itemView);
                    OfferNameOfHotOffer=itemView.findViewById(R.id.tvOfferNameOfHotOffer);
                    NumberofDataHotPackages=itemView.findViewById(R.id.tvNumberofDataHotPackages);
                    NumberofOffNetMinsHotPackages=itemView.findViewById(R.id.tvNumberofOffNetMinsHotPackages);
                    NumberofZonsMinsHotPackages=itemView.findViewById(R.id.tvNumberofZonsMinsHotPackages) ;
                    PackagePriceHotOffers=itemView.findViewById(R.id.tvPackagePriceHotOffers);
                    OfferDailyOrWeeklyHotPackages=itemView.findViewById(R.id.tvOfferDailyOrWeeklyHotPackages);
        }
    }
}
