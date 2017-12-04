package cn.xdeveloper.module.movie.biz.newmovie;


import java.util.List;

import cn.xdeveloper.lib.common.inject.mvp.IPresenter;
import cn.xdeveloper.lib.common.inject.mvp.IView;
import cn.xdeveloper.module.movie.http.dto.MovieItem;

public interface NewMovieContract {

    interface View extends IView {

        void showMovieList(List<MovieItem> list);
    }

    interface Presenter extends IPresenter {

        /**
         * 加载电影列表
         */
        void loadNewMovieList();
    }

}
