package cn.xdeveloper.module.movie.biz.newmovie;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.xdeveloper.module.movie.R;
import cn.xdeveloper.module.movie.http.dto.MovieItem;

/**
 * Created by laiyimin on 2017/12/2.
 */

public class NewMovieAdapter extends BaseQuickAdapter<MovieItem,BaseViewHolder> {

    public NewMovieAdapter(@Nullable List<MovieItem> data) {
        super(R.layout.item_list_movie, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieItem item) {
        helper.setText(R.id.tv_title,item.title)
                .setText(R.id.tv_type,"类型：" + item.type)
                .setText(R.id.tv_director,"导演：" + item.director)
                .setText(R.id.tv_actor,"主演：" + item.actor1 + "，" + item.actor2);

        Glide.with(mContext)
                .load(item.image)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.image));
    }
}
