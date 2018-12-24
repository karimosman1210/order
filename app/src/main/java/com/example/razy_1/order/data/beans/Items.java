package com.example.razy_1.order.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable {
    public String id;
    String name;
    int img;
    String barcode;
    String price;
    String companyName;
    String totalPrice;
    String date;

    protected Items(Parcel in) {
        id = in.readString();
        name = in.readString();
        img = in.readInt();
        barcode = in.readString();
        price = in.readString();
        companyName = in.readString();
        totalPrice = in.readString();
        date = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Items(String id, String name, int img, String barcode, String price, String companyName) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.barcode = barcode;
        this.price = price;
        this.companyName = companyName;
    }

    public String getBarcode() {
        return barcode;
    }

    public Items(String id, String name, int img, String barcode) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.barcode = barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Items(String id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeInt(img);
        parcel.writeString(barcode);
        parcel.writeString(price);
        parcel.writeString(companyName);
        parcel.writeString(totalPrice);
        parcel.writeString(date);
    }
}
