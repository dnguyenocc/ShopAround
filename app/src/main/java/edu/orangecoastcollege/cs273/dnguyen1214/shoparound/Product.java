package edu.orangecoastcollege.cs273.dnguyen1214.shoparound;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyng on 1/13/2017.
 */

public class Product implements Parcelable{
    String sku;
    String name;
    String seller;
    float currentPrice;
    float originalPrice;
    HashMap<String,Float> prices;
    URL productUrl;


    public Product(String sku, String name, String seller, float currentPrice,
                   float originalPrice, HashMap<String,Float> prices, URL productUrl)
    {
        this.sku = sku;
        this.name = name;
        this.seller = seller;
        this.currentPrice = currentPrice;
        this.originalPrice = originalPrice;
        this.prices = prices;
        this.productUrl = productUrl;
    }


    protected Product(Parcel in) {
        sku = in.readString();
        name = in.readString();
        seller = in.readString();
        currentPrice = in.readFloat();
        originalPrice = in.readFloat();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getSku() { return sku;}
    public String getName() { return name;}
    public String getSeller() { return seller;}
    public float getCurrentPrice() {return  currentPrice;}
    public float getOriginalPrice() {return  originalPrice;}
    public HashMap<String,Float> getPrices(){return prices;}
    public URL getProductUrl() {return productUrl;}

    public void setPrices(HashMap<String,Float> newPrices){prices = newPrices;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(sku);
        parcel.writeString(name);
        parcel.writeString(seller);
        parcel.writeFloat(currentPrice);
        parcel.writeFloat(originalPrice);
        parcel.writeValue(productUrl);
    }
}
