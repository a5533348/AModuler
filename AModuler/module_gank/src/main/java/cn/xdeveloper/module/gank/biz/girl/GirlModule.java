package cn.xdeveloper.module.gank.biz.girl;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class GirlModule {

    @ActivityScope
    @Binds
    abstract GirlContract.View view(GirlActivity view);


    @ActivityScope
    @Binds
    abstract GirlContract.Presenter presenter(GirlPresenter presenter);

}
