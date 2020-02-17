package model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Phí Văn Tuấn
 */
public class ReviewPhoto {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_photo")
    @Expose
    private Integer totalPhoto;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPhoto() {
        return totalPhoto;
    }

    public void setTotalPhoto(Integer totalPhoto) {
        this.totalPhoto = totalPhoto;
    }
}
