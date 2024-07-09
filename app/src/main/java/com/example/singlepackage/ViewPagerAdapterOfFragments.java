package com.example.singlepackage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterOfFragments extends FragmentStateAdapter {

    private static final int NUM_PAGES = 10; // Number of fragments

    public ViewPagerAdapterOfFragments(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new Frag_Rs10Shop();
            case 1: return new Frag_TopOffers();
            case 2: return new Frag_AllInOne();
            case 3: return new Frag_Data();
            case 4: return new Frag_Voice();
            case 5: return new Frag_StayHome();
            case 6: return new Frag_Social();
            case 7: return new Frag_SMS();
            case 8: return new Frag_RegionalOffers();
            case 9: return new Frag_Favourites();
            default: return new Frag_Rs10Shop();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
