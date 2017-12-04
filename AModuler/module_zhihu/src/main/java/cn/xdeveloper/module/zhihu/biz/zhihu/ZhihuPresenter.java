package cn.xdeveloper.module.zhihu.biz.zhihu;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;

public class ZhihuPresenter extends BasePresenter<ZhihuContract.View> implements ZhihuContract.Presenter {


    @Inject
    ZhihuPresenter() {

    }


    @Override
    public void onDestroy() {

    }


}
