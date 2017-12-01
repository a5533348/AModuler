package cn.xdeveloper.common.inject;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import cn.xdeveloper.common.inject.module.AppModule;
import cn.xdeveloper.common.inject.module.HttpModule;
import dagger.Component;
import okhttp3.OkHttpClient;


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    Application application();

    Gson gson();

    OkHttpClient okHttpClient();

}
