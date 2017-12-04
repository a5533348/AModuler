package cn.xdeveloper.module.movie.inject;

import cn.xdeveloper.lib.common.inject.AppComponent;
import cn.xdeveloper.lib.common.inject.scope.ModuleScope;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * <pre>
 *     author : Laiyimin
 *     time   : 2017/11/22
 *     desc   : 为每个模块提供服务
 *     version: 1.0
 * </pre>
 */
@ModuleScope
@Component(
        modules = {
                ApiModule.class,
                ViewModule.class,
                AndroidSupportInjectionModule.class
        }
        , dependencies = AppComponent.class)
public interface ModuleComponent extends AndroidInjector<ModuleInjector> {


}
