package cn.xdeveloper.module.main.biz.main;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    @Inject
    MainPresenter() {

    }


    @Override
    public void onDestroy() {

    }


}
