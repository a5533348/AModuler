package cn.xdeveloper.module.movie.biz.movie;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {


    @Inject
    MoviePresenter() {

    }


    @Override
    public void onDestroy() {

    }


}
