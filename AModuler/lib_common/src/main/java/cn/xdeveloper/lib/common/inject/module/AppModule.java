package cn.xdeveloper.lib.common.inject.module;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laiyimin on 2017/11/3.
 */
@Module
public class AppModule {


    public AppModule(Application application) {
        this.mApplication = application;
    }

    private Application mApplication;

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    public Gson provideGson(){return new Gson();}



}