package cn.xdeveloper.module.gank.biz.girl;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.xdeveloper.module.gank.R;
import cn.xdeveloper.module.gank.http.dto.GankItem;

/**
 * Created by laiyimin on 2017/12/2.
 */

public class GirlAdapter extends BaseQuickAdapter<GankItem,BaseViewHolder> {

    public GirlAdapter(@Nullable List<GankItem> data) {
        super(R.layout.item_list_girl, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, GankItem item) {
        Glide.with(mContext)
                .load(item.url)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.image));
    }
}
