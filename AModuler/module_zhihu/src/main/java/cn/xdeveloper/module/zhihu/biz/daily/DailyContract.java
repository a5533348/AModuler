package cn.xdeveloper.module.zhihu.biz.daily;


import java.util.List;

import cn.xdeveloper.lib.common.inject.mvp.IPresenter;
import cn.xdeveloper.lib.common.inject.mvp.IView;
import cn.xdeveloper.module.zhihu.http.dto.ZhihuStory;

public interface DailyContract {

    interface View extends IView {

        void showList(List<ZhihuStory> stores);
    }

    interface Presenter extends IPresenter {

        void loadDailyList();
    }

}
