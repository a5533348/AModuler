package cn.xdeveloper.module.gank.biz.girl;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseActivity;
import cn.xdeveloper.lib.common.inject.mvp.BaseMvpActivity;
import cn.xdeveloper.module.gank.R;
import cn.xdeveloper.module.gank.R2;
import cn.xdeveloper.module.gank.http.dto.GankItem;

@Route(path = RouterURL.GankModule.GIRL)
public class GirlActivity extends BaseMvpActivity<GirlContract.Presenter> implements GirlContract.View {

    @BindView(R2.id.girlList)
    RecyclerView girlList;
    GirlAdapter mAdapter;


    @Inject
    public GirlActivity(){}

    @Override
    protected int getContentView() {
        getSupportActionBar().setTitle("Gank.io");
        return R.layout.activity_girl;
    }

    @Override
    protected void initData() {
        mAdapter = new GirlAdapter(null);
        girlList.setLayoutManager(new GridLayoutManager(mContext,2));
        girlList.setAdapter(mAdapter);

        mPresenter.loadGirlList();
    }

    @Override
    public void showList(List<GankItem> results) {
        mAdapter.setNewData(results);
    }
}
