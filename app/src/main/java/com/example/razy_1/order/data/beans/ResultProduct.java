package com.example.razy_1.order.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultProduct implements Parcelable {

    @SerializedName("__metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("Mandt")
    @Expose
    private String mandt;
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("CategoryTemplateId")
    @Expose
    private Integer categoryTemplateId;
    @SerializedName("MetaKwywords")
    @Expose
    private String metaKwywords;
    @SerializedName("MetaDescription")
    @Expose
    private String metaDescription;
    @SerializedName("MetaTitle")
    @Expose
    private String metaTitle;
    @SerializedName("ParentCategoryId")
    @Expose
    private Integer parentCategoryId;
    @SerializedName("PictureId")
    @Expose
    private Integer pictureId;
    @SerializedName("PageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("AllowCustomersSelectPageSi")
    @Expose
    private String allowCustomersSelectPageSi;
    @SerializedName("PageSizeOptions")
    @Expose
    private String pageSizeOptions;
    @SerializedName("PriceRanges")
    @Expose
    private String priceRanges;
    @SerializedName("ShowOnHomePage")
    @Expose
    private String showOnHomePage;
    @SerializedName("IncludeInTopMenu")
    @Expose
    private String includeInTopMenu;
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

    protected ResultProduct(Parcel in) {
        mandt = in.readString();
        if (in.readByte() == 0) {
            categoryId = null;
        } else {
            categoryId = in.readInt();
        }
        name = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            categoryTemplateId = null;
        } else {
            categoryTemplateId = in.readInt();
        }
        metaKwywords = in.readString();
        metaDescription = in.readString();
        metaTitle = in.readString();
        if (in.readByte() == 0) {
            parentCategoryId = null;
        } else {
            parentCategoryId = in.readInt();
        }
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
        allowCustomersSelectPageSi = in.readString();
        pageSizeOptions = in.readString();
        priceRanges = in.readString();
        showOnHomePage = in.readString();
        includeInTopMenu = in.readString();
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

    public static final Creator<ResultProduct> CREATOR = new Creator<ResultProduct>() {
        @Override
        public ResultProduct createFromParcel(Parcel in) {
            return new ResultProduct(in);
        }

        @Override
        public ResultProduct[] newArray(int size) {
            return new ResultProduct[size];
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Integer getCategoryTemplateId() {
        return categoryTemplateId;
    }

    public void setCategoryTemplateId(Integer categoryTemplateId) {
        this.categoryTemplateId = categoryTemplateId;
    }

    public String getMetaKwywords() {
        return metaKwywords;
    }

    public void setMetaKwywords(String metaKwywords) {
        this.metaKwywords = metaKwywords;
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

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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

    public String getAllowCustomersSelectPageSi() {
        return allowCustomersSelectPageSi;
    }

    public void setAllowCustomersSelectPageSi(String allowCustomersSelectPageSi) {
        this.allowCustomersSelectPageSi = allowCustomersSelectPageSi;
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

    public String getShowOnHomePage() {
        return showOnHomePage;
    }

    public void setShowOnHomePage(String showOnHomePage) {
        this.showOnHomePage = showOnHomePage;
    }

    public String getIncludeInTopMenu() {
        return includeInTopMenu;
    }

    public void setIncludeInTopMenu(String includeInTopMenu) {
        this.includeInTopMenu = includeInTopMenu;
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
        if (categoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(categoryId);
        }
        parcel.writeString(name);
        parcel.writeString(description);
        if (categoryTemplateId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(categoryTemplateId);
        }
        parcel.writeString(metaKwywords);
        parcel.writeString(metaDescription);
        parcel.writeString(metaTitle);
        if (parentCategoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(parentCategoryId);
        }
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
        parcel.writeString(allowCustomersSelectPageSi);
        parcel.writeString(pageSizeOptions);
        parcel.writeString(priceRanges);
        parcel.writeString(showOnHomePage);
        parcel.writeString(includeInTopMenu);
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
