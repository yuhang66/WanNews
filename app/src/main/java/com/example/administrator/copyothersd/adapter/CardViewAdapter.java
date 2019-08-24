package com.example.administrator.copyothersd.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.copyothersd.R;
import com.example.administrator.copyothersd.entity.NewsEntity;

import java.util.List;

public class CardViewAdapter extends BaseQuickAdapter<NewsEntity.ResultBean.DataBean,BaseViewHolder> {
    Context context;
    public CardViewAdapter(List<NewsEntity.ResultBean.DataBean> data,Context context) {
        super(R.layout.cardview, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsEntity.ResultBean.DataBean item) {
        helper.setText(R.id.card_text,item.getTitle());
        ImageView img = helper.getView(R.id.card_img);
        Glide.with(context).load(item.getThumbnail_pic_s()).into(img);
        helper.addOnClickListener(R.id.top_s);
    }
}
