package model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Phí Văn Tuấn
 */
public class Image {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("full_path")
    @Expose
    private String fullPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
}
