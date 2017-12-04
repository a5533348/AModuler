package cn.xdeveloper.module.main.biz.main;


import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import butterknife.OnClick;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseActivity;
import cn.xdeveloper.module.main.R;
import cn.xdeveloper.module.main.R2;

public class MainActivity extends BaseActivity {


    @Override
    protected int getContentView() {
        getSupportActionBar().setTitle("AModuler组件化");
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }


    @OnClick(value = {R2.id.btn_gank, R2.id.btn_movie, R2.id.btn_zhihu,R2.id.btn_fragment})
    public void onClick(View view) {
        if (view.getId() == R.id.btn_gank) {
            ARouter.getInstance().build(RouterURL.GankModule.GIRL).navigation();
        } else if (view.getId() == R.id.btn_zhihu) {
            ARouter.getInstance().build(RouterURL.ZhihuModule.DAILY).navigation();
        } else if (view.getId() == R.id.btn_movie) {
            ARouter.getInstance().build(RouterURL.MovieModule.NEW_MOVIE).navigation();
        } else if (view.getId() == R.id.btn_fragment) {
            startActivity(new Intent(mContext, TabActivity.class));
        }
    }
}
