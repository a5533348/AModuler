package cn.xdeveloper.common.inject.mvp;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xdeveloper.common.App;
import cn.xdeveloper.common.RouterURL;
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
     * 注入
     */
    private void activityInject() {
        String className = getClass().getName();
        if (className.startsWith("com.gyenno.module.main")){
            HasActivityInjector injector = (HasActivityInjector) ARouter.getInstance().build(RouterURL.MainModule.INJECT).navigation();
            injector.activityInjector().inject(this);
        }
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
     * @return
     */
    protected abstract int getContentView();

    protected abstract void initData();


}
