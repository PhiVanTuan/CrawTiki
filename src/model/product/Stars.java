package model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Phí Văn Tuấn
 */
public class Stars {

    @SerializedName("1")
    @Expose
    private Star oneStar;
    @SerializedName("2")
    @Expose
    private Star twoStar;
    @SerializedName("3")
    @Expose
    private Star threeStar;
    @SerializedName("4")
    @Expose
    private Star fourStar;
    @SerializedName("5")
    @Expose
    private Star fiveStar;

    public Star getOneStar() {
        return oneStar;
    }

    public void setOneStar(Star oneStar) {
        this.oneStar = oneStar;
    }

    public Star getTwoStar() {
        return twoStar;
    }

    public void setTwoStar(Star twoStar) {
        this.twoStar = twoStar;
    }

    public Star getThreeStar() {
        return threeStar;
    }

    public void setThreeStar(Star threeStar) {
        this.threeStar = threeStar;
    }

    public Star getFourStar() {
        return fourStar;
    }

    public void setFourStar(Star fourStar) {
        this.fourStar = fourStar;
    }

    public Star getFiveStar() {
        return fiveStar;
    }

    public void setFiveStar(Star fiveStar) {
        this.fiveStar = fiveStar;
    }
    
}
