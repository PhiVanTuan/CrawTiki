import api.ApiClient;

import com.google.gson.Gson;
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

    public static void main(String[] args) {
        getPageCategory("4428", 1);
    }

    private static void getPage(final String productID, int page, List<Review> lst,String url) {

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
                    review.setUrl(url);
                    lst.add(review);
                }
                int currentPage = result.getPaging().getCurrentPage();
                int lastpage = result.getPaging().getLastPage();
                if (currentPage != lastpage) {
                    getPage(productID, currentPage + 1, lst,url);
                } else {
                    String path = "/home/phivantuan/Documents/craw/";
                    String text = new Gson().toJson(lst);
                    writeFile(text, path + productID);
                }
            }

            @Override
            public void onFailure(Call<TikiRate> call, Throwable t) {
                System.out.println("onFailure get Product " + t.getMessage());
                getPage(productID,  page, lst, url);
            }
        });
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

    private static void getPageCategory(String categoryId, int page) {
        ApiClient.getApiTemplateService().getCategory(categoryId, page).enqueue(new Callback<TikiCategory>() {
            @Override
            public void onResponse(Call<TikiCategory> call, Response<TikiCategory> response) {
                TikiCategory category = response.body();
                List<DatumCategory> lstData = category.getData();
                for (int i = 0; i < lstData.size(); i++) {
                    String dataId = String.valueOf(lstData.get(i).getId());
                    String url="https://tiki.vn/"+lstData.get(i).getUrlPath();
                    List<Review> lst = new ArrayList<>();
                    getPage(dataId, 1, lst,url);
                }
                int currentPage = category.getPaging().getCurrentPage();
                int lastPage = category.getPaging().getLastPage();
//                if (currentPage < lastPage) {
//                    getPageCategory(categoryId, currentPage + 1);
//                }
            }

            @Override
            public void onFailure(Call<TikiCategory> call, Throwable throwable) {
                System.out.println("onFailure get Category " + throwable.getMessage());
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
