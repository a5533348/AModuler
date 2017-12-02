package cn.xdeveloper.module.zhihu.biz.daily;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;
import cn.xdeveloper.module.zhihu.http.ZhihuService;
import cn.xdeveloper.module.zhihu.http.dto.ZhihuResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DailyPresenter extends BasePresenter<DailyContract.View> implements DailyContract.Presenter {

    @Inject
    ZhihuService mZhihuService;


    @Inject
    DailyPresenter() {

    }


    @Override
    public void onDestroy() {

    }


    @Override
    public void loadDailyList() {
        mZhihuService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhihuResult>() {
                    @Override
                    public void accept(ZhihuResult zhihuResult) throws Exception {
                        mView.showList(zhihuResult.stories);
                    }
                });
    }
}
