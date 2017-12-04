package cn.xdeveloper.module.zhihu.biz.zhihu;


import cn.xdeveloper.lib.common.inject.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ZhihuModule {

    @FragmentScope
    @Binds
    abstract ZhihuContract.View view(ZhihuFragment view);


    @FragmentScope
    @Binds
    abstract ZhihuContract.Presenter presenter(ZhihuPresenter presenter);

}
