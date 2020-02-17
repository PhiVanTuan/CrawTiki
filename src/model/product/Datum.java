package model.product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Phí Văn Tuấn
 */
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("thank_count")
    @Expose
    private Integer thankCount;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("new_score")
    @Expose
    private Double newScore;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("thanked")
    @Expose
    private Boolean thanked;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("seller")
    @Expose
    private Seller seller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getThankCount() {
        return thankCount;
    }

    public void setThankCount(Integer thankCount) {
        this.thankCount = thankCount;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getNewScore() {
        return newScore;
    }

    public void setNewScore(Double newScore) {
        this.newScore = newScore;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getThanked() {
        return thanked;
    }

    public void setThanked(Boolean thanked) {
        this.thanked = thanked;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
