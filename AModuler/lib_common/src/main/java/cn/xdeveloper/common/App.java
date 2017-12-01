package cn.xdeveloper.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import cn.xdeveloper.common.inject.AppComponent;
import cn.xdeveloper.common.inject.DaggerAppComponent;
import cn.xdeveloper.common.inject.module.AppModule;
import cn.xdeveloper.common.inject.module.HttpModule;


/**
 * <pre>
 *     author : Laiyimin
 *     time   : 2017/11/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConstants.DEBUG_MODE) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);


        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();

        dispatchOnCreateToModule();
    }

    /**
     * 分发onCreate给module
     */
    private void dispatchOnCreateToModule() {
        ARouter.getInstance().build(RouterURL.MainModule.INIT).navigation();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


}
