package model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Phí Văn Tuấn
 */
public class CreatedBy {
    @SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("full_name")
@Expose
private String fullName;
@SerializedName("region")
@Expose
private Object region;
@SerializedName("avatar_url")
@Expose
private String avatarUrl;
@SerializedName("purchased")
@Expose
private Boolean purchased;
@SerializedName("purchased_at")
@Expose
private Integer purchasedAt;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public Object getRegion() {
return region;
}

public void setRegion(Object region) {
this.region = region;
}

public String getAvatarUrl() {
return avatarUrl;
}

public void setAvatarUrl(String avatarUrl) {
this.avatarUrl = avatarUrl;
}

public Boolean getPurchased() {
return purchased;
}

public void setPurchased(Boolean purchased) {
this.purchased = purchased;
}

public Integer getPurchasedAt() {
return purchasedAt;
}

public void setPurchasedAt(Integer purchasedAt) {
this.purchasedAt = purchasedAt;
}
}
