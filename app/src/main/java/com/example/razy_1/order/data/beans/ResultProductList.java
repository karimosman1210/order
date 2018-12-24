package com.example.razy_1.order.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultProductList implements Parcelable{

        @SerializedName("__metadata")
        @Expose
        private Metadata metadata;
        @SerializedName("CategoryId")
        @Expose
        private Integer categoryId;
        @SerializedName("ProductId")
        @Expose
        private Integer productId;
        @SerializedName("ProductTypeId")
        @Expose
        private Integer productTypeId;
        @SerializedName("ParentGroupedProductid")
        @Expose
        private Integer parentGroupedProductid;
        @SerializedName("VisibleIndividually")
        @Expose
        private String visibleIndividually;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("ShortDescription")
        @Expose
        private String shortDescription;
        @SerializedName("FullDescription")
        @Expose
        private String fullDescription;
        @SerializedName("PictureId")
        @Expose
        private Integer pictureId;
        @SerializedName("ShowOnHomepage")
        @Expose
        private String showOnHomepage;
        @SerializedName("MetaKeywords")
        @Expose
        private String metaKeywords;
        @SerializedName("MetaDescription")
        @Expose
        private String metaDescription;
        @SerializedName("MetaTitle")
        @Expose
        private String metaTitle;
        @SerializedName("AllowCustomerReviews")
        @Expose
        private String allowCustomerReviews;
        @SerializedName("LimitedToStores")
        @Expose
        private String limitedToStores;
        @SerializedName("Sku")
        @Expose
        private String sku;
        @SerializedName("RequireOtherProducts")
        @Expose
        private String requireOtherProducts;
        @SerializedName("RequireDproductIds")
        @Expose
        private String requireDproductIds;
        @SerializedName("Automaticallyaddrequiredproduc")
        @Expose
        private String automaticallyaddrequiredproduc;
        @SerializedName("IsShipEnabled")
        @Expose
        private String isShipEnabled;
        @SerializedName("IsFreeShipping")
        @Expose
        private String isFreeShipping;
        @SerializedName("ShipSeparately")
        @Expose
        private String shipSeparately;
        @SerializedName("AdditionalShippingCharge")
        @Expose
        private String additionalShippingCharge;
        @SerializedName("DeliveryDateId")
        @Expose
        private Integer deliveryDateId;
        @SerializedName("IsTaxExempt")
        @Expose
        private String isTaxExempt;
        @SerializedName("TaxCategoryId")
        @Expose
        private Integer taxCategoryId;
        @SerializedName("StockQuantity")
        @Expose
        private Integer stockQuantity;
        @SerializedName("DisplayStockAvailability")
        @Expose
        private String displayStockAvailability;
        @SerializedName("DisplayStockQuantity")
        @Expose
        private String displayStockQuantity;
        @SerializedName("MinStockQuantity")
        @Expose
        private Integer minStockQuantity;
        @SerializedName("LowStockActivityId")
        @Expose
        private Integer lowStockActivityId;
        @SerializedName("NotifyAdminForQuantitybelow")
        @Expose
        private Integer notifyAdminForQuantitybelow;
        @SerializedName("BackOrderModeid")
        @Expose
        private Integer backOrderModeid;
        @SerializedName("AllowBackinstocksubscriptions")
        @Expose
        private String allowBackinstocksubscriptions;
        @SerializedName("OrderMinimumQuantity")
        @Expose
        private Integer orderMinimumQuantity;
        @SerializedName("OrderMaximumQuantity")
        @Expose
        private Integer orderMaximumQuantity;
        @SerializedName("Price")
        @Expose
        private String price;
        @SerializedName("OldPrice")
        @Expose
        private String oldPrice;
        @SerializedName("MaximumCustomerEnteredprice")
        @Expose
        private String maximumCustomerEnteredprice;
        @SerializedName("MarkAsnew")
        @Expose
        private String markAsnew;
        @SerializedName("MarkAsnewStartdatetimeutc")
        @Expose
        private String markAsnewStartdatetimeutc;
        @SerializedName("MarkAsnewEnddatetimeutc")
        @Expose
        private String markAsnewEnddatetimeutc;
        @SerializedName("HasDiscountsApplied")
        @Expose
        private String hasDiscountsApplied;
        @SerializedName("Weight")
        @Expose
        private String weight;
        @SerializedName("Length")
        @Expose
        private String length;
        @SerializedName("Width")
        @Expose
        private String width;
        @SerializedName("Height")
        @Expose
        private String height;
        @SerializedName("AvailableStartdateTimeutc")
        @Expose
        private String availableStartdateTimeutc;
        @SerializedName("AvailableEnddateTimeutc")
        @Expose
        private String availableEnddateTimeutc;
        @SerializedName("DisplayOrder")
        @Expose
        private Integer displayOrder;
        @SerializedName("Published")
        @Expose
        private String published;
        @SerializedName("Deleted")
        @Expose
        private String deleted;
        @SerializedName("CreatedOnUtc")
        @Expose
        private String createdOnUtc;
        @SerializedName("UpdatedOnUtc")
        @Expose
        private String updatedOnUtc;

    protected ResultProductList(Parcel in) {
        if (in.readByte() == 0) {
            categoryId = null;
        } else {
            categoryId = in.readInt();
        }
        if (in.readByte() == 0) {
            productId = null;
        } else {
            productId = in.readInt();
        }
        if (in.readByte() == 0) {
            productTypeId = null;
        } else {
            productTypeId = in.readInt();
        }
        if (in.readByte() == 0) {
            parentGroupedProductid = null;
        } else {
            parentGroupedProductid = in.readInt();
        }
        visibleIndividually = in.readString();
        name = in.readString();
        shortDescription = in.readString();
        fullDescription = in.readString();
        if (in.readByte() == 0) {
            pictureId = null;
        } else {
            pictureId = in.readInt();
        }
        showOnHomepage = in.readString();
        metaKeywords = in.readString();
        metaDescription = in.readString();
        metaTitle = in.readString();
        allowCustomerReviews = in.readString();
        limitedToStores = in.readString();
        sku = in.readString();
        requireOtherProducts = in.readString();
        requireDproductIds = in.readString();
        automaticallyaddrequiredproduc = in.readString();
        isShipEnabled = in.readString();
        isFreeShipping = in.readString();
        shipSeparately = in.readString();
        additionalShippingCharge = in.readString();
        if (in.readByte() == 0) {
            deliveryDateId = null;
        } else {
            deliveryDateId = in.readInt();
        }
        isTaxExempt = in.readString();
        if (in.readByte() == 0) {
            taxCategoryId = null;
        } else {
            taxCategoryId = in.readInt();
        }
        if (in.readByte() == 0) {
            stockQuantity = null;
        } else {
            stockQuantity = in.readInt();
        }
        displayStockAvailability = in.readString();
        displayStockQuantity = in.readString();
        if (in.readByte() == 0) {
            minStockQuantity = null;
        } else {
            minStockQuantity = in.readInt();
        }
        if (in.readByte() == 0) {
            lowStockActivityId = null;
        } else {
            lowStockActivityId = in.readInt();
        }
        if (in.readByte() == 0) {
            notifyAdminForQuantitybelow = null;
        } else {
            notifyAdminForQuantitybelow = in.readInt();
        }
        if (in.readByte() == 0) {
            backOrderModeid = null;
        } else {
            backOrderModeid = in.readInt();
        }
        allowBackinstocksubscriptions = in.readString();
        if (in.readByte() == 0) {
            orderMinimumQuantity = null;
        } else {
            orderMinimumQuantity = in.readInt();
        }
        if (in.readByte() == 0) {
            orderMaximumQuantity = null;
        } else {
            orderMaximumQuantity = in.readInt();
        }
        price = in.readString();
        oldPrice = in.readString();
        maximumCustomerEnteredprice = in.readString();
        markAsnew = in.readString();
        markAsnewStartdatetimeutc = in.readString();
        markAsnewEnddatetimeutc = in.readString();
        hasDiscountsApplied = in.readString();
        weight = in.readString();
        length = in.readString();
        width = in.readString();
        height = in.readString();
        availableStartdateTimeutc = in.readString();
        availableEnddateTimeutc = in.readString();
        if (in.readByte() == 0) {
            displayOrder = null;
        } else {
            displayOrder = in.readInt();
        }
        published = in.readString();
        deleted = in.readString();
        createdOnUtc = in.readString();
        updatedOnUtc = in.readString();
    }

    public static final Creator<ResultProductList> CREATOR = new Creator<ResultProductList>() {
        @Override
        public ResultProductList createFromParcel(Parcel in) {
            return new ResultProductList(in);
        }

        @Override
        public ResultProductList[] newArray(int size) {
            return new ResultProductList[size];
        }
    };

    public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getProductTypeId() {
            return productTypeId;
        }

        public void setProductTypeId(Integer productTypeId) {
            this.productTypeId = productTypeId;
        }

        public Integer getParentGroupedProductid() {
            return parentGroupedProductid;
        }

        public void setParentGroupedProductid(Integer parentGroupedProductid) {
            this.parentGroupedProductid = parentGroupedProductid;
        }

        public String getVisibleIndividually() {
            return visibleIndividually;
        }

        public void setVisibleIndividually(String visibleIndividually) {
            this.visibleIndividually = visibleIndividually;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public String getFullDescription() {
            return fullDescription;
        }

        public void setFullDescription(String fullDescription) {
            this.fullDescription = fullDescription;
        }

        public Integer getPictureId() {
            return pictureId;
        }

        public void setPictureId(Integer pictureId) {
            this.pictureId = pictureId;
        }

        public String getShowOnHomepage() {
            return showOnHomepage;
        }

        public void setShowOnHomepage(String showOnHomepage) {
            this.showOnHomepage = showOnHomepage;
        }

        public String getMetaKeywords() {
            return metaKeywords;
        }

        public void setMetaKeywords(String metaKeywords) {
            this.metaKeywords = metaKeywords;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getAllowCustomerReviews() {
            return allowCustomerReviews;
        }

        public void setAllowCustomerReviews(String allowCustomerReviews) {
            this.allowCustomerReviews = allowCustomerReviews;
        }

        public String getLimitedToStores() {
            return limitedToStores;
        }

        public void setLimitedToStores(String limitedToStores) {
            this.limitedToStores = limitedToStores;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getRequireOtherProducts() {
            return requireOtherProducts;
        }

        public void setRequireOtherProducts(String requireOtherProducts) {
            this.requireOtherProducts = requireOtherProducts;
        }

        public String getRequireDproductIds() {
            return requireDproductIds;
        }

        public void setRequireDproductIds(String requireDproductIds) {
            this.requireDproductIds = requireDproductIds;
        }

        public String getAutomaticallyaddrequiredproduc() {
            return automaticallyaddrequiredproduc;
        }

        public void setAutomaticallyaddrequiredproduc(String automaticallyaddrequiredproduc) {
            this.automaticallyaddrequiredproduc = automaticallyaddrequiredproduc;
        }

        public String getIsShipEnabled() {
            return isShipEnabled;
        }

        public void setIsShipEnabled(String isShipEnabled) {
            this.isShipEnabled = isShipEnabled;
        }

        public String getIsFreeShipping() {
            return isFreeShipping;
        }

        public void setIsFreeShipping(String isFreeShipping) {
            this.isFreeShipping = isFreeShipping;
        }

        public String getShipSeparately() {
            return shipSeparately;
        }

        public void setShipSeparately(String shipSeparately) {
            this.shipSeparately = shipSeparately;
        }

        public String getAdditionalShippingCharge() {
            return additionalShippingCharge;
        }

        public void setAdditionalShippingCharge(String additionalShippingCharge) {
            this.additionalShippingCharge = additionalShippingCharge;
        }

        public Integer getDeliveryDateId() {
            return deliveryDateId;
        }

        public void setDeliveryDateId(Integer deliveryDateId) {
            this.deliveryDateId = deliveryDateId;
        }

        public String getIsTaxExempt() {
            return isTaxExempt;
        }

        public void setIsTaxExempt(String isTaxExempt) {
            this.isTaxExempt = isTaxExempt;
        }

        public Integer getTaxCategoryId() {
            return taxCategoryId;
        }

        public void setTaxCategoryId(Integer taxCategoryId) {
            this.taxCategoryId = taxCategoryId;
        }

        public Integer getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public String getDisplayStockAvailability() {
            return displayStockAvailability;
        }

        public void setDisplayStockAvailability(String displayStockAvailability) {
            this.displayStockAvailability = displayStockAvailability;
        }

        public String getDisplayStockQuantity() {
            return displayStockQuantity;
        }

        public void setDisplayStockQuantity(String displayStockQuantity) {
            this.displayStockQuantity = displayStockQuantity;
        }

        public Integer getMinStockQuantity() {
            return minStockQuantity;
        }

        public void setMinStockQuantity(Integer minStockQuantity) {
            this.minStockQuantity = minStockQuantity;
        }

        public Integer getLowStockActivityId() {
            return lowStockActivityId;
        }

        public void setLowStockActivityId(Integer lowStockActivityId) {
            this.lowStockActivityId = lowStockActivityId;
        }

        public Integer getNotifyAdminForQuantitybelow() {
            return notifyAdminForQuantitybelow;
        }

        public void setNotifyAdminForQuantitybelow(Integer notifyAdminForQuantitybelow) {
            this.notifyAdminForQuantitybelow = notifyAdminForQuantitybelow;
        }

        public Integer getBackOrderModeid() {
            return backOrderModeid;
        }

        public void setBackOrderModeid(Integer backOrderModeid) {
            this.backOrderModeid = backOrderModeid;
        }

        public String getAllowBackinstocksubscriptions() {
            return allowBackinstocksubscriptions;
        }

        public void setAllowBackinstocksubscriptions(String allowBackinstocksubscriptions) {
            this.allowBackinstocksubscriptions = allowBackinstocksubscriptions;
        }

        public Integer getOrderMinimumQuantity() {
            return orderMinimumQuantity;
        }

        public void setOrderMinimumQuantity(Integer orderMinimumQuantity) {
            this.orderMinimumQuantity = orderMinimumQuantity;
        }

        public Integer getOrderMaximumQuantity() {
            return orderMaximumQuantity;
        }

        public void setOrderMaximumQuantity(Integer orderMaximumQuantity) {
            this.orderMaximumQuantity = orderMaximumQuantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(String oldPrice) {
            this.oldPrice = oldPrice;
        }

        public String getMaximumCustomerEnteredprice() {
            return maximumCustomerEnteredprice;
        }

        public void setMaximumCustomerEnteredprice(String maximumCustomerEnteredprice) {
            this.maximumCustomerEnteredprice = maximumCustomerEnteredprice;
        }

        public String getMarkAsnew() {
            return markAsnew;
        }

        public void setMarkAsnew(String markAsnew) {
            this.markAsnew = markAsnew;
        }

        public String getMarkAsnewStartdatetimeutc() {
            return markAsnewStartdatetimeutc;
        }

        public void setMarkAsnewStartdatetimeutc(String markAsnewStartdatetimeutc) {
            this.markAsnewStartdatetimeutc = markAsnewStartdatetimeutc;
        }

        public String getMarkAsnewEnddatetimeutc() {
            return markAsnewEnddatetimeutc;
        }

        public void setMarkAsnewEnddatetimeutc(String markAsnewEnddatetimeutc) {
            this.markAsnewEnddatetimeutc = markAsnewEnddatetimeutc;
        }

        public String getHasDiscountsApplied() {
            return hasDiscountsApplied;
        }

        public void setHasDiscountsApplied(String hasDiscountsApplied) {
            this.hasDiscountsApplied = hasDiscountsApplied;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getAvailableStartdateTimeutc() {
            return availableStartdateTimeutc;
        }

        public void setAvailableStartdateTimeutc(String availableStartdateTimeutc) {
            this.availableStartdateTimeutc = availableStartdateTimeutc;
        }

        public String getAvailableEnddateTimeutc() {
            return availableEnddateTimeutc;
        }

        public void setAvailableEnddateTimeutc(String availableEnddateTimeutc) {
            this.availableEnddateTimeutc = availableEnddateTimeutc;
        }

        public Integer getDisplayOrder() {
            return displayOrder;
        }

        public void setDisplayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getCreatedOnUtc() {
            return createdOnUtc;
        }

        public void setCreatedOnUtc(String createdOnUtc) {
            this.createdOnUtc = createdOnUtc;
        }

        public String getUpdatedOnUtc() {
            return updatedOnUtc;
        }

        public void setUpdatedOnUtc(String updatedOnUtc) {
            this.updatedOnUtc = updatedOnUtc;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (categoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(categoryId);
        }
        if (productId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(productId);
        }
        if (productTypeId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(productTypeId);
        }
        if (parentGroupedProductid == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(parentGroupedProductid);
        }
        parcel.writeString(visibleIndividually);
        parcel.writeString(name);
        parcel.writeString(shortDescription);
        parcel.writeString(fullDescription);
        if (pictureId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pictureId);
        }
        parcel.writeString(showOnHomepage);
        parcel.writeString(metaKeywords);
        parcel.writeString(metaDescription);
        parcel.writeString(metaTitle);
        parcel.writeString(allowCustomerReviews);
        parcel.writeString(limitedToStores);
        parcel.writeString(sku);
        parcel.writeString(requireOtherProducts);
        parcel.writeString(requireDproductIds);
        parcel.writeString(automaticallyaddrequiredproduc);
        parcel.writeString(isShipEnabled);
        parcel.writeString(isFreeShipping);
        parcel.writeString(shipSeparately);
        parcel.writeString(additionalShippingCharge);
        if (deliveryDateId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(deliveryDateId);
        }
        parcel.writeString(isTaxExempt);
        if (taxCategoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(taxCategoryId);
        }
        if (stockQuantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(stockQuantity);
        }
        parcel.writeString(displayStockAvailability);
        parcel.writeString(displayStockQuantity);
        if (minStockQuantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(minStockQuantity);
        }
        if (lowStockActivityId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(lowStockActivityId);
        }
        if (notifyAdminForQuantitybelow == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(notifyAdminForQuantitybelow);
        }
        if (backOrderModeid == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(backOrderModeid);
        }
        parcel.writeString(allowBackinstocksubscriptions);
        if (orderMinimumQuantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(orderMinimumQuantity);
        }
        if (orderMaximumQuantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(orderMaximumQuantity);
        }
        parcel.writeString(price);
        parcel.writeString(oldPrice);
        parcel.writeString(maximumCustomerEnteredprice);
        parcel.writeString(markAsnew);
        parcel.writeString(markAsnewStartdatetimeutc);
        parcel.writeString(markAsnewEnddatetimeutc);
        parcel.writeString(hasDiscountsApplied);
        parcel.writeString(weight);
        parcel.writeString(length);
        parcel.writeString(width);
        parcel.writeString(height);
        parcel.writeString(availableStartdateTimeutc);
        parcel.writeString(availableEnddateTimeutc);
        if (displayOrder == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(displayOrder);
        }
        parcel.writeString(published);
        parcel.writeString(deleted);
        parcel.writeString(createdOnUtc);
        parcel.writeString(updatedOnUtc);
    }
}