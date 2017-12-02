package cn.xdeveloper.module.main.inject;


import cn.xdeveloper.lib.common.BuildConstants;
import cn.xdeveloper.lib.common.inject.scope.ModuleScope;
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
        return HttpUrl.parse("");
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

//    @ModuleScope
//    @Provides
//    CloudApi provideCloudApi(Retrofit retrofit) {
//        return retrofit.create(CloudApi.class);
//    }


}
