package cn.xdeveloper.module.zhihu.biz.daily;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.inject.mvp.BaseActivity;
import cn.xdeveloper.module.zhihu.R;
import cn.xdeveloper.module.zhihu.R2;
import cn.xdeveloper.module.zhihu.http.dto.ZhihuStory;

@Route(path = RouterURL.ZhihuModule.DAILY)
public class DailyActivity extends BaseActivity<DailyContract.Presenter> implements DailyContract.View {

    @BindView(R2.id.dailyList)
    RecyclerView dailyList;

    DailyAdapter mAdapter;

    @Inject
    public DailyActivity() {
    }

    @Override
    protected int getContentView() {
        getSupportActionBar().setTitle("知乎日报");

        return R.layout.activity_daily;
    }

    @Override
    protected void initData() {
        mAdapter = new DailyAdapter(null);
        dailyList.setLayoutManager(new LinearLayoutManager(mContext));
        dailyList.setAdapter(mAdapter);

        mPresenter.loadDailyList();
    }

    @Override
    public void showList(List<ZhihuStory> stores) {
        mAdapter.setNewData(stores);
    }
}
