package cn.xdeveloper.lib.common.inject.mvp;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseActivity;
import dagger.android.HasActivityInjector;

/**
 * Created by laiyimin on 2017/12/2.
 */

public abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity {

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityInject();
        super.onCreate(savedInstanceState);
    }

    /**
     * 注入,根据模块包名，找到对应的injector
     */
    private void activityInject() {
        String routerUrl = "";

        String className = getClass().getName();
        if (className.startsWith(RouterURL.MainModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.MainModule.INJECT;
        } else if (className.startsWith(RouterURL.GankModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.GankModule.INJECT;
        } else if (className.startsWith(RouterURL.ZhihuModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.ZhihuModule.INJECT;
        } else if (className.startsWith(RouterURL.MovieModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.MovieModule.INJECT;
        }

        HasActivityInjector injector = (HasActivityInjector) ARouter.getInstance().build(routerUrl).navigation();
        injector.activityInjector().inject(this);
    }

}
