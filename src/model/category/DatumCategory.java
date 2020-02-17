package model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCategory {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url_key")
    @Expose
    private String urlKey;
    @SerializedName("url_path")
    @Expose
    private String urlPath;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("list_price")
    @Expose
    private Integer listPrice;

    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("discount_rate")
    @Expose
    private Integer discountRate;
    @SerializedName("rating_average")
    @Expose
    private Double ratingAverage;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("order_count")
    @Expose
    private Integer orderCount;
    @SerializedName("favourite_count")
    @Expose
    private Integer favouriteCount;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("has_ebook")
    @Expose
    private Boolean hasEbook;
    @SerializedName("inventory_status")
    @Expose
    private String inventoryStatus;
    @SerializedName("is_visible")
    @Expose
    private Boolean isVisible;
    @SerializedName("productset_group_name")
    @Expose
    private String productsetGroupName;
    @SerializedName("is_flower")
    @Expose
    private Boolean isFlower;
    @SerializedName("is_gift_card")
    @Expose
    private Boolean isGiftCard;

    @SerializedName("url_attendant_input_form")
    @Expose
    private String urlAttendantInputForm;
    @SerializedName("salable_type")
    @Expose
    private String salableType;
    @SerializedName("seller_product_id")
    @Expose
    private Integer sellerProductId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }




    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Integer favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Boolean getHasEbook() {
        return hasEbook;
    }

    public void setHasEbook(Boolean hasEbook) {
        this.hasEbook = hasEbook;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public String getProductsetGroupName() {
        return productsetGroupName;
    }

    public void setProductsetGroupName(String productsetGroupName) {
        this.productsetGroupName = productsetGroupName;
    }

    public Boolean getIsFlower() {
        return isFlower;
    }

    public void setIsFlower(Boolean isFlower) {
        this.isFlower = isFlower;
    }

    public Boolean getIsGiftCard() {
        return isGiftCard;
    }

    public void setIsGiftCard(Boolean isGiftCard) {
        this.isGiftCard = isGiftCard;
    }





    public String getUrlAttendantInputForm() {
        return urlAttendantInputForm;
    }

    public void setUrlAttendantInputForm(String urlAttendantInputForm) {
        this.urlAttendantInputForm = urlAttendantInputForm;
    }

    public String getSalableType() {
        return salableType;
    }

    public void setSalableType(String salableType) {
        this.salableType = salableType;
    }

    public Integer getSellerProductId() {
        return sellerProductId;
    }

    public void setSellerProductId(Integer sellerProductId) {
        this.sellerProductId = sellerProductId;
    }
}
