package cn.xdeveloper.module.movie.biz.newmovie;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;
import cn.xdeveloper.module.movie.http.MovieService;
import cn.xdeveloper.module.movie.http.dto.MovieResult;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewMoviePresenter extends BasePresenter<NewMovieContract.View> implements NewMovieContract.Presenter {

    @Inject
    MovieService mMovieService;

    @Inject
    NewMoviePresenter() {

    }


    @Override
    public void onDestroy() {

    }


    @Override
    public void loadNewMovieList() {
        mMovieService.getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieResult>() {
                    @Override
                    public void accept(MovieResult movieResult) throws Exception {
                        mView.showMovieList(movieResult.attention);
                    }
                });
    }
}
