package cn.xdeveloper.module.main.biz.main;


import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import butterknife.OnClick;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.inject.mvp.BaseActivity;
import cn.xdeveloper.module.main.R;
import cn.xdeveloper.module.main.R2;

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


    @OnClick(value = {R2.id.btn_gank,R2.id.btn_github,R2.id.btn_zhihu})
    public void onClick(View view){
        if(view.getId() == R.id.btn_gank){
            ARouter.getInstance().build(RouterURL.GankModule.GIRL).navigation();
        }else if(view.getId() == R.id.btn_zhihu){
            ARouter.getInstance().build(RouterURL.ZhihuModule.DAILY).navigation();
        }
    }
}
