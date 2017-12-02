package cn.xdeveloper.module.zhihu.biz.daily;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.xdeveloper.module.zhihu.R;
import cn.xdeveloper.module.zhihu.http.dto.ZhihuStory;

/**
 * Created by laiyimin on 2017/12/2.
 */

public class DailyAdapter extends BaseQuickAdapter<ZhihuStory, BaseViewHolder> {

    public DailyAdapter(@Nullable List<ZhihuStory> data) {
        super(R.layout.item_list_daily, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhihuStory item) {
        helper.setText(R.id.tv_title,item.title);
        Glide.with(mContext)
                .load(item.images.get(0))
                .centerCrop()
                .into((ImageView) helper.getView(R.id.image));
    }
}
