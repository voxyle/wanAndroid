package com.voxyle.wanandroid.net;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Nullable
    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tmpStr = bufferedSource.readUtf8();
        bufferedSource.close();
        return JSONObject.parseObject(tmpStr,type);
    }
}
