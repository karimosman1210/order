package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("__metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("Mandt")
    @Expose
    private String mandt;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("PictureId")
    @Expose
    private Integer pictureId;
    @SerializedName("BillingAddressId")
    @Expose
    private Integer billingAddressId;
    @SerializedName("ShippingAddressId")
    @Expose
    private Integer shippingAddressId;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getMandt() {
        return mandt;
    }

    public void setMandt(String mandt) {
        this.mandt = mandt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }
}
