package cn.xdeveloper.lib.common.inject.mvp;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xdeveloper.lib.common.App;
import cn.xdeveloper.lib.common.RouterURL;
import dagger.android.HasActivityInjector;

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    protected App mApplication;
    private Unbinder mUnbinder;

    @Inject
    protected P mPresenter;
    protected Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityInject();

        super.onCreate(savedInstanceState);
        mApplication = (App) getApplication();
        mContext = this;

        setContentView(getContentView());
        mUnbinder = ButterKnife.bind(this);
        initData();

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
        } else if (className.startsWith(RouterURL.GithubModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.GithubModule.INJECT;
        }

        HasActivityInjector injector = (HasActivityInjector) ARouter.getInstance().build(routerUrl).navigation();
        injector.activityInjector().inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        this.mUnbinder = null;
        this.mApplication = null;
    }


    /**
     * 返回Layout
     *
     * @return
     */
    protected abstract int getContentView();

    protected abstract void initData();


}
