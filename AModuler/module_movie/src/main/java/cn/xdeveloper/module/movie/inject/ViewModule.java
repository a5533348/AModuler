package cn.xdeveloper.module.movie.inject;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import cn.xdeveloper.lib.common.inject.scope.FragmentScope;
import cn.xdeveloper.module.movie.biz.movie.MovieFragment;
import cn.xdeveloper.module.movie.biz.movie.MovieModule;
import cn.xdeveloper.module.movie.biz.newmovie.NewMovieActivity;
import cn.xdeveloper.module.movie.biz.newmovie.NewMovieModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 注册View
 * Created by laiyimin on 2017/11/30.
 */

@Module
public abstract class ViewModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = NewMovieModule.class)
    abstract NewMovieActivity newMovieActivity();

    @FragmentScope
    @ContributesAndroidInjector(modules = MovieModule.class)
    abstract MovieFragment movieFragment();
}
