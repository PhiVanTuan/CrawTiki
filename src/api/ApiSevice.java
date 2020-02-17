package api;



import model.category.TikiCategory;
import model.product.TikiRate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Phí Văn Tuấn on 17/2/2020.
 */

public interface ApiSevice {
    @GET("api/v2/reviews?limit=200&sort=score|desc,id|desc,stars|all&include=comments")
    Call<TikiRate> getTikis(@Query("product_id") String productID , @Query("page")int page);

    @GET("tai-nghe-co-day-nhet-tai/c4428")
    Call<String> getData();

    @GET("api/v2/products?limit=300&sort=position")
    Call<TikiCategory> getCategory(@Query("category_id") String categoryId,@Query("page") int page);
}
