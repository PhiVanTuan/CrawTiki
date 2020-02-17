package model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import model.product.Paging;

import java.util.List;

public class TikiCategory {
    @SerializedName("data")
    @Expose
    private List<DatumCategory> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<DatumCategory> getData() {
        return data;
    }

    public void setData(List<DatumCategory> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
