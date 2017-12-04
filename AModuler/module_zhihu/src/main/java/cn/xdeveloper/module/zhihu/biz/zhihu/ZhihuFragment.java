package cn.xdeveloper.module.zhihu.biz.zhihu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import javax.inject.Inject;

import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.inject.mvp.BaseMvpFragment;
import cn.xdeveloper.module.zhihu.R;


@Route(path = RouterURL.ZhihuModule.FRAGMENT)
public class ZhihuFragment extends BaseMvpFragment<ZhihuContract.Presenter> implements ZhihuContract.View {


    @Inject
    public ZhihuFragment(){}

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zhihu,null,false);
    }

    @Override
    protected void initData() {

    }
}
