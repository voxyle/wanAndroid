package com.voxyle.wanandroid.net;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import javax.annotation.Nullable;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public class FastJsonRequestBodyConverte<F> implements Converter<F, RequestBody> {
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=UTF-8");

    @Nullable
    @Override
    public RequestBody convert(F value) throws IOException {
        return RequestBody.create(JSON_TYPE, JSONObject.toJSONString(value));

    }
}
