package api;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Phí Văn Tuấn on 17/2/2020.
 */

public class ApiClient {
    public static final String BASE_URL = "https://tiki.vn/";
    private static Retrofit retrofit;

    /**
     * Get Retrofit Instance
     */
    private static synchronized Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiSevice getApiTemplateService() {

        return getRetrofitInstance().create(ApiSevice.class);
    }
}
