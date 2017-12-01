package cn.xdeveloper.module.main.biz.main;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @ActivityScope
    @Binds
    abstract MainContract.View view(MainActivity view);


    @ActivityScope
    @Binds
    abstract MainContract.Presenter presenter(MainPresenter presenter);

}
