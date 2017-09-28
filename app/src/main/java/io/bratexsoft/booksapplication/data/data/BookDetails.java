package io.bratexsoft.booksapplication.data.data;

import com.google.gson.annotations.SerializedName;

public class BookDetails {

    @SerializedName("_id")
    private String uid;

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    public Integer id;

    @SerializedName("full_title")
    private String fullTitle;

    @SerializedName("availability")
    private String availability;

    @SerializedName("absolute_url")
    private String absoluteUrl;

    @SerializedName("site_price")
    private Float sitePrice;

    @SerializedName("site_price_currency")
    private String sitePriceCurrency;

    @SerializedName("title")
    private String title;

    @SerializedName("slug")
    private String slug;

    @SerializedName("cat_number")
    private String catNumber;

    @SerializedName("main_image")
    private String mainImage;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("description")
    private String description;

    @SerializedName("has_variants")
    private Boolean hasVariants;

    @SerializedName("exclusive")
    private Boolean exclusive;

    @SerializedName("listed")
    private Boolean listed;

    @SerializedName("signed")
    private Boolean signed;

    @SerializedName("limited_edition")
    private Boolean limitedEdition;

    @SerializedName("extended_delivery")
    private Boolean extendedDelivery;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("preorder_date")
    private String preorderDate;

    @SerializedName("ean")
    private String ean;

    @SerializedName("rrp")
    private Float rrp;

    @SerializedName("isbn")
    private String isbn;

    @SerializedName("supplier_code")
    private String supplierCode;

    @SerializedName("last_modified")
    private String lastModified;

    @SerializedName("supertype")
    private String supertype;

    @SerializedName("index")
    private Integer index;

    @SerializedName("likes")
    private Integer likes;

    public String getUid() {
        return uid;
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getAvailability() {
        return availability;
    }

    public String getAbsoluteUrl() {
        return absoluteUrl;
    }

    public Float getSitePrice() {
        return sitePrice;
    }

    public String getSitePriceCurrency() {
        return sitePriceCurrency;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getCatNumber() {
        return catNumber;
    }

    public String getMainImage() {
        return mainImage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getHasVariants() {
        return hasVariants;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public Boolean getListed() {
        return listed;
    }

    public Boolean getSigned() {
        return signed;
    }

    public Boolean getLimitedEdition() {
        return limitedEdition;
    }

    public Boolean getExtendedDelivery() {
        return extendedDelivery;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPreorderDate() {
        return preorderDate;
    }

    public String getEan() {
        return ean;
    }

    public Float getRrp() {
        return rrp;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getSupertype() {
        return supertype;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getLikes() {
        return likes;
    }
}
