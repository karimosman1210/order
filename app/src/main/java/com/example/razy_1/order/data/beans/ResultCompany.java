package com.example.razy_1.order.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultCompany implements Parcelable {
    @SerializedName("__metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("Mandt")
    @Expose
    private String mandt;
    @SerializedName("SupplierId")
    @Expose
    private Integer supplierId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("SupplierTemplateId")
    @Expose
    private Integer supplierTemplateId;
    @SerializedName("MetaKeywords")
    @Expose
    private String metaKeywords;
    @SerializedName("MetaDescription")
    @Expose
    private String metaDescription;
    @SerializedName("MetaTitle")
    @Expose
    private String metaTitle;
    @SerializedName("PictureId")
    @Expose
    private Integer pictureId;
    @SerializedName("PageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("Allowcustomerstoselectpagesize")
    @Expose
    private String allowcustomerstoselectpagesize;
    @SerializedName("PageSizeOptions")
    @Expose
    private String pageSizeOptions;
    @SerializedName("PriceRanges")
    @Expose
    private String priceRanges;
    @SerializedName("LimitedToStores")
    @Expose
    private String limitedToStores;
    @SerializedName("Published")
    @Expose
    private String published;
    @SerializedName("Deleted")
    @Expose
    private String deleted;
    @SerializedName("DisplayOrder")
    @Expose
    private Integer displayOrder;
    @SerializedName("CreatedOnUtc")
    @Expose
    private String createdOnUtc;
    @SerializedName("UpdatedOnUtc")
    @Expose
    private String updatedOnUtc;

    protected ResultCompany(Parcel in) {
        mandt = in.readString();
        if (in.readByte() == 0) {
            supplierId = null;
        } else {
            supplierId = in.readInt();
        }
        name = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            supplierTemplateId = null;
        } else {
            supplierTemplateId = in.readInt();
        }
        metaKeywords = in.readString();
        metaDescription = in.readString();
        metaTitle = in.readString();
        if (in.readByte() == 0) {
            pictureId = null;
        } else {
            pictureId = in.readInt();
        }
        if (in.readByte() == 0) {
            pageSize = null;
        } else {
            pageSize = in.readInt();
        }
        allowcustomerstoselectpagesize = in.readString();
        pageSizeOptions = in.readString();
        priceRanges = in.readString();
        limitedToStores = in.readString();
        published = in.readString();
        deleted = in.readString();
        if (in.readByte() == 0) {
            displayOrder = null;
        } else {
            displayOrder = in.readInt();
        }
        createdOnUtc = in.readString();
        updatedOnUtc = in.readString();
    }

    public static final Creator<ResultCompany> CREATOR = new Creator<ResultCompany>() {
        @Override
        public ResultCompany createFromParcel(Parcel in) {
            return new ResultCompany(in);
        }

        @Override
        public ResultCompany[] newArray(int size) {
            return new ResultCompany[size];
        }
    };

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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSupplierTemplateId() {
        return supplierTemplateId;
    }

    public void setSupplierTemplateId(Integer supplierTemplateId) {
        this.supplierTemplateId = supplierTemplateId;
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

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAllowcustomerstoselectpagesize() {
        return allowcustomerstoselectpagesize;
    }

    public void setAllowcustomerstoselectpagesize(String allowcustomerstoselectpagesize) {
        this.allowcustomerstoselectpagesize = allowcustomerstoselectpagesize;
    }

    public String getPageSizeOptions() {
        return pageSizeOptions;
    }

    public void setPageSizeOptions(String pageSizeOptions) {
        this.pageSizeOptions = pageSizeOptions;
    }

    public String getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(String priceRanges) {
        this.priceRanges = priceRanges;
    }

    public String getLimitedToStores() {
        return limitedToStores;
    }

    public void setLimitedToStores(String limitedToStores) {
        this.limitedToStores = limitedToStores;
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

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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
        parcel.writeString(mandt);
        if (supplierId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(supplierId);
        }
        parcel.writeString(name);
        parcel.writeString(description);
        if (supplierTemplateId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(supplierTemplateId);
        }
        parcel.writeString(metaKeywords);
        parcel.writeString(metaDescription);
        parcel.writeString(metaTitle);
        if (pictureId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pictureId);
        }
        if (pageSize == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pageSize);
        }
        parcel.writeString(allowcustomerstoselectpagesize);
        parcel.writeString(pageSizeOptions);
        parcel.writeString(priceRanges);
        parcel.writeString(limitedToStores);
        parcel.writeString(published);
        parcel.writeString(deleted);
        if (displayOrder == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(displayOrder);
        }
        parcel.writeString(createdOnUtc);
        parcel.writeString(updatedOnUtc);
    }
}
