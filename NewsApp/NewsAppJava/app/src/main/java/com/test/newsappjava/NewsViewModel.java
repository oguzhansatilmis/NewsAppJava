package com.test.newsappjava;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private final NewsService newsService;

    private final MutableLiveData<NewsResponse> newsLiveData = new MutableLiveData<>();

    public LiveData<NewsResponse> getNewsLiveData() {
        return newsLiveData;
    }

    @Inject
    public NewsViewModel(NewsService newsService) {
        this.newsService = newsService;
        getTopNews(Const.countryCode,Const.category,Const.API_KEY);
    }



    public void getTopNews(String countryCode, String category, String apiKey) {
        Call<NewsResponse> call = newsService.getTopObjectsList(countryCode, category, apiKey);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    NewsResponse newsResponse = response.body();
                    newsLiveData.setValue(newsResponse); // LiveData'ya verileri bildir
                } else {
                    // Hata durumlarına uygun bir şekilde işleyebilirsiniz.
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                // İstek başarısız oldu, hata durumlarına uygun bir şekilde işleyebilirsiniz.
            }
        });
    }
}
