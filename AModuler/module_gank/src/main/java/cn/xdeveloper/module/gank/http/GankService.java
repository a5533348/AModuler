package cn.xdeveloper.module.gank.http;

import cn.xdeveloper.module.gank.http.dto.GankResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by laiyimin on 2017/12/1.
 */

public interface GankService {


    @GET("data/{type}/{cnt}/{page}")
    Observable<GankResult> getData(@Path("type") String type, @Path("cnt") int cnt, @Path("page") int page);
}
