package cn.xdeveloper.lib.common.inject.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xdeveloper.lib.common.RouterURL;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseFragment<P extends IPresenter> extends RxFragment {
    protected BaseActivity mActivity;
    protected View mRootView;
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    protected P mPresenter;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = initView(inflater,container,savedInstanceState);
        //绑定到butterknife
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        fragmentInject();

        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        initData();
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
        } else if (className.startsWith(RouterURL.GithubModule.PACKAGE_NAME)) {
            routerUrl = RouterURL.GithubModule.INJECT;
        }

        HasSupportFragmentInjector injector = (HasSupportFragmentInjector) ARouter.getInstance().build(routerUrl).navigation();
        injector.supportFragmentInjector().inject(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mActivity = null;
        this.mRootView = null;
        this.mUnbinder = null;
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();


}
