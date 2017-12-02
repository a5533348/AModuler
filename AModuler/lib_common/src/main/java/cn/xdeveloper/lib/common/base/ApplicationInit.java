package cn.xdeveloper.lib.common.base;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by laiyimin on 2017/11/21.
 */

public abstract class ApplicationInit implements IProvider {
    @Override
    public void init(Context context) {
        onCreate(context);
    }


    public abstract void onCreate(Context context);
}
