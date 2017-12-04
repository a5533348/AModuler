package cn.xdeveloper.module.zhihu.inject;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import cn.xdeveloper.lib.common.inject.scope.FragmentScope;
import cn.xdeveloper.module.zhihu.biz.daily.DailyActivity;
import cn.xdeveloper.module.zhihu.biz.daily.DailyModule;
import cn.xdeveloper.module.zhihu.biz.zhihu.ZhihuFragment;
import cn.xdeveloper.module.zhihu.biz.zhihu.ZhihuModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 注册View
 * Created by laiyimin on 2017/11/30.
 */

@Module
public abstract class ViewModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = DailyModule.class)
    abstract DailyActivity dailyActivity();

    @FragmentScope
    @ContributesAndroidInjector(modules = ZhihuModule.class)
    abstract ZhihuFragment zhihuFragment();
}
