package cn.xdeveloper.module.gank.biz.gank;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;

public class GankPresenter extends BasePresenter<GankContract.View> implements GankContract.Presenter {


    @Inject
    GankPresenter() {

    }


    @Override
    public void onDestroy() {

    }


}
