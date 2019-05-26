package com.voxyle.wanandroid.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class OnResultCallBack<T> implements Callback<T> {
    public abstract void onSuccessful(Call<T> call, Response<T> response);

    public abstract void onFailure(String tag, Response<T> response);

    public abstract void onCompleted();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (200 == response.code()) {
            onSuccessful(call, response);
        } else {
            onFailure("code", response);
        }
        onCompleted();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure("exception", null);
        onCompleted();
    }
}
