package cn.xdeveloper.module.gank.biz.gank;


import cn.xdeveloper.lib.common.inject.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class GankModule {

    @FragmentScope
    @Binds
    abstract GankContract.View view(GankFragment view);


    @FragmentScope
    @Binds
    abstract GankContract.Presenter presenter(GankPresenter presenter);

}
