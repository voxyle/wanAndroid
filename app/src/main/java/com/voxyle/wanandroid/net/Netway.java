package com.voxyle.wanandroid.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class Netway {
    private static volatile WanAndroidApi baseApi;

    public static WanAndroidApi getDefault() {
        if (baseApi == null) {
            synchronized (Netway.class) {
                if (baseApi == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("")
                            .client(getOkInstance())
                            .addConverterFactory(new FastJsonConverterFactory())
                            .build();
                    baseApi = retrofit.create(WanAndroidApi.class);
                }
            }
        }
        return baseApi;
    }

    private static OkHttpClient getOkInstance() {
        return OkhttpHolder.instance;
    }

    private static class OkhttpHolder {
        private static final OkHttpClient instance;

        static {
            instance = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();
        }
    }


}
