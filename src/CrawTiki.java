import api.ApiClient;

import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import model.category.DatumCategory;
import model.category.TikiCategory;
import model.product.Datum;
import model.product.Review;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import model.product.TikiRate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CrawTiki {
    private static String path = "/home/phivantuan/Documents/craw2/";
    public static void main(String[] args) {
        getAll();
    }

    private static void getReview(String categoryId,final String productID, int page, List<Review> lst, String url) {

        ApiClient.getApiTemplateService().getTikis(productID, page).enqueue(new Callback<TikiRate>() {
            @Override
            public void onResponse(Call<TikiRate> call, Response<TikiRate> response) {
                TikiRate result = response.body();
                List<Datum> lstData = result.getData();
                if (lstData != null && lstData.size() > 0) {
                    for (int i = 0; i < lstData.size(); i++) {
                        Datum data = lstData.get(i);
                        Review review = new Review();
                        review.setProductId(productID);
                        review.setContent(data.getContent());
                        review.setRate(data.getRating());
                        review.setUrl(url);
                        lst.add(review);
                    }
                    int currentPage = result.getPaging().getCurrentPage();
                    int lastpage = result.getPaging().getLastPage();
//                    List<Integer> lstPage = new ArrayList<>();
//                    for (int i = currentPage; i <= lastpage; i++) {
//                        lstPage.add(i);
//                    }
//                    Observable.zip(getLstpage(result), (i) -> getReviews((TikiRate[]) i, productID, url))
//                            .subscribe(str -> writeFile(str, categoryId, productID));
//
                    if (currentPage != lastpage) {
                        getReview(categoryId,productID, currentPage + 1, lst, url);
                    } else {
                        String path_ = path+categoryId+"/";
                        String text = new Gson().toJson(lst);
                        writeFile(text, path_ + productID);
                    }
                }

            }

            @Override
            public void onFailure(Call<TikiRate> call, Throwable t) {
                String failure="categoryId : "+categoryId+"  productID : "+productID+"  page:  "+page+"  url  : "+url;
                System.out.println("onFailure get Product " + t.getMessage()+"   "+failure);
//                getReview(categoryId,productID, page, lst, url);
            }
        });
}



    private static void writeFile(List<Review> lst,String categoryId,String productID){
        String path_ = path+categoryId+"/";
        String text = new Gson().toJson(lst);
        writeFile(text, path_ + productID);
    }
    private static List<Observable<TikiRate>> getLstpage(TikiRate tikiRate){
        List<Integer> lstPage=new ArrayList<>();
        List<Observable<TikiRate>> lst=new ArrayList<>();
        try {
            for (int i=tikiRate.getPaging().getCurrentPage();i<=tikiRate.getPaging().getLastPage();i++){
                lstPage.add(i);
                lst.add(ApiClient.getApiTemplateService().getReview("tikiRate.get",i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return lst;
    }

    private static List<Review> getReviews(TikiRate[] results,String productID,String url) {
        List<Review> lst = new ArrayList<>();
        for (int i=0;i<results.length;i++){
            TikiRate result=results[i];
            List<Datum> lstData = result.getData();
            if (lstData != null && lstData.size() > 0) {
                for (int j = 0; j < lstData.size(); j++) {
                    Datum data = lstData.get(j);
                    Review review = new Review();
                    review.setProductId(productID);
                    review.setContent(data.getContent());
                    review.setRate(data.getRating());
                    review.setUrl(url);
                    lst.add(review);
                }
            }
        }

        return lst;
    }
    private static void writeFile(String text, String fileName) {
        try {

            File newTextFile = new File(fileName + ".txt");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(text);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }

    private static void getCategory(String categoryId, int page) {
        ApiClient.getApiTemplateService().getCategory(categoryId, page).enqueue(new Callback<TikiCategory>() {
            @Override
            public void onResponse(Call<TikiCategory> call, Response<TikiCategory> response) {
                TikiCategory category = response.body();
                List<DatumCategory> lstData = category.getData();
                if (lstData != null && lstData.size() > 0) {
                    for (int i = 0; i < lstData.size(); i++) {
                        String dataId = String.valueOf(lstData.get(i).getId());
                        String url = "https://tiki.vn/" + lstData.get(i).getUrlPath();
                        List<Review> lst = new ArrayList<>();
                        getReview(categoryId,dataId, 1, lst, url);
                    }
                    int currentPage = category.getPaging().getCurrentPage();
                    int lastPage = category.getPaging().getLastPage();
                    if (currentPage < lastPage) {
                        getCategory(categoryId, currentPage + 1);
                    }
                }

            }

            @Override
            public void onFailure(Call<TikiCategory> call, Throwable throwable) {
                System.out.println("onFailure get Category " + throwable.getMessage());
            }
        });
    }

    private static void getAll(){
      ApiClient.getApiTemplateService().getAll().enqueue(new Callback<TikiCategory>() {
          @Override
          public void onResponse(Call<TikiCategory> call, Response<TikiCategory> response) {
              TikiCategory allCategory=response.body();
              List<DatumCategory> lstData=allCategory.getData();
              for(int i=0;i<lstData.size();i++){
                  int id=lstData.get(i).getId();
                  File f=new File(path+id+"/");
                  if (!f.exists()) f.mkdirs();
                  getCategory(String.valueOf(id),1);
              }
          }

          @Override
          public void onFailure(Call<TikiCategory> call, Throwable throwable) {

          }
      });
    }

    private static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                String content;

                try {
                    content = new String(Files.readAllBytes(Paths.get(fileEntry.getAbsolutePath())));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(fileEntry.getName());
            }
        }
    }
}
