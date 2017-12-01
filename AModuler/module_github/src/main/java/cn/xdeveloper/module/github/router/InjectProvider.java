package cn.xdeveloper.module.github.router;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.module.github.inject.ModuleInjector;
import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * 注入提供
 * Created by laiyimin on 2017/12/1.
 */

@Route(path = RouterURL.GithubModule.INJECT)
public class InjectProvider implements IProvider,HasActivityInjector,HasSupportFragmentInjector {

    @Override
    public void init(Context context) {

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return ModuleInjector.getInstance().activityInjector();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return ModuleInjector.getInstance().supportFragmentInjector();
    }
}
