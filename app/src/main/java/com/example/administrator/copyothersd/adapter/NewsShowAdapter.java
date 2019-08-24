package com.example.administrator.copyothersd.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.copyothersd.R;
import com.example.administrator.copyothersd.entity.NewsEntity;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class NewsShowAdapter extends BaseQuickAdapter<NewsEntity.ResultBean.DataBean,BaseViewHolder> {
Context context;
    public NewsShowAdapter(List<NewsEntity.ResultBean.DataBean> data,Context context) {

        super(R.layout.first_recycler_tiem, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsEntity.ResultBean.DataBean item) {
            helper.addOnClickListener(R.id.news_top);
            helper.setText(R.id.show_item_text,item.getTitle());
            ImageView logoview = helper.getView(R.id.show_item_img);
            Glide.with(mContext).load(item.getThumbnail_pic_s()).into(logoview);


        }

    }


