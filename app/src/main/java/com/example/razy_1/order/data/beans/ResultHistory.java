package com.example.razy_1.order.data.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultHistory {

    @SerializedName("__metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("SupllierName")
    @Expose
    private String supllierName;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("UnitPrice")
    @Expose
    private String unitPrice;
    @SerializedName("TotalPrice")
    @Expose
    private String totalPrice;
    @SerializedName("RequestDate")
    @Expose
    private Object requestDate;
    @SerializedName("Barcode")
    @Expose
    private String barcode;
    @SerializedName("ProductId")
    @Expose
    private Integer productId;
    @SerializedName("ProductImage")
    @Expose
    private String productImage;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getSupllierName() {
        return supllierName;
    }

    public void setSupllierName(String supllierName) {
        this.supllierName = supllierName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Object getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Object requestDate) {
        this.requestDate = requestDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}