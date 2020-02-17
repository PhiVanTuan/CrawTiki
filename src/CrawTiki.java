import api.ApiClient;

import com.google.gson.Gson;
import model.category.DatumCategory;
import model.category.TikiCategory;
import model.product.Datum;
import model.product.Review;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import model.product.TikiRate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawTiki {

    private static List<Review> lst;
    private static int sizeElement;
    public static void main(String[] args) {
        lst=new ArrayList<>();
        getPageCategory("4428",1);
//        ApiClient.getApiTemplateService().getCategory("4428",1).enqueue(new Callback<TikiCategory>() {
//            @Override
//            public void onResponse(Call<TikiCategory> call, Response<TikiCategory> response) {
//                TikiCategory category=response.body();
//                List<DatumCategory> lstData=category.getData();
//                for(int i=0;i<lstData.size();i++){
//                    String dataId=String.valueOf(lstData.get(i).getId());
//                    getPage(dataId, 1);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TikiCategory> call, Throwable throwable) {
//
//            }
//        });
//        ApiClient.getApiTemplateService().getData().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String result = response.body();
//                Document doc = Jsoup.parse(result);
//                Elements elements = doc.getElementsByClass("product-box-list").get(0).getElementsByTag("a");
//                sizeElement=elements.size();
//                for (int i = 0; i < sizeElement; i++) {
//                    String data_id = elements.get(i).attr("data-id");
//                    getPage(data_id, 1);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.println("onFailure " + t.getMessage());
//            }
//        });
    }

    private static void getPage(final String productID, int page) {

        ApiClient.getApiTemplateService().getTikis(productID, page).enqueue(new Callback<TikiRate>() {
            @Override
            public void onResponse(Call<TikiRate> call, Response<TikiRate> response) {
                TikiRate result = response.body();
                List<Datum> lstData = result.getData();
                for (int i = 0; i < lstData.size(); i++) {
                    Datum data = lstData.get(i);
                    Review review = new Review();
                    review.setProductId(productID);
                    review.setContent(data.getContent());
                    review.setRate(data.getRating());
                    lst.add(review);
                }
                int currentPage = result.getPaging().getCurrentPage();
                int lastpage = result.getPaging().getLastPage();
                if (currentPage != lastpage) {
                    getPage(productID, currentPage+1);
                }else {
                    List<Review> lstCache=new ArrayList<>();
                    lstCache.addAll(lst);
                    String text=new Gson().toJson(lstCache);
                    System.out.println(text);
                    writeFile(text);
                }
            }

            @Override
            public void onFailure(Call<TikiRate> call, Throwable t) {
                System.out.println("onFailure " + t.getMessage());
            }
        });
    }
    private static void writeFile(String text){
        try {

            File newTextFile = new File("result.txt");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(text);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }

    private static void getPageCategory(String categoryId,int page){
        ApiClient.getApiTemplateService().getCategory(categoryId,page).enqueue(new Callback<TikiCategory>() {
            @Override
            public void onResponse(Call<TikiCategory> call, Response<TikiCategory> response) {
                TikiCategory category=response.body();
                List<DatumCategory> lstData=category.getData();
                for(int i=0;i<lstData.size();i++){
                    String dataId=String.valueOf(lstData.get(i).getId());
                    getPage(dataId, 1);
                }
                int currentPage=category.getPaging().getCurrentPage();
                int lastPage=category.getPaging().getLastPage();
                if (currentPage<lastPage){
                    getPageCategory(categoryId,currentPage+1);
                }
            }

            @Override
            public void onFailure(Call<TikiCategory> call, Throwable throwable) {
                System.out.println("onFailure " +throwable.getMessage());
            }
        });
    }
}
