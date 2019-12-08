package com.codes.amr.showrooms.data.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;

public class Offer  implements Serializable {
    @SerializedName("brand_id")
    private String BrandId;
    @SerializedName("model_id")
    private String carId;
    @SerializedName("dealer_cashback_amount")
    private String dealer_cashback;
    @SerializedName("dealer_discount_amount")
    private String dealer_discount;
    @SerializedName("end_date")
    private String end_date;
    private String gift_offer;
    @SerializedName("dealer_gift_offer_ar")
    private String gift_offer_ar;
    @SerializedName("dealer_gift_offer_en")
    private String gift_offer_en;
    @SerializedName("id")

    private String id;
    @SerializedName("offer_description_ar")
    private String offer_description_ar;
    @SerializedName("offer_description_en")
    private String offer_description_en;
    @SerializedName("offer_type")
    private String offer_type;
    @SerializedName("start_date")
    private String start_date;
    @SerializedName("unlimited")
    private String unlimited;
    @SerializedName("until_stock")
    private String until_stock;

    public String getDealer_cashback() {
        return this.dealer_cashback;
    }

    public void setDealer_cashback(String dealer_cashback2) {
        this.dealer_cashback = dealer_cashback2;
    }

    public String getDealer_discount() {
        return this.dealer_discount;
    }

    public void setDealer_discount(String dealer_discount2) {
        this.dealer_discount = dealer_discount2;
    }

    public String getGift_offer_en() {
        return this.gift_offer_en;
    }

    public void setGift_offer_en(String gift_offer_en2) {
        this.gift_offer_en = gift_offer_en2;
    }

    public String getGift_offer_ar() {
        return this.gift_offer_ar;
    }

    public void setGift_offer_ar(String gift_offer_ar2) {
        this.gift_offer_ar = gift_offer_ar2;
    }

    public String[] getGift_offer() {
        this.gift_offer = Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(Car.EN) ? this.gift_offer_en : this.gift_offer_ar;
        try {
            JSONArray jsonArray = new JSONArray(this.gift_offer);
            String[] giftArray = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                giftArray[i] = jsonArray.getString(i);
            }
            return giftArray;
        } catch (JSONException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public void setGift_offer(String gift_offer2) {
        this.gift_offer = gift_offer2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return this.carId;
    }

    public void setCarId(String carId2) {
        this.carId = carId2;
    }

    public String getBrandId() {
        return this.BrandId;
    }

    public void setBrandId(String brandId) {
        this.BrandId = brandId;
    }

    public String getOffer_type() {
        return this.offer_type;
    }

    public void setOffer_type(String offer_type2) {
        this.offer_type = offer_type2;
    }

    public String getDesc() {
        return Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(Car.EN) ? this.offer_description_en : this.offer_description_ar;
    }

    public boolean isUnlimited() {
        String str = this.unlimited;
        String str2 = Car.AVAILABLE;
        return str.equals(str2) || this.until_stock.equals(str2);
    }

    public boolean isExpired() {
        boolean z = true;
        try {
            if (new SimpleDateFormat("yyyy-MM-dd").parse(this.end_date).getTime() >= new Date().getTime()) {
                z = false;
            }
            return z;
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }
}
