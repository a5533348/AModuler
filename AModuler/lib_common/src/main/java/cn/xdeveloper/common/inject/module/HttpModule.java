package cn.xdeveloper.common.inject.module;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.xdeveloper.common.BuildConstants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Laiyimin on 2016/3/14.
 */
@Module
public class HttpModule {



    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConstants.DEBUG_MODE) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        builder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS);

        return builder.build();
    }


}
