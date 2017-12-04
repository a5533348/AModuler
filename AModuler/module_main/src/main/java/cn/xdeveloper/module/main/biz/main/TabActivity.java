package cn.xdeveloper.module.main.biz.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.xdeveloper.lib.common.RouterURL;
import cn.xdeveloper.lib.common.base.BaseActivity;
import cn.xdeveloper.module.main.R;
import cn.xdeveloper.module.main.R2;

/**
 * Created by laiyimin on 2017/12/4.
 */

public class TabActivity extends BaseActivity {

    @BindView(R2.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R2.id.viewPager)
    ViewPager viewPager;

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getContentView() {
        return R.layout.activity_tab;
    }

    @Override
    protected void initData() {
        Fragment gankFragment = (Fragment) ARouter.getInstance().build(RouterURL.GankModule.FRAGMENT).navigation();
        Fragment movieFragment = (Fragment) ARouter.getInstance().build(RouterURL.MovieModule.FRAGMENT).navigation();
        Fragment zhihuFragment = (Fragment) ARouter.getInstance().build(RouterURL.ZhihuModule.FRAGMENT).navigation();

        fragmentList.add(gankFragment);
        fragmentList.add(movieFragment);
        fragmentList.add(zhihuFragment);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(fragmentPagerAdapter);

        tabLayout.getTabAt(0).setText("Gank");
        tabLayout.getTabAt(1).setText("电影");
        tabLayout.getTabAt(2).setText("知乎");

    }

    private FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    };


}
