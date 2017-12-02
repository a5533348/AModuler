package cn.xdeveloper.module.zhihu.http;

import cn.xdeveloper.module.zhihu.http.dto.ZhihuResult;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by laiyimin on 2017/12/1.
 */

public interface ZhihuService {


    @GET("news/latest")
    Observable<ZhihuResult> getData();
}
