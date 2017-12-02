package cn.xdeveloper.module.gank.inject;


import cn.xdeveloper.lib.common.inject.AppComponent;
import cn.xdeveloper.lib.common.inject.base.BaseModuleInjector;
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


    @Override
    protected AndroidInjector<? extends BaseModuleInjector> moduleInjector(AppComponent appComponent) {
        return DaggerModuleComponent
                .builder()
                .apiModule(new ApiModule())
                .appComponent(appComponent)
                .build();
    }
}
