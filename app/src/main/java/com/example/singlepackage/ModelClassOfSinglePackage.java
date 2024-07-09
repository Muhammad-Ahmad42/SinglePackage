package com.example.singlepackage;

public class ModelClassOfSinglePackage {
    String popularity_text, OfferDailyOrWeekly,
            OfferName, PackageUseFulFor, PackageDataType;
    String PackagePrice, PackageDataInNumbers;

    public ModelClassOfSinglePackage(){}

    public ModelClassOfSinglePackage(String popularity_text, String OfferDailyOrWeekly, String OfferName,
                                     String PackageUseFulFor, String PackageDataType, String PackagePrice,
                                     String PackageDataInNumbers) {
        this.popularity_text = popularity_text;
        this.OfferDailyOrWeekly = OfferDailyOrWeekly;
        this.OfferName = OfferName;
        this.PackageUseFulFor = PackageUseFulFor;
        this.PackageDataType = PackageDataType;
        this.PackagePrice = PackagePrice;
        this.PackageDataInNumbers = PackageDataInNumbers;
    }

    public String getPopularity_text() {
        return popularity_text;
    }

    public void setPopularity_text(String popularity_text) {
        this.popularity_text = popularity_text;
    }

    public String getOfferDailyOrWeekly() {
        return OfferDailyOrWeekly;
    }

    public void setOfferDailyOrWeekly(String offerDailyOrWeekly) {
        OfferDailyOrWeekly = offerDailyOrWeekly;
    }

    public String getOfferName() {
        return OfferName;
    }

    public void setOfferName(String offerName) {
        OfferName = offerName;
    }

    public String getPackageUseFulFor() {
        return PackageUseFulFor;
    }

    public void setPackageUseFulFor(String packageUseFulFor) {
        PackageUseFulFor = packageUseFulFor;
    }

    public String getPackageDataType() {
        return PackageDataType;
    }

    public void setPackageDataType(String packageDataType) {
        PackageDataType = packageDataType;
    }

    public String getPackagePrice() {
        return PackagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        PackagePrice = packagePrice;
    }

    public String getPackageDataInNumbers() {
        return PackageDataInNumbers;
    }

    public void setPackageDataInNumbers(String packageDataInNumbers) {
        PackageDataInNumbers = packageDataInNumbers;
    }
}
