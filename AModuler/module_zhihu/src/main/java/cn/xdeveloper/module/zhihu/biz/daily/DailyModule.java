package cn.xdeveloper.module.zhihu.biz.daily;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class DailyModule {

    @ActivityScope
    @Binds
    abstract DailyContract.View view(DailyActivity view);


    @ActivityScope
    @Binds
    abstract DailyContract.Presenter presenter(DailyPresenter presenter);

}
