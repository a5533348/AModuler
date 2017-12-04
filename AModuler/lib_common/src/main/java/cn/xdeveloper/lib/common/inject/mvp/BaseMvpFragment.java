package cn.xdeveloper.lib.common.inject.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseFragment;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by laiyimin on 2017/12/2.
 */

public abstract class BaseMvpFragment<P extends IPresenter>  extends BaseFragment {

    @Inject
    protected P mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        fragmentInject();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * fragment注入
     */
    private void fragmentInject() {
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

        HasSupportFragmentInjector injector = (HasSupportFragmentInjector) ARouter.getInstance().build(routerUrl).navigation();
        injector.supportFragmentInjector().inject(this);
    }
}
