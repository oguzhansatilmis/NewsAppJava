package com.test.newsappjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("v2/top-headlines")
    Call<NewsResponse> getTopObjectsList(
            @Query("country")
            String countryCode,
            @Query("category")
            String category,
            @Query("apikey")
            String API_KEY
    );
}
