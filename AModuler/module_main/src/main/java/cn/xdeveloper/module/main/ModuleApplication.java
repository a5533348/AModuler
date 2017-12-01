package cn.xdeveloper.module.main;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.xdeveloper.common.App;
import cn.xdeveloper.common.RouterURL;
import cn.xdeveloper.common.base.ApplicationInit;
import cn.xdeveloper.module.main.inject.ModuleInjector;

/**
 * Created by laiyimin on 2017/11/20.
 */
@Route(path = RouterURL.MainModule.INIT)
public class ModuleApplication extends ApplicationInit {

    @Override
    public void onCreate(Context context) {

        App app = (App) context;
        ModuleInjector injector = ModuleInjector.getInstance();
        injector.setAppComponent(app.getAppComponent());
        injector.injectIfNecessary();
    }


}
