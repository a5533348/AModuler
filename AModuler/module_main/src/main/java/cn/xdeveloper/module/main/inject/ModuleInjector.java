package cn.xdeveloper.module.main.inject;

import cn.xdeveloper.common.inject.AppComponent;
import cn.xdeveloper.common.inject.base.BaseModuleInjector;
import dagger.android.AndroidInjector;

/**
 * module注入器
 * Created by laiyimin on 2017/11/30.
 */

public class ModuleInjector extends BaseModuleInjector {


    private static class SingletonHolder {
        private final static ModuleInjector instance = new ModuleInjector();
    }

    public static ModuleInjector getInstance() {
        return SingletonHolder.instance;
    }

    private ModuleInjector() {
    }

    private AppComponent appComponent;


    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }


    @Override
    protected AndroidInjector<? extends BaseModuleInjector> moduleInjector() {
        return DaggerModuleComponent
                .builder()
                .apiModule(new ApiModule())
                .appComponent(appComponent)
                .build();
    }
}
