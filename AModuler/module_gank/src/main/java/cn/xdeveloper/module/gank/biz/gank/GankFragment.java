package cn.xdeveloper.module.gank.biz.gank;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.nio.file.Path;

import javax.inject.Inject;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.inject.mvp.BaseMvpFragment;
import cn.xdeveloper.module.gank.R;

@Route(path = RouterURL.GankModule.FRAGMENT)
public class GankFragment extends BaseMvpFragment<GankContract.Presenter> implements GankContract.View {


    @Inject
    public GankFragment(){}

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gank,null,false);
    }

    @Override
    protected void initData() {

    }
}
