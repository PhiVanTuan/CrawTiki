package model.product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Phí Văn Tuấn
 */
public class Star {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("percent")
    @Expose
    private Integer percent;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
