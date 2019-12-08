package com.codes.amr.showrooms.data.model;


import com.codes.amr.showrooms.di.module.ApplicationModule;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class Car implements Serializable {

    public static String EN = "ENGLISH";
    public static String AR = "ARABIC";
    public static String AVAILABLE = "1";
    @SerializedName("models_brand_id")
    private String BrandId;
    @SerializedName("models_information_ar")
    private String arabic_info;
    @SerializedName("models_testdrive_atshowroom")
    private String atShowroom;
    private String carName;
    @SerializedName("models_cashback_offer")
    private ArrayList<Offer> cashback_offers;
    @SerializedName("models_color")
    private String colors;
    @SerializedName("models_comingsoon_month")
    private String cs_month;
    @SerializedName("models_desc_ar")
    private String desc_ar;
    @SerializedName("models_desc_en")
    private String desc_en;
    @SerializedName("models_discount_offer")
    private ArrayList<Offer> discount_offers;
    @SerializedName("models_information_en")
    private String english_info;
    @SerializedName("models_exterior_image")
    private String exterior;
    private String fridayworkingHours;
    @SerializedName("models_gift_offer")
    private ArrayList<Offer> gift_offers;
    @SerializedName("models_id")
    private String id;
    private String info;
    @SerializedName("models_interior_image")
    private String interior;
    @SerializedName("models_interior_available")
    private String interior_av;
    private boolean interior_available;
    public Map<String, Object> specs;
    @SerializedName("models_spec_ar_updated")
    private Map<String, Object> specs_ar;
    @SerializedName("models_spec_en_updated")
    private Map<String, Object> specs_en;
    @SerializedName("models_testdrive_available")
    private String testDriveAvailable;
    @SerializedName("models_test_drive_price")
    private String testDrivePrice;
    private CarType type;
    @SerializedName("models_testdrive_bydelivery")
    private String withDelivery;
    private String workingHours;
    @SerializedName("models_year")
    private String yearModel;
    @SerializedName("models_image")
    private String models_image;
    @SerializedName("models_type")
    private String models_type;
    @SerializedName("models_name_ar")
    private String name_ar;
    @SerializedName("models_name_en")
    private String name_en;
    @SerializedName("models_offer")
    private ArrayList<Offer> offers;
    @SerializedName("models_price")
    private String price;
    @SerializedName("models_spec_ar")
    private String specAr;
    @SerializedName("models_spec_en")
    private String specEn;

    public Map<String, Object> getSpecs_en() {
        return this.specs_en;
    }

    public Map<String, Object> getSpecs_ar() {
        return this.specs_ar;
    }

    public Map<String, Object> getSpecs() {
        return Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(EN) ? this.specs_en : this.specs_ar;
    }


    public ArrayList<Offer> getCashback_offers() {
        return this.cashback_offers;
    }

    public ArrayList<Offer> getDiscount_offers() {
        return this.discount_offers;
    }

    public ArrayList<Offer> getGift_offers() {
        return this.gift_offers;
    }

    public String getInterior_av() {
        return this.interior_av;
    }

    public boolean isInterior_available() {
        return this.interior_av.equals(AVAILABLE);
    }

    public String getEnglish_info() {
        return this.english_info;
    }

    public void setEnglish_info(String english_info2) {
        this.english_info = english_info2;
    }

    public String getArabic_info() {
        return this.arabic_info;
    }

    public void setArabic_info(String arabic_info2) {
        this.arabic_info = arabic_info2;
    }

    public String getInfo() {
        return Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(EN) ? this.english_info : this.arabic_info;
    }

    public void setInfo(String info2) {
        this.info = Locale.getDefault().getDisplayLanguage().equals(EN) ? this.english_info : this.arabic_info;
    }

    public ArrayList<Offer> getOffers() {
        return this.offers;
    }

    public String getFridayworkingHours() {
        return this.fridayworkingHours;
    }

    public void setFridayworkingHours(String fridayworkingHours2) {
        this.fridayworkingHours = fridayworkingHours2;
    }

    public String getModels_type() {
        return this.models_type;
    }

    public void setModels_type(String models_type2) {
        this.models_type = models_type2;
    }

    public CarType getType() {
        return CarType.valueOf(getModels_type());
    }

    public void setType(CarType type2) {
        this.type = type2;
    }

    public String getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(String workingHours2) {
        this.workingHours = workingHours2;
    }

    public boolean isAtShowroom() {
        return getAtShowroom().equals(AVAILABLE);
    }

    public boolean isWithDelivery() {
        return getWithDelivery().equals(AVAILABLE);
    }

    public String getWithDelivery() {
        return this.withDelivery;
    }

    public void setWithDelivery(String withDelivery2) {
        this.withDelivery = withDelivery2;
    }

    public String getAtShowroom() {
        return this.atShowroom;
    }

    public void setAtShowroom(String atShowroom2) {
        this.atShowroom = atShowroom2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandId() {
        return this.BrandId;
    }

    public void setBrandId(String brandId) {
        this.BrandId = brandId;
    }

    public String getName_en() {
        return this.name_en;
    }

    public void setName_en(String name_en2) {
        this.name_en = name_en2;
    }

    public String getName_ar() {
        return this.name_ar;
    }

    public void setName_ar(String name_ar2) {
        this.name_ar = name_ar2;
    }

    public String getCarName() {
        this.carName = Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(EN) ? getName_en() : getName_ar();
        return this.carName;
    }

    public String getModels_image() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationModule.BASE_URL);
        sb.append(ApplicationModule.BASE_Service);
        sb.append(this.models_image);
        return sb.toString();
    }

    public void setModels_image(String models_image2) {
        this.models_image = models_image2;
    }

    public String getDesc_en() {
        return this.desc_en;
    }

    public void setDesc_en(String desc_en2) {
        this.desc_en = desc_en2;
    }

    public String getDesc_ar() {
        return this.desc_ar;
    }

    public void setDesc_ar(String desc_ar2) {
        this.desc_ar = desc_ar2;
    }

    public String getYearModel() {
        return this.yearModel;
    }

    public void setYearModel(String yearModel2) {
        this.yearModel = yearModel2;
    }

    public String getColors() {
        return this.colors;
    }

    public void setColors(String colors2) {
        this.colors = colors2;
    }

    public String getTestDriveAvailable() {
        return this.testDriveAvailable;
    }

    public void setTestDriveAvailable(String testDriveAvailable2) {
        this.testDriveAvailable = testDriveAvailable2;
    }

    public String getTestDrivePrice() {
        return this.testDrivePrice;
    }

    public void setTestDrivePrice(String testDrivePrice2) {
        this.testDrivePrice = testDrivePrice2;
    }

    public String getExterior() {
        return this.exterior;
    }

    public void setExterior(String exterior2) {
        this.exterior = exterior2;
    }

    public String getInterior() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationModule.BASE_URL);
        sb.append(this.interior);
        return sb.toString();
    }

    public void setInterior(String interior2) {
        this.interior = interior2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }

    public String getSpecEn() {
        return this.specEn;
    }

    public void setSpecEn(String specEn2) {
        this.specEn = specEn2;
    }

    public String getSpecAr() {
        return this.specAr;
    }

    public void setSpecAr(String specAr2) {
        this.specAr = specAr2;
    }

    public String getSpec() {
        return Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(EN) ? getSpecEn() : getSpecAr();
    }
}
