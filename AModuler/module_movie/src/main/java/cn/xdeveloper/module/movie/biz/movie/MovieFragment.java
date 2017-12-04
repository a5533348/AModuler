package cn.xdeveloper.module.movie.biz.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import javax.inject.Inject;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.inject.mvp.BaseMvpFragment;
import cn.xdeveloper.module.movie.R;

@Route(path = RouterURL.MovieModule.FRAGMENT)
public class MovieFragment extends BaseMvpFragment<MovieContract.Presenter> implements MovieContract.View {


    @Inject
    public MovieFragment(){}

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie,null,false);
    }

    @Override
    protected void initData() {

    }
}
