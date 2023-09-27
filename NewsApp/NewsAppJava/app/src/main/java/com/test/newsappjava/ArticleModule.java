package com.test.newsappjava;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ArticleModule {

    @Provides
    public static List<Article> provideArticleList() {

        return new ArrayList<>();
    }
}
