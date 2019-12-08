package com.codes.amr.showrooms.di.module;

import com.codes.amr.showrooms.data.rest.ShowRoomService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    public static final String BASE_URL = "https://showroomz.com/";
    public static final String BASE_Service = "api/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ShowRoomService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ShowRoomService.class);
    }
}
