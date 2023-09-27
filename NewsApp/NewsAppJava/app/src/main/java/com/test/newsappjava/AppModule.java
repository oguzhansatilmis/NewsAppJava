package com.test.newsappjava;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    // Diğer bağımlılıklarınızı da burada sağlayabilirsiniz.
}
