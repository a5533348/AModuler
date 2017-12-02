package cn.xdeveloper.module.gank.biz.girl;


import java.util.List;

import cn.xdeveloper.lib.common.inject.mvp.IPresenter;
import cn.xdeveloper.lib.common.inject.mvp.IView;
import cn.xdeveloper.module.gank.http.dto.GankItem;

public interface GirlContract {

    interface View extends IView {

        void showList(List<GankItem> results);
    }

    interface Presenter extends IPresenter {

        /**
         * 加载列表
         */
        void loadGirlList();
    }

}
