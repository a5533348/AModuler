package cn.xdeveloper.module.movie.biz.movie;


import cn.xdeveloper.lib.common.inject.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieModule {

    @FragmentScope
    @Binds
    abstract MovieContract.View view(MovieFragment view);


    @FragmentScope
    @Binds
    abstract MovieContract.Presenter presenter(MoviePresenter presenter);

}
