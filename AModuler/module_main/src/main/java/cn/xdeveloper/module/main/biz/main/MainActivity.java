package cn.xdeveloper.module.main.biz.main;


import javax.inject.Inject;

import cn.xdeveloper.common.inject.mvp.BaseActivity;
import cn.xdeveloper.module.main.R;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {


    @Inject
    public MainActivity(){}

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }
}
