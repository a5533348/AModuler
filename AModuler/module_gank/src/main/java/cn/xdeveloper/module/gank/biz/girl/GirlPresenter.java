package cn.xdeveloper.module.gank.biz.girl;


import javax.inject.Inject;

import cn.xdeveloper.lib.common.inject.mvp.BasePresenter;
import cn.xdeveloper.module.gank.http.dto.GankResult;
import cn.xdeveloper.module.gank.http.GankService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GirlPresenter extends BasePresenter<GirlContract.View> implements GirlContract.Presenter {

    @Inject
    GankService mGankService;

    @Inject
    GirlPresenter() {

    }


    @Override
    public void onDestroy() {

    }


    @Override
    public void loadGirlList() {
        mGankService.getData("福利",20,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GankResult>() {
                    @Override
                    public void accept(GankResult result) throws Exception {
                        if(!result.error){
                            mView.showList(result.results);
                        }
                    }
                });
    }
}
