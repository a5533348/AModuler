package cn.xdeveloper.module.movie.http;


import cn.xdeveloper.module.movie.http.dto.MovieResult;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by laiyimin on 2017/12/2.
 */

public interface MovieService {

    @GET("Movie/MovieComingNew.api?locationId=290")
    Observable<MovieResult> getMovieList();

}
