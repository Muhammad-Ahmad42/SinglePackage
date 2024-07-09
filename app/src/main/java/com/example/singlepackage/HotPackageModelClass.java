package com.example.singlepackage;

public class HotPackageModelClass {
    String OfferNameOfHotOffer,NumberofDataHotPackages,
            NumberofOffNetMinsHotPackages,
            NumberofZonsMinsHotPackages,PackagePriceHotOffers
            ,OfferDailyOrWeeklyHotPackages;

    public HotPackageModelClass(){

    }

    public HotPackageModelClass(String offerNameOfHotOffer, String numberofDataHotPackages, String numberofOffNetMinsHotPackages, String numberofZonsMinsHotPackages, String packagePriceHotOffers, String offerDailyOrWeeklyHotPackages) {
        OfferNameOfHotOffer = offerNameOfHotOffer;
        NumberofDataHotPackages = numberofDataHotPackages;
        NumberofOffNetMinsHotPackages = numberofOffNetMinsHotPackages;
        NumberofZonsMinsHotPackages = numberofZonsMinsHotPackages;
        PackagePriceHotOffers = packagePriceHotOffers;
        OfferDailyOrWeeklyHotPackages = offerDailyOrWeeklyHotPackages;
    }

    public String getOfferNameOfHotOffer() {
        return OfferNameOfHotOffer;
    }

    public void setOfferNameOfHotOffer(String offerNameOfHotOffer) {
        OfferNameOfHotOffer = offerNameOfHotOffer;
    }

    public String getNumberofDataHotPackages() {
        return NumberofDataHotPackages;
    }

    public void setNumberofDataHotPackages(String numberofDataHotPackages) {
        NumberofDataHotPackages = numberofDataHotPackages;
    }

    public String getNumberofOffNetMinsHotPackages() {
        return NumberofOffNetMinsHotPackages;
    }

    public void setNumberofOffNetMinsHotPackages(String numberofOffNetMinsHotPackages) {
        NumberofOffNetMinsHotPackages = numberofOffNetMinsHotPackages;
    }

    public String getNumberofZonsMinsHotPackages() {
        return NumberofZonsMinsHotPackages;
    }

    public void setNumberofZonsMinsHotPackages(String numberofZonsMinsHotPackages) {
        NumberofZonsMinsHotPackages = numberofZonsMinsHotPackages;
    }

    public String getPackagePriceHotOffers() {
        return PackagePriceHotOffers;
    }

    public void setPackagePriceHotOffers(String packagePriceHotOffers) {
        PackagePriceHotOffers = packagePriceHotOffers;
    }

    public String getOfferDailyOrWeeklyHotPackages() {
        return OfferDailyOrWeeklyHotPackages;
    }

    public void setOfferDailyOrWeeklyHotPackages(String offerDailyOrWeeklyHotPackages) {
        OfferDailyOrWeeklyHotPackages = offerDailyOrWeeklyHotPackages;
    }
}
