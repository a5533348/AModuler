package cn.xdeveloper.module.movie;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.xdeveloper.lib.common.App;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.ApplicationInit;
import cn.xdeveloper.module.movie.inject.ModuleInjector;

/**
 * Created by laiyimin on 2017/11/20.
 */
@Route(path = RouterURL.MovieModule.CREATE)
public class ModuleApplication extends ApplicationInit {

    @Override
    public void onCreate(Context context) {

        App app = (App) context;
        ModuleInjector injector = ModuleInjector.getInstance();
        injector.injectIfNecessary(app.getAppComponent());
    }


}
