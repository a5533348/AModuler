package cn.xdeveloper.module.movie.biz.newmovie;


import cn.xdeveloper.lib.common.inject.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class NewMovieModule {

    @ActivityScope
    @Binds
    abstract NewMovieContract.View view(NewMovieActivity view);


    @ActivityScope
    @Binds
    abstract NewMovieContract.Presenter presenter(NewMoviePresenter presenter);

}
