package cn.xdeveloper.module.movie.inject;


import cn.xdeveloper.lib.common.inject.scope.ModuleScope;
import cn.xdeveloper.module.movie.http.MovieService;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : Laiyimin
 *     time   : 2017/11/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Module
public class ApiModule {

    @ModuleScope
    @Provides
    HttpUrl provideHttpUrl(){
        return HttpUrl.parse("https://api-m.mtime.cn/");
    }

    @ModuleScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient client,HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(httpUrl)
                .build();
    }

    @ModuleScope
    @Provides
    MovieService provideMovieService(Retrofit retrofit) {
        return retrofit.create(MovieService.class);
    }


}
