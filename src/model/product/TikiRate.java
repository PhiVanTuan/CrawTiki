package model.product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Phí Văn Tuấn
 */
public class TikiRate {

    @SerializedName("stars")
    @Expose
    private Stars stars;
    @SerializedName("rating_average")
    @Expose
    private Double ratingAverage;
    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("review_photo")
    @Expose
    private ReviewPhoto reviewPhoto;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("sort_options")
    @Expose
    private List<List<SortOption>> sortOptions = null;
    @SerializedName("exclude_image")
    @Expose
    private Boolean excludeImage;

    public Stars getStars() {
        return stars;
    }

    public void setStars(Stars stars) {
        this.stars = stars;
    }

    public Double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public ReviewPhoto getReviewPhoto() {
        return reviewPhoto;
    }

    public void setReviewPhoto(ReviewPhoto reviewPhoto) {
        this.reviewPhoto = reviewPhoto;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<List<SortOption>> getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(List<List<SortOption>> sortOptions) {
        this.sortOptions = sortOptions;
    }

    public Boolean getExcludeImage() {
        return excludeImage;
    }

    public void setExcludeImage(Boolean excludeImage) {
        this.excludeImage = excludeImage;
    }

}
