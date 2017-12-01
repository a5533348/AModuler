package cn.xdeveloper.common.http;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by think on 2017/5/8.
 */

public class BaseResp<T> {
    @Expose
    @SerializedName("code")
    public int code;
    @Expose
    @SerializedName("msg")
    public String msg;

    @Nullable
    @Expose
    @SerializedName("data")
    public T t;
}
