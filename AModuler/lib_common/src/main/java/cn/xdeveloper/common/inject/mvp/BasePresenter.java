package cn.xdeveloper.common.inject.mvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import javax.inject.Inject;


public class BasePresenter<V extends IView> {

    protected final String TAG = this.getClass().getSimpleName();

    @Inject
    protected V mView;
    @Inject
    protected Application mApplication;

    public BasePresenter() {
    }

    protected Context getContext() {
        if (mView instanceof Activity) {
            return (Context) mView;
        } else {
            return ((Fragment) mView).getActivity();
        }
    }

    /**
     * RxLifecycle支持
     * @param event
     * @param <T>
     * @return
     */
    protected <T> LifecycleTransformer<T> bindUntilEvent(ActivityEvent event){
        if(mView instanceof RxAppCompatActivity){
            RxAppCompatActivity activity = (RxAppCompatActivity) mView;
            return activity.bindUntilEvent(event);
        }

        throw new RuntimeException("Confirm mView is instance of RxAppCompatActivity");
    }

    /**
     * RxLifecycle支持
     * @param event
     * @param <T>
     * @return
     */
    protected <T> LifecycleTransformer<T> bindUntilEvent(FragmentEvent event){
        if(mView instanceof RxFragment){
            RxFragment fragment = (RxFragment) mView;
            return fragment.bindUntilEvent(event);
        }

        throw new RuntimeException("Confirm mView is instance of RxFragment");
    }

}
