package cn.xdeveloper.module.movie.biz.newmovie;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseActivity;
import cn.xdeveloper.lib.common.inject.mvp.BaseMvpActivity;
import cn.xdeveloper.module.movie.R;
import cn.xdeveloper.module.movie.R2;
import cn.xdeveloper.module.movie.http.dto.MovieItem;


@Route(path = RouterURL.MovieModule.NEW_MOVIE)
public class NewMovieActivity extends BaseMvpActivity<NewMovieContract.Presenter> implements NewMovieContract.View {

    @BindView(R2.id.movieList)
    RecyclerView movieList;

    NewMovieAdapter mAdapter;

    @Inject
    public NewMovieActivity(){}

    @Override
    protected int getContentView() {
        getSupportActionBar().setTitle("电影");
        return R.layout.activity_new_movie;
    }

    @Override
    protected void initData() {
        mAdapter = new NewMovieAdapter(null);
        movieList.setLayoutManager(new LinearLayoutManager(mContext));
        movieList.setAdapter(mAdapter);

        mPresenter.loadNewMovieList();
    }

    @Override
    public void showMovieList(List<MovieItem> list) {
        mAdapter.setNewData(list);
    }
}
