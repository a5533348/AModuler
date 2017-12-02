package cn.xdeveloper.module.main.inject;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import cn.xdeveloper.module.main.biz.main.MainActivity;
import cn.xdeveloper.module.main.biz.main.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 注册View
 * Created by laiyimin on 2017/11/30.
 */

@Module
public abstract class ViewModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

}
